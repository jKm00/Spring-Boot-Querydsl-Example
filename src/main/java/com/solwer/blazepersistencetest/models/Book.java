package com.solwer.blazepersistencetest.models;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.querydsl.core.annotations.QueryEntity;

@Entity
@QueryEntity
@Table(name = Book.TABLE_NAME)
public class Book {
  public static final String TABLE_NAME = "books";
  public static final String PRIMARY_KEY = "book_id";

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = User.PRIMARY_KEY)
  private Long id;

  @Column(name = "title")
  private String title;

  @Column(name = "release_year")
  private Date releaseYear;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "book_author", joinColumns = @JoinColumn(name = Book.PRIMARY_KEY), inverseJoinColumns = @JoinColumn(name = Author.PRIMARY_KEY))
  private Set<Author> authors = new LinkedHashSet<>();

  public Book() {
  }

  public Book(String title, Date releaseYear) {
    this.title = title;
    this.releaseYear = releaseYear;
  }

  public Book(Long id, String title, Date releaseYear) {
    this.id = id;
    this.title = title;
    this.releaseYear = releaseYear;
  }

  public void addAuthor(Author author) {
    this.authors.add(author);
    author.addBook(this);
  }

  // Getters and setters
  public String getTitle() {
    return this.title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Date getReleaseYear() {
    return this.releaseYear;
  }

  public void setReleaseYear(Date releaseYear) {
    this.releaseYear = releaseYear;
  }

  public Set<Author> getAuthors() {
    return this.authors;
  }
}
