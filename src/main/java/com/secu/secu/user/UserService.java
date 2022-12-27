package com.secu.secu.user;

import com.secu.secu.otp.GenerateCodeUtil;
import com.secu.secu.otp.OtpRepository;
import com.secu.secu.table.Otp;
import com.secu.secu.table.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class UserService {
  @Autowired
  private PasswordEncoder passwordEncoder;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private OtpRepository otpRepository;


  public void auth(User user) {
    Optional<User> userDetail = userRepository.findUserByUsername(user.getUsername());

    User o = userDetail.get();

    if (userDetail.isPresent()) {
      if (passwordEncoder.matches(user.getPassword(), o.getPassword())) {

      }
    }
  }

  private void renewOtp(User user) {
    String code = GenerateCodeUtil.generateCode();

    Optional<Otp> userOtp = otpRepository.findOtpByUsername(user.getUsername());

    if (userOtp.isPresent()) {
      Otp otp = userOtp.get();
      otp.updateOtp(otp.getCode());
    } else {
      Otp otp = new Otp(code, user.getUsername());
      otpRepository.save(otp);
    }
  }

  public boolean check(Otp otpValidated) {
    Optional<Otp> otpByName = otpRepository.findOtpByUsername(otpValidated.getUsername());

    if (otpByName.isPresent()) {
      Otp otp = otpByName.get();
      if (otpValidated.getCode().equals(otp.getCode())) {
        return true;
      }
    }

    return false;
  }
}
