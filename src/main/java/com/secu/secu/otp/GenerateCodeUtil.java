package com.secu.secu.otp;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public final class GenerateCodeUtil {

  private void GeneratedCodeUtil() {

  }

  public static String generateCode() {
    String code;
    try {
      SecureRandom random = SecureRandom.getInstanceStrong();

      int c  = random.nextInt(9000) + 1000;

      code = String.valueOf(c);
    } catch (NoSuchAlgorithmException e) {
      throw new RuntimeException(e);
    }

    return code;
  }
}
