package com.sypialnia.domain.web.services;

import com.sypialnia.domain.entities.PasswordResetToken;
import com.sypialnia.domain.entities.User;
import com.sypialnia.domain.models.PasswordModel;
import com.sypialnia.domain.repositories.PasswordResetTokenRepository;
import com.sypialnia.domain.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;

@Service
@Transactional
@Slf4j
public class LoginService {
  @Autowired private UserService userService;

  @Autowired PasswordEncoder passwordEncoder;
  @Autowired private UserRepository userRepository;
  @Autowired private PasswordResetTokenRepository passwordResetTokenRepository;

  public String validatePasswordResetToken(String token, PasswordModel passwordModel) {
    log.info("Validating password reset token {}", token);
    PasswordResetToken passwordResetToken = passwordResetTokenRepository.findByToken(token);
    if (passwordResetToken == null) {
      return "invalidToken";
    }

    User user = userRepository.findByUserId(passwordResetToken.getUserId());
    Calendar calendar = Calendar.getInstance();
    if (passwordResetToken.getExpiryDate().getTime() - calendar.getTime().getTime() <= 0) {
      passwordResetTokenRepository.delete(passwordResetToken);
      return "expired";
    }

    if (userService.checkIfValidOldPassword(user, passwordModel.getOldPassword())) {
      userService.saveNewPassword(user, passwordModel);
      userRepository.save(user);
      return "valid";
    }
    return "invalid old password";
  }
}
