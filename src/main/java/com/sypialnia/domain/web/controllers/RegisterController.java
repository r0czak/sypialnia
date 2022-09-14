package com.sypialnia.domain.web.controllers;

import com.sypialnia.domain.entities.User;
import com.sypialnia.domain.events.RegistrationCompleteEvent;
import com.sypialnia.domain.events.ResendVerificationTokenEvent;
import com.sypialnia.domain.web.services.RegisterService;
import com.sypialnia.domain.web.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
public class RegisterController {
  @Autowired private RegisterService registerService;
  @Autowired private UserService userService;
  @Autowired ApplicationEventPublisher publisher;

  @PostMapping("/register")
  public String registerUser(@RequestBody User user, HttpServletRequest request) {
    user = registerService.registerUser(user);
    publisher.publishEvent(new RegistrationCompleteEvent(createApplicationUrl(request), user));

    return "User registered successfully with id: " + user.getUserId();
  }

  @GetMapping("/resendVerificationToken")
  public String resendVerificationToken(
      @RequestParam("token") String existingToken, HttpServletRequest request) {

    User user = userService.findByVerificationToken(existingToken);
    publisher.publishEvent(new ResendVerificationTokenEvent(createApplicationUrl(request), user, existingToken));

    return "New token sent for user with id: " + user.getUserId();
  }

  @GetMapping("/registrationConfirm")
  public String confirmRegistration(@RequestParam("token") String token) {
    String result = registerService.validateVerificationToken(token);
    if (result.equals("valid")) {
      return "User verified successfully";
    } else if (result.equals("expired")) {
      return "Token expired";
    } else {
      return "Invalid token";
    }
  }

  private String createApplicationUrl(HttpServletRequest request) {
    return "http://"
        + request.getServerName()
        + ":"
        + request.getServerPort()
        + request.getContextPath();
  }
}
