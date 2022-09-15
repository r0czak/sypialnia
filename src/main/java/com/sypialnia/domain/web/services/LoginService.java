package com.sypialnia.domain.web.services;

import com.sypialnia.domain.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
public class LoginService {
  @Autowired private UserService userService;

  @Autowired PasswordEncoder passwordEncoder;
  @Autowired private UserRepository userRepository;
}
