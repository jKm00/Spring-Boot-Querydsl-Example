# Spring Boot Querydsl Example

## A small spring boot project with Querydsl

Spring boot project with four models `user`, `role`, `book` and `author`. Querydsl is used for querying with filters.

Accessing /users will return all users. Adding filters like `firstName=name` will filter the users by first name. Any filters equal to the fields of the model is accepted.

To filter by role use filter `roles.roleName=role`, e.g. `roles.roleName=admin`

User repository contains example on how to use JPAQuery together with predicates so you get the best of both worlds.

`BookRepository` is an interface for all available methods implemented in `BookRepositoryImpl`. In this implementation, Querydsl together with Hibernate Query Factory is used to create type-safe queries. Querydsl bindings are also implemented at this level to achive predicates the same way as for the `user`. JpaRepository is used for simple queries that doesn't need custom queries. 

## Setup for dev

- Fork repo
- Open in favorite IDE
- Run `mvn spring-boot:run`

## Features

- Queries with JPA and Querydsl
- Queries with Hibernate Query Factory for type-safe queries
