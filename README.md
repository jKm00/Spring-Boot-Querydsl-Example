# Spring Boot Querydsl Example

## A small spring boot project with Querydsl

Spring boot project with two models `user` and `role` that has a many to many relation. Querydsl is used for querying with filters.

Accessing /users will return all users. Adding filters like `firstName=name` will filter the users by first name. Any filters equal to the fields of the model is accepted.

Accessing /users/admin will return all admins. Adding filters still works:)

## Setup for dev

- Fork repo
- Open in favorite IDE
- Run `mvn spring-boot:run`

## Features

- Queries with JPA and Querydsl

## To come

- Thinking of testing Querdsl together with Blaze Persistence for more complicated queries