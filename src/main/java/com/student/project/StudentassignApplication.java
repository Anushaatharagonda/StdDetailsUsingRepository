package com.student.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class StudentassignApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentassignApplication.class, args);
	}

}
