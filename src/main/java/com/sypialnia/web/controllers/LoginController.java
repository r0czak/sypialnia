package com.sypialnia.web.controllers;

import com.sypialnia.domain.entities.User;
import com.sypialnia.domain.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
  @Autowired private UserRepository userRepository;

  @RequestMapping("/users")
  public Iterable<User> getUsers() {
    return userRepository.findAll();
  }
}
