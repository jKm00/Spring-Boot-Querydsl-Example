package com.solwer.blazepersistencetest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import com.solwer.blazepersistencetest.models.Book;
import com.solwer.blazepersistencetest.services.BookService;

@RestController
@RequestMapping("/books")
public class BookController {

  @Autowired
  private BookService bookService;

  @GetMapping
  public List<Book> findAll() {
    return this.bookService.findAll();
  }
}
