package com.sypialnia.domain.web.services;

import com.sypialnia.domain.entities.User;
import com.sypialnia.domain.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService {
  @Autowired UserRepository userRepository;
  @Autowired PasswordEncoder passwordEncoder;

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

  public boolean checkIfValidOldPassword(User user, String oldPassword) {
    return passwordEncoder.matches(oldPassword, user.getPassword());
  }
}
