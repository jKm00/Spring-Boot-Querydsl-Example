package com.solwer.blazepersistencetest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solwer.blazepersistencetest.models.Book;
import com.solwer.blazepersistencetest.repositories.book.BookRepository;

@Service
public class BookService {

  @Autowired
  public BookRepository bookRepository;

  public List<Book> findAll() {
    return this.bookRepository.findAll();
  }

  public void add(Book book) {
    this.bookRepository.save(book);
  }
}
