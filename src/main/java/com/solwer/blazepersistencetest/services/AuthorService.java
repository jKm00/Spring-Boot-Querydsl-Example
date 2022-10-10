package com.solwer.blazepersistencetest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solwer.blazepersistencetest.models.Author;
import com.solwer.blazepersistencetest.repositories.author.AuthorRepository;

@Service
public class AuthorService {

  @Autowired
  private AuthorRepository repository;

  public List<Author> findAll() {
    return this.repository.findAll();
  }

  public void add(Author author) {
    this.repository.save(author);
  }
}
