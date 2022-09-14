package com.sypialnia.web.services;

import com.sypialnia.domain.entities.PasswordResetToken;
import com.sypialnia.domain.entities.User;
import com.sypialnia.domain.entities.VerificationToken;
import com.sypialnia.domain.models.PasswordModel;
import com.sypialnia.domain.repositories.PasswordResetTokenRepository;
import com.sypialnia.domain.repositories.UserRepository;
import com.sypialnia.domain.repositories.VerificationTokenRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService {
  @Autowired UserRepository userRepository;
  @Autowired PasswordEncoder passwordEncoder;
  @Autowired VerificationTokenRepository verificationTokenRepository;
  @Autowired PasswordResetTokenRepository passwordResetTokenRepository;

  public User createUser(User user) {
    log.info("Saving new user {} to the database", user.getUsername());
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    return userRepository.save(user);
  }

  public User findUserByEmail(String email) {
    return userRepository.findByEmail(email);
  }

  public User findUserById(Integer id) {
    return userRepository.findByUserId(id);
  }

  public User findByVerificationToken(String verificationToken) {
    return userRepository.findByUserId(
        verificationTokenRepository.findByToken(verificationToken).getUserId());
  }

  public void saveVerificationTokenForUser(String token, User user) {
    log.info("Saving verification token {} for user {}", token, user.getUsername());
    VerificationToken verificationToken = new VerificationToken(token, user);

    verificationTokenRepository.save(verificationToken);
  }

  public void savePasswordResetTokenForUser(String token, User user) {
    log.info("Saving password token {} for user {}", token, user.getUsername());
    PasswordResetToken passwordResetToken = new PasswordResetToken(token, user);

    passwordResetTokenRepository.save(passwordResetToken);
  }

  public void saveNewPassword(User user, PasswordModel passwordModel) {
    user.setPassword(passwordEncoder.encode(passwordModel.getNewPassword()));

    userRepository.save(user);
  }

  public boolean checkIfValidOldPassword(User user, String oldPassword) {
    return passwordEncoder.matches(oldPassword, user.getPassword());
  }
}
