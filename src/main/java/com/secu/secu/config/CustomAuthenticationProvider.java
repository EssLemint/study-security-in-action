package com.secu.secu.config;

import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

  @Override
  public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    //인즌 논리 추가
    String userName = authentication.getName();
    String password = authentication.getCredentials().toString();

    if ("user".equals(userName) && "1234".equals(password)) {
      return new UsernamePasswordAuthenticationToken(userName, password, Arrays.asList());
    } else {
      throw new AuthenticationCredentialsNotFoundException("Error in authentication");
    }
  }

  @Override
  public boolean supports(Class<?> authentication) {
    //형식 구현 추가
    return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
  }
}
