package com.solwer.blazepersistencetest.repositories.author;

import org.springframework.data.jpa.repository.JpaRepository;

import com.solwer.blazepersistencetest.models.Author;

public interface AuthorJpaRepository extends JpaRepository<Author, Long> {

}
