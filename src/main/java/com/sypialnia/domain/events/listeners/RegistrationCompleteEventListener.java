package com.sypialnia.domain.events.listeners;

import com.sypialnia.domain.entities.User;
import com.sypialnia.domain.events.RegistrationCompleteEvent;
import com.sypialnia.domain.web.services.MailService;
import com.sypialnia.domain.web.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Slf4j
public class RegistrationCompleteEventListener
    implements ApplicationListener<RegistrationCompleteEvent> {
  @Autowired private UserService userService;
  @Autowired private MailService mailService;

  @Override
  public void onApplicationEvent(RegistrationCompleteEvent event) {
    // Create the verification token for the user with url
    User user = event.getUser();
    String token = UUID.randomUUID().toString();
    userService.saveVerificationTokenForUser(token, user);

    String url = event.getAppUrl() + "/registrationConfirm?token=" + token;

    // Send mail to user with url
    mailService.sendRegisterMail(user);
    log.info("Sending mail to user {} with url {}", user.getUsername(), url);
  }
}
