package com.solwer.blazepersistencetest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.querydsl.core.types.Predicate;
import com.solwer.blazepersistencetest.models.User;
import com.solwer.blazepersistencetest.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

  @Autowired
  private UserService userService;
  
  @GetMapping()
  public List<User> getAll(Predicate predicate) {
    return userService.getAll(predicate);
  }

  @GetMapping("/test")
  public List<User> test(Predicate predicate) {
    return userService.test(predicate);
  }
}
