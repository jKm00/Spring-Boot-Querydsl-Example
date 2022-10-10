package com.solwer.blazepersistencetest.repositories.book;

import java.util.List;

import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;

import com.solwer.blazepersistencetest.models.Book;
import com.solwer.blazepersistencetest.models.QBook;

public interface BookRepository extends QuerydslBinderCustomizer<QBook> {
  List<Book> findAll();

  void save(Book book);
}
