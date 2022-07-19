package com.solwer.blazepersistencetest.repositories;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.querydsl.binding.SingleValueBinding;
import org.springframework.stereotype.Repository;

import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.StringExpression;
import com.querydsl.core.types.dsl.StringPath;
import com.querydsl.jpa.impl.JPAQuery;
import com.solwer.blazepersistencetest.models.QUser;
import com.solwer.blazepersistencetest.models.Role;
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

    /**
     * Example how to use JPAQuery together with predicates.
     * Entity manager has to be passed as a param, since it can't be
     * initialized directly in the repository.
     * Reason the query is defined here is because, for me, it makes
     * more sense to have it defined in the repo and not in the service.
     * 
     * @param predicate the predicate to filter the results
     * @param role      role of the users to find
     * @param em        the entity manager to use when querying the database
     * @return a list of users that match the predicate and the role
     */
    default List<User> getUserByRole(Predicate predicate, Role role, EntityManager em) {
      return new JPAQuery<>(em)
          .select(QUser.user)
          .from(QUser.user)
          .where(QUser.user.roles.any().eq(role))
          .where(predicate)
          .fetch();
    }
}
