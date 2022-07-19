package com.solwer.blazepersistencetest.services;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQuery;
import com.solwer.blazepersistencetest.models.QUser;
import com.solwer.blazepersistencetest.models.Role;
import com.solwer.blazepersistencetest.models.User;
import com.solwer.blazepersistencetest.repositories.UserRepository;

@Service
public class UserService {
  @Autowired
  private UserRepository userRepository;
  @Autowired
  private RepositoryHelper repositoryHelper;
  @Autowired
  private RoleService roleService;
  
  /**
   * Returns a list of all users stored in the databse
   * @predicate The predicate to use when querying the database
   * @return a list of all users
   */
  public List<User> getAll(Predicate predicate) {
    Iterable<User> iterable = userRepository.findAll(predicate);
    return Streamable.of(iterable).toList();
  }

  /**
   * Adds a user to the database
   * @param user the user to be added
   */
  public void add(User user) {
    this.userRepository.save(user);
  }

  /**
   * Returns all admins in the database with the given predicate
   * @param predicate the predicate to use when querying the database
   * @return all admins
   */
  public List<User> getAdmins(Predicate predicate) {
    EntityManager em = this.repositoryHelper.getEntityManager();

    Role admin = this.roleService.get("ADMIN");

    return new JPAQuery<>(em)
      .select(QUser.user)
      .from(QUser.user)
      .where(QUser.user.roles.any().eq(admin))
      .where(predicate)
      .fetch();
  }

  /**
   * Returns the number of all users stored in the database
   * @return number of users stored in the database
   */
  public long size() {
    return this.userRepository.count();
  }
}
