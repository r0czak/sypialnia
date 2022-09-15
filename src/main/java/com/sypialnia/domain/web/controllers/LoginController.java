package com.sypialnia.domain.web.controllers;

import com.sypialnia.domain.web.services.LoginService;
import com.sypialnia.domain.web.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class LoginController {
  @Autowired private LoginService loginService;
  @Autowired private UserService userService;
  @Autowired ApplicationEventPublisher publisher;

  private String createApplicationUrl(HttpServletRequest request) {
    return "http://"
        + request.getServerName()
        + ":"
        + request.getServerPort()
        + request.getContextPath();
  }
}
