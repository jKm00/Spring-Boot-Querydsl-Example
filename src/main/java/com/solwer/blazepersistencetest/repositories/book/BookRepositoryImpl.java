package com.solwer.blazepersistencetest.repositories.book;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.querydsl.binding.SingleValueBinding;
import org.springframework.stereotype.Repository;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.StringExpression;
import com.querydsl.core.types.dsl.StringPath;
import com.querydsl.jpa.hibernate.HibernateQueryFactory;
import com.solwer.blazepersistencetest.models.Book;
import com.solwer.blazepersistencetest.models.QBook;

@Repository
public class BookRepositoryImpl implements BookRepository {

  @Autowired
  private HibernateQueryFactory queryFactory;
  @Autowired
  private BookJpaRepository jpaRepository;

  private final QBook qBook = QBook.book;

  // Default/simple jpa queries
  @Override
  public List<Book> findAll() {
    return this.jpaRepository.findAll();
  }

  @Override
  public void save(Book book) {
    this.jpaRepository.save(book);
  }

  // Create custom bindings
  @Override
  public void customize(QuerydslBindings bindings, QBook book) {
    bindings.bind(String.class).first(
        (SingleValueBinding<StringPath, String>) StringExpression::containsIgnoreCase);
  }
}
