package com.app.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.app.model.Employee;

@Component
public class Runnner implements CommandLineRunner {
@Override
public void run(String... args) throws Exception {
	Employee e1 = new Employee();
	e1.setEmpId(10);
	e1.setEmpName("Tushar");
	e1.setEmpSal(34.87);
	Employee e2 = new Employee();
	e2.setEmpId(10);
	e2.setEmpName("Tushar");
	e2.setEmpSal(76.65);
	System.out.println(e2.equals(e1));
	
	
}
}
