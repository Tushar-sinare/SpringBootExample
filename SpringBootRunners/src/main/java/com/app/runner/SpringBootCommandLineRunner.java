package com.app.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
@Component
public class SpringBootCommandLineRunner implements CommandLineRunner,
	Ordered{
		@Override
		public void run(String []args) throws Exception{
			System.out.println("Hi CommandLine Runner");
		}
		@Override
		public int getOrder() {
			return 50;
		}
	}


