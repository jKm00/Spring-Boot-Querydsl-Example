package com.solwer.blazepersistencetest.repositories;

import java.util.List;

import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;

import com.solwer.blazepersistencetest.models.Book;
import com.solwer.blazepersistencetest.models.QBook;

public interface BookRepository extends QuerydslBinderCustomizer<QBook> {
  List<Book> findAll();

  Book findById(Long id);
}
