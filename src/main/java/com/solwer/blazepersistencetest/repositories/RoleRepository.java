package com.solwer.blazepersistencetest.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.solwer.blazepersistencetest.models.Role;

@Repository
public interface RoleRepository extends 
  CrudRepository<Role, Long> {
    Role findByRoleName(String roleName);
}
