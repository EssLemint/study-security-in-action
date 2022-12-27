package com.secu.secu.controller;

import com.secu.secu.table.Otp;
import com.secu.secu.table.User;
import com.secu.secu.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
public class AuthController {
  @Autowired
  private UserService userService;

  @GetMapping("/user/auth")
  public void auth(@RequestBody User user) {
    userService.auth(user);
  }

  @PostMapping("/otp/check")
  public void check(@RequestBody Otp otp, HttpServletResponse response) {
    if (userService.check(otp)) {
      response.setStatus(HttpServletResponse.SC_OK);
    } else {
      response.setStatus(HttpServletResponse.SC_FORBIDDEN);
    }
  }
}
