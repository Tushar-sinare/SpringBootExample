package com.app.runner;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
@Configuration
@Order(50)
public class SpringBootApplicationRunner implements ApplicationRunner {
@Override
public void run(ApplicationArguments args) throws Exception{
	System.out.println("Hello Application Runner");
}

}
