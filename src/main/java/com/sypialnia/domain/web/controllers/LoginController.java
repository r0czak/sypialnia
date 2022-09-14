package com.sypialnia.domain.web.controllers;

import com.sypialnia.domain.entities.User;
import com.sypialnia.domain.events.ResetPasswordEvent;
import com.sypialnia.domain.web.services.LoginService;
import com.sypialnia.domain.models.PasswordModel;
import com.sypialnia.domain.web.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
public class LoginController {
  @Autowired private LoginService loginService;
  @Autowired private UserService userService;
  @Autowired ApplicationEventPublisher publisher;

  @PostMapping("/resetPassword")
  public String resetPassword(
      @RequestBody PasswordModel passwordModel, HttpServletRequest request) {
    User user = userService.findUserByEmail(passwordModel.getEmail());
    if (user != null) {
      publisher.publishEvent(
          new ResetPasswordEvent(createApplicationUrl(request), user, passwordModel));
    }

    return "Password reset token sent to user with id: " + user.getUserId();
  }

  @GetMapping("/resetPasswordConfirm")
  public String savePassword(
      @RequestParam("token") String token, @RequestBody PasswordModel passwordModel) {
    String result = loginService.validatePasswordResetToken(token, passwordModel);
    if (result.equals("valid")) {
      return "Password reset successfully";
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
