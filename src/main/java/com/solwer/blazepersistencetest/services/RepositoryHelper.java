package com.solwer.blazepersistencetest.services;

import java.util.function.Function;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

/**
 * Generates an entity manager that can be used for custom queries
 */
@Service
public class RepositoryHelper {
  @PersistenceContext
  private EntityManager em;

  @Transactional
  public <E, R> R refreshAndUse(
    E entity,
    Function<E, R> usageFunction) {
      em.refresh(entity);
      return usageFunction.apply(entity);
  }

  /**
   * Returns the entity manager
   * @return the entity manager
   */
  public EntityManager getEntityManager() {
    return this.em;
  }
}
