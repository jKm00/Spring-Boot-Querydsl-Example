package com.solwer.blazepersistencetest.controllers;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.querydsl.core.types.Predicate;
import com.solwer.blazepersistencetest.models.Book;
import com.solwer.blazepersistencetest.services.BookService;

@RestController
@RequestMapping("/books")
public class BookController {

  @Autowired
  private BookService bookService;

  @GetMapping
  public ResponseEntity<List<Book>> findAll(@RequestParam Optional<Predicate> predicate) {
    if (predicate.isPresent()) {
      // TODO: Make predicates work
      return new ResponseEntity<>(this.bookService.findAll(predicate.get()), HttpStatus.OK);
    }
    return new ResponseEntity<>(this.bookService.findAll(), HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public Book getBookById(@PathVariable Long id) {
    return this.bookService.findById(id);
  }
}
