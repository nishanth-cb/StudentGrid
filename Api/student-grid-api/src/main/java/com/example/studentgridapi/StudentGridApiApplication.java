package com.example.studentgridapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com.example.studentgridapi" })
public class StudentGridApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentGridApiApplication.class, args);
	}

}
