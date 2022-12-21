package com.secu.secu.auth;

import com.secu.secu.user.CustomUserDetails;
import com.secu.secu.user.JpaUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationProviderService implements AuthenticationProvider {

  @Autowired
  private JpaUserDetailService userDetailService;

  @Autowired
  private BCryptPasswordEncoder bCryptPasswordEncoder;

  @Autowired
  private SCryptPasswordEncoder sCryptPasswordEncoder;

  @Override
  public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    String name = authentication.getName();
    String password = authentication.getCredentials().toString();

    CustomUserDetails customUserDetails = userDetailService.loadUserByUsername(name);
    switch (customUserDetails.getUser().getAlgorithm()) {
      case BCRYPT:
        return checkPassword(customUserDetails, password, bCryptPasswordEncoder);
      case SCRYPT:
        return checkPassword(customUserDetails, password, sCryptPasswordEncoder);
    }

    return (Authentication) new BadCredentialsException("Bad credentials");
  }

  private Authentication checkPassword(CustomUserDetails user, String rawPassword,
                                       PasswordEncoder encoder) {
    if (encoder.matches(rawPassword, user.getPassword())) {
      return new UsernamePasswordAuthenticationToken(
          user.getUsername(), user.getPassword(), user.getAuthorities()
      );
    } else {
      throw new BadCredentialsException("Bad credentials");
    }
  }

  @Override
  public boolean supports(Class<?> authentication) {
    return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
  }
}
