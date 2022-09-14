package com.sypialnia.domain.events.listeners;

import com.sypialnia.domain.entities.User;
import com.sypialnia.domain.entities.VerificationToken;
import com.sypialnia.domain.events.ResendVerificationTokenEvent;
import com.sypialnia.domain.web.services.MailService;
import com.sypialnia.domain.web.services.RegisterService;
import com.sypialnia.domain.web.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ResendVerificationTokenEventListener
    implements ApplicationListener<ResendVerificationTokenEvent> {
  @Autowired private UserService userService;
  @Autowired private MailService mailService;
  @Autowired private RegisterService registerService;

  @Override
  public void onApplicationEvent(ResendVerificationTokenEvent event) {
    User user = event.getUser();
    String existingToken = event.getExistingToken();

    VerificationToken newToken = registerService.generateNewVerificationToken(existingToken);

    String url = event.getAppUrl() + "/registrationConfirm?token=" + newToken.getToken();

    mailService.sendResendVerificationTokenMail(user);
    log.info("Sending mail to user {} with url {}", user.getUsername(), url);
  }
}
