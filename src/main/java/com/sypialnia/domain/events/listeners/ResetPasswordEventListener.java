package com.sypialnia.domain.events.listeners;

import com.sypialnia.domain.entities.User;
import com.sypialnia.domain.events.ResetPasswordEvent;
import com.sypialnia.domain.web.services.MailService;
import com.sypialnia.domain.web.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Slf4j
public class ResetPasswordEventListener implements ApplicationListener<ResetPasswordEvent> {
  @Autowired UserService userService;
  @Autowired MailService mailService;

  @Override
  public void onApplicationEvent(ResetPasswordEvent event) {
    User user = event.getUser();
    String token = UUID.randomUUID().toString();

    userService.savePasswordResetTokenForUser(token, user);

    String url = event.getAppUrl() + "/resetPasswordConfirm?token=" + token;

    mailService.sendResetPasswordMail(user);
    log.info("Sending mail to user {} with url {}", user.getUsername(), url);
  }
}
