package com.app.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Component;

import com.app.util.EmailUtil;

@Component
public class ConsoleRunner implements CommandLineRunner {
	
	@Autowired
	private EmailUtil util;
	

	@Override
	public void run(String... args) throws Exception {
		FileSystemResource file=new FileSystemResource("D:\\Nobel IT\\JAVA\\Book\\Unit4-Collections-Notes.pdf");
		boolean flag=util.send("tusharsinare1995@gmail.com", "AA", "I have mailed from Spring Boot Application but let me know you get it. So I will know my mail Application is developed", file, "Tushar Sinare . 9834052716");
		if(flag) System.out.println("SENT");
		else System.out.println("CHECK PROBLEMS");
		
	}
}
