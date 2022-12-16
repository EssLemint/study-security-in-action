package com.secu.secu.password;

import org.springframework.security.crypto.password.PasswordEncoder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Sha512PasswordEncoder implements PasswordEncoder {

  @Override
  public String encode(CharSequence rawPassword) {
    return hashWithSha512(rawPassword.toString());
  }

  @Override
  public boolean matches(CharSequence rawPassword, String encodedPassword) {
    String hasedPassword = encode(rawPassword);
    return encodedPassword.equals(hasedPassword);
  }

  private String hashWithSha512(String input) {
    StringBuilder builder = new StringBuilder();

    try {
      MessageDigest md = MessageDigest.getInstance("SHA-512");
      byte[] digested = md.digest(input.getBytes());
      for (byte b : digested) {
        builder.append(Integer.toHexString(0xFF & digested[b]));
      }
    } catch (NoSuchAlgorithmException e) {
      throw new RuntimeException("Bad algorithm");
    }
    return builder.toString();
  }

}
