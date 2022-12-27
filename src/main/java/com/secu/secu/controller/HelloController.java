package com.secu.secu.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
public class HelloController {

  @GetMapping("/hello")
  public String hello(Authentication authentication, HttpServletRequest request) {
    log.info("authentication = {}", authentication);
    return "Hello, " + authentication.getName() + "!";
  }

  @PostMapping("/post/hello")
  public String postHello() {
    log.info("success post");
    return "hello";
  }

  @GetMapping("/admin/hello")
  public String tad(Authentication authentication) {
    log.info("authentication = {}", authentication);
    return "Hello, " + authentication.getName() + "!";
  }

  @GetMapping("/manager/hello")
  public String tman(Authentication authentication) {
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
