package com.map.assignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.map.assignment"}) //Starting point for application
@EnableJpaRepositories(basePackages = "com.map.assignment.repositories")
@EnableAutoConfiguration
public class FinalAssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinalAssignmentApplication.class, args);
	}
}

