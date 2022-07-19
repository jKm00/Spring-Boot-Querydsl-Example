package com.solwer.blazepersistencetest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class BlazePersistenceTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlazePersistenceTestApplication.class, args);
	}

}
