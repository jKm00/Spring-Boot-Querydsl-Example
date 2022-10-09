package com.solwer.blazepersistencetest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.solwer.blazepersistencetest.models.Book;

@Repository
public interface BookJpaRepository extends JpaRepository<Book, Long> {

}
