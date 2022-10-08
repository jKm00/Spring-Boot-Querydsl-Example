package com.solwer.blazepersistencetest.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.hibernate.HibernateQueryFactory;
import com.solwer.blazepersistencetest.models.Book;
import com.solwer.blazepersistencetest.models.QBook;

public class BookRepositoryImpl implements BookRepository {

  @Autowired
  private HibernateQueryFactory queryFactory;
  @Autowired
  private BookRepositoryJpa jpaRepository;

  @Autowired
  private QBook qBook = QBook.book;

  @Override
  public List<Book> findAll() {
    return this.jpaRepository.findAll();
  }

  @Override
  public Book findById(Long id) {
    return this.queryFactory.from(qBook)
      .select(
        Projections.constructor(
          Book.class,
          qBook.id,
          qBook.title,
          qBook.releaseYear
        )
      )
      .where(qBook.id.eq(id))
      .fetchOne();
  }

  public interface BookRepositoryJpa extends JpaRepository<Book, Long> {}
  
}
