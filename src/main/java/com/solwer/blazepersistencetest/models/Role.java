package com.solwer.blazepersistencetest.models;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.querydsl.core.annotations.QueryEntity;

@Entity
@QueryEntity
@Table(name = Role.TABLE_NAME)
public class Role {
  
  public static final String TABLE_NAME = "roles";
  public static final String PRIMARY_KEY = "role_id";

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = Role.PRIMARY_KEY)
  private Long id;

  @Column(name = "role_name")
  private String roleName;

  @JsonIgnore
  @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
  private Set<User> users = new LinkedHashSet<>();

  public Role() {}

  public Role(String roleName) {
    this.roleName = roleName;
  }

  // Getters and setters
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getRoleName() {
    return roleName;
  }

  public void setRoleName(String roleName) {
    this.roleName = roleName;
  }

  public Set<User> getUsers() {
    return users;
  }

  public void setUsers(Set<User> users) {
    this.users = users;
  }
}
