package com.solwer.blazepersistencetest.repositories.author;

import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.querydsl.binding.SingleValueBinding;
import org.springframework.stereotype.Repository;

import com.querydsl.core.types.dsl.StringExpression;
import com.querydsl.core.types.dsl.StringPath;
import com.solwer.blazepersistencetest.models.Author;
import com.solwer.blazepersistencetest.models.QAuthor;

@Repository
public class AuthorRepositoryImpl implements AuthorRepository {

  @Autowired
  private AuthorJpaRepository jpaRepository;

  // Create custom bindings
  @Override
  public void customize(QuerydslBindings bindings, QAuthor author) {
    bindings.bind(String.class).first(
        (SingleValueBinding<StringPath, String>) StringExpression::containsIgnoreCase);
  }

  @Override
  public List<Author> findAll() {
    return this.jpaRepository.findAll();
  }

  @Override
  public void save(Author author) {
    this.jpaRepository.save(author);
  }

}
