package com.solwer.blazepersistencetest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.querydsl.core.types.Predicate;
import com.solwer.blazepersistencetest.models.Book;
import com.solwer.blazepersistencetest.repositories.book.BookRepository;

@Service
public class BookService {

  @Autowired
  public BookRepository bookRepository;

  public List<Book> findAll() {
    return this.bookRepository.findAll();
  }

  public List<Book> findAll(Predicate predicate) {
    return this.bookRepository.findAll(predicate);
  }

  public Book findById(Long id) {
    return this.bookRepository.findById(id);
  }

  public void add(Book book) {
    this.bookRepository.save(book);
  }
}
