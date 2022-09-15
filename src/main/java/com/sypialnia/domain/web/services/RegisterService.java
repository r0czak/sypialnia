package com.sypialnia.domain.web.services;

import com.sypialnia.domain.entities.User;
import com.sypialnia.domain.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
public class RegisterService {
  @Autowired UserService userService;
  @Autowired MailService mailService;
  @Autowired UserRepository userRepository;

  public User registerUser(User user) {
    user = userService.createUser(user);

    mailService.sendRegisterMail(user);
    return user;
  }
}
