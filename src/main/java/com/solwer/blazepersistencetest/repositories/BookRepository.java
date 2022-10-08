package com.solwer.blazepersistencetest.repositories;

import java.util.List;

import com.solwer.blazepersistencetest.models.Book;

public interface BookRepository {
  List<Book> findAll();

  Book findById(Long id);
}
