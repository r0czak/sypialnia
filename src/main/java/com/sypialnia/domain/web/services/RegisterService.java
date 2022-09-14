package com.sypialnia.domain.web.services;

import com.sypialnia.domain.entities.User;
import com.sypialnia.domain.entities.VerificationToken;
import com.sypialnia.domain.repositories.UserRepository;
import com.sypialnia.domain.repositories.VerificationTokenRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;

@Service
@Transactional
@Slf4j
public class RegisterService {
  @Autowired UserService userService;
  @Autowired MailService mailService;
  @Autowired VerificationTokenRepository verificationTokenRepository;
  @Autowired UserRepository userRepository;

  public User registerUser(User user) {
    user = userService.createUser(user);

    mailService.sendRegisterMail(user);
    return user;
  }

  public String validateVerificationToken(String token) {
    log.info("Validating verification token {}", token);
    VerificationToken verificationToken = verificationTokenRepository.findByToken(token);
    if (verificationToken == null) {
      return "invalid";
    }

    User user = userRepository.findByUserId(verificationToken.getUserId());
    Calendar calendar = Calendar.getInstance();
    if (verificationToken.getExpiryDate().getTime() - calendar.getTime().getTime() <= 0) {
      verificationTokenRepository.delete(verificationToken);
      return "expired";
    }

    user.setEnabled((byte) 1);
    userRepository.save(user);
    return "valid";
  }

  public VerificationToken generateNewVerificationToken(String existingToken) {
    log.info("Generating new verification token for token {}", existingToken);
    VerificationToken verificationToken = verificationTokenRepository.findByToken(existingToken);
    verificationToken.updateToken();
    verificationTokenRepository.save(verificationToken);
    return verificationToken;
  }
}
