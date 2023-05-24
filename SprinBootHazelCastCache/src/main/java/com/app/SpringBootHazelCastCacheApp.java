package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringBootHazelCastCacheApp {
	public static void main(String[] args) {
		SpringApplication.run(SpringBootHazelCastCacheApp.class, args);
		System.out.println("Spring Boot Hazel CastCache App executed.........");
	}

}
