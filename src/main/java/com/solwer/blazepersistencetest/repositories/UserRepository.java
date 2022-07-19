package com.solwer.blazepersistencetest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.querydsl.binding.SingleValueBinding;
import org.springframework.stereotype.Repository;

import com.querydsl.core.types.dsl.StringExpression;
import com.querydsl.core.types.dsl.StringPath;
import com.solwer.blazepersistencetest.models.QUser;
import com.solwer.blazepersistencetest.models.User;

@Repository
public interface UserRepository extends
  QuerydslPredicateExecutor<User>,
  QuerydslBinderCustomizer<QUser>, 
  JpaRepository<User, Long> {

    @Override
    default void customize(QuerydslBindings bindings, QUser root) {
        bindings.bind(String.class).first(
          (SingleValueBinding<StringPath, String>) StringExpression::containsIgnoreCase);
    }
}
