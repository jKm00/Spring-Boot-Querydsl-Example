package com.solwer.blazepersistencetest.models;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.querydsl.core.annotations.QueryEntity;

@Entity
@QueryEntity
@Table(name = User.TABLE_NAME)
public class User {
  public static final String TABLE_NAME = "users";
  public static final String PRIMARY_KEY = "user_id";

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = User.PRIMARY_KEY)
  private Long id;

  @Column(name = "first_name")
  private String firstName;

  @Column(name = "last_name")
  private String lastName;

  @Column(name = "email")
  private String email;

  @Column(name = "age")
  private int age;

  @Column(name = "created_at")
  private Date creationDate;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "user_role",
          joinColumns = @JoinColumn(name = User.PRIMARY_KEY),
          inverseJoinColumns = @JoinColumn(name = Role.PRIMARY_KEY)
  )
  private Set<Role> roles = new LinkedHashSet<>();

  public User() {}

  public User(String firstName, String lastName, String email, int age, Date creationDate) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.age = age;
    this.creationDate = creationDate;
  }

  public void addRole(Role role) {
    this.roles.add(role);
  }

  // Getters and setters
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public Set<Role> getRoles() {
    return roles;
  }

  public void setRoles(Set<Role> roles) {
    this.roles = roles;
  }

  public Date getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(Date creationDate) {
    this.creationDate = creationDate;
  }
}
