package com.solwer.blazepersistencetest.repositories;

import java.util.List;

import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;

import com.solwer.blazepersistencetest.models.Author;
import com.solwer.blazepersistencetest.models.QAuthor;

public interface AuthorRepository extends QuerydslBinderCustomizer<QAuthor> {
  /**
   * Returns all authors in the database
   * 
   * @return a list of all authors in repo
   */
  List<Author> findAll();

  /**
   * Saves an author to the repo
   * 
   * @param author the author to save
   */
  void save(Author author);
}
