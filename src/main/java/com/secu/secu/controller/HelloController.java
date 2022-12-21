package com.secu.secu.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class HelloController {

//  @GetMapping("/hello")
//  public String hello() {
//    return "Hello";
//  }

  @GetMapping("/hello")
  public String hello(Authentication authentication) {
    log.info("authentication = {}", authentication);
    return "Hello, " + authentication.getName() + "!";
  }

  @GetMapping("/bye")
  @Async
  public void bye() {
    SecurityContext context = SecurityContextHolder.getContext();
    String name = context.getAuthentication().getName();
  }

}
