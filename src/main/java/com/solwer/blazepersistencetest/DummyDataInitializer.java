package com.solwer.blazepersistencetest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.StringPath;
import com.solwer.blazepersistencetest.models.QUser;
import com.solwer.blazepersistencetest.models.Role;
import com.solwer.blazepersistencetest.models.User;
import com.solwer.blazepersistencetest.services.RoleService;
import com.solwer.blazepersistencetest.services.UserService;

/**
 * Initializes some data in the database when the app is booted up
 */
@Component
public class DummyDataInitializer implements ApplicationListener<ApplicationReadyEvent> {

  @Autowired
  private UserService userService;
  @Autowired
  private RoleService roleService;

  private final Logger logger = LoggerFactory.getLogger("DummyInit");

  @Override
  public void onApplicationEvent(ApplicationReadyEvent event) {

    StringPath str = QUser.user.firstName;
    Predicate predicate = str.contains("Joakim");
    
    List<User> users = userService.getAll(predicate);

    // Check if databse is populated with dummy data
    if (users.size() <= 0) {

      logger.info("Importing dummy data...");

      Role admin = new Role("ADMIN");
      Role user = new Role("USER");

      roleService.add(admin);
      roleService.add(user);

      User joakim = new User("Joakim", "Edvardsen", "joakim@edvardsen.com", 22);
      User petter = new User("Petter", "Molnes", "petter@molnes.com", 22);
      User hans = new User("Hans", "Hansen", "hans@hansen.com", 23);
      User halvard = new User("Halvard", "Halvardsen", "halvard@halvardsen.com", 22);

      joakim.addRole(user);
      joakim.addRole(admin);

      petter.addRole(user);

      hans.addRole(user);

      halvard.addRole(user);
      halvard.addRole(admin);

      userService.add(joakim);
      userService.add(petter);
      userService.add(hans);
      userService.add(halvard);

      logger.info("Dummy data added, {} users in database", userService.size());
    } else {
      logger.info("Data already imported...");
    }
 
  }
  
}
