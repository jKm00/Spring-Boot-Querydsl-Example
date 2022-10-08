package com.solwer.blazepersistencetest.models;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.querydsl.core.annotations.QueryEntity;

@Entity
@QueryEntity
@Table(name = Author.TABLE_NAME)
public class Author {
  public static final String TABLE_NAME = "authors";
  public static final String PRIMARY_KEY = "author_id";

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = Author.PRIMARY_KEY)
  private Long id;

  @Column(name = "name")
  private String name;

  @ManyToMany(mappedBy = "authors", fetch = FetchType.LAZY)
  private Set<Book> books = new LinkedHashSet<>();

  public void addBook(Book book) {
    this.books.add(book);
    book.addAuthor(this);
  }

  // Getters and setters
  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Set<Book> getBooks() {
    return this.books;
  }
}
