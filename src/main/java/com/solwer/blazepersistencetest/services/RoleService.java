package com.solwer.blazepersistencetest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import com.solwer.blazepersistencetest.models.Role;
import com.solwer.blazepersistencetest.repositories.RoleRepository;

@Service
public class RoleService {
  @Autowired
  private RoleRepository roleRepository;

  /**
   * Adds a role the the database
   * @param role the role to be added
   */
  public void add(Role role) {
    roleRepository.save(role);
  }

  /**
   * Returns all roles in the database
   * @return all roles in the database
   */
  public List<Role> getAll() {
    Iterable<Role> iterable = this.roleRepository.findAll();
    return Streamable.of(iterable).toList();
  }

  /**
   * Returns a role with the rolename given
   * @param roleName the rolename to look for
   * @return a role with the rolename given
   */
  public Role get(String roleName) {
    return this.roleRepository.findByRoleName(roleName);
  }
}
