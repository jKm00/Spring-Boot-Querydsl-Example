package com.solwer.blazepersistencetest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.solwer.blazepersistencetest.models.Author;
import com.solwer.blazepersistencetest.services.AuthorService;

@RestController
@RequestMapping("/authors")
public class AuthorController {
  @Autowired
  private AuthorService authorService;

  @GetMapping
  public List<Author> getAll() {
    return this.authorService.findAll();
  }
}
