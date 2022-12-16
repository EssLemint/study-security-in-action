package com.secu.secu.password;

import org.springframework.security.crypto.password.PasswordEncoder;

public class PlainTextPasseordEncoder implements PasswordEncoder {

  @Override
  public String encode(CharSequence rawPassword) {
    return rawPassword.toString();
  }

  @Override
  public boolean matches(CharSequence rawPassword, String encodedPassword) {
    return rawPassword.equals(encodedPassword);
  }

}