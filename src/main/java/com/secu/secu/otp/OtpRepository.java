package com.secu.secu.otp;

import com.secu.secu.table.Otp;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OtpRepository extends JpaRepository<Otp, Long> {

  Optional<Otp> findOtpByUsername(String name);
}
