package com.solwer.blazepersistencetest.configs;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

import org.hibernate.Session;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.blazebit.persistence.Criteria;
import com.blazebit.persistence.CriteriaBuilderFactory;
import com.blazebit.persistence.spi.CriteriaBuilderConfiguration;
import com.querydsl.jpa.hibernate.HibernateQueryFactory;

@Configuration
@EnableJpaRepositories(considerNestedRepositories = true)
@EntityScan("com.solwer.blazepersistencetest.models")
@ComponentScan("com.solwer.blazepersistencetest")
public class BlazePersistenceConfiguartion {

  // JPA Query config
  @PersistenceUnit
  private EntityManagerFactory entityManagerFactory;

  @Bean
  @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
  @Lazy(false)
  public CriteriaBuilderFactory createCriteriaBuilderFactory() {
    CriteriaBuilderConfiguration config = Criteria.getDefault();
    // Add configuration here if default is not good enough for you
    return config.createCriteriaBuilderFactory(entityManagerFactory);
  }

  // Hibernate Query Factory config
  @PersistenceContext
  private EntityManager entityManager;

  @Bean
  Session getSession() {
    return this.entityManager.unwrap(Session.class);
  }

  @Bean
  HibernateQueryFactory getQueryFactory() {
    return new HibernateQueryFactory(this.getSession());
  }
}
