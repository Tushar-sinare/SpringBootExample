package com.app.batch;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@EnableBatchProcessing
@SpringBootApplication

public class SpringBootBatchApp {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootBatchApp.class, args);
System.out.println("Spring Boot Batch Application Executed.......");
	}

}
