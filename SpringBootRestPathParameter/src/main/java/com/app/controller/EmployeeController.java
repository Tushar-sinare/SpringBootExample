package com.app.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Employee;

@RestController
@RequestMapping("/emp")
public class EmployeeController {
@GetMapping("/showA")
public String ShowA() {
	return "Hello-String";
}
@GetMapping("/showB")
public Employee ShowB() {
	return new Employee(101,"Tushar",45000d);
}
@GetMapping("/showc")
public List<Employee> ShowC() {
	return Arrays.asList(new Employee(111,"Vishal",95000d),new Employee(112,"Sudha",25000d),new Employee(113,"Vedansh",85000d));
}
@GetMapping("/showd")
public Map<String,Employee> ShowD() {
	Map<String,Employee> empMap = new HashMap<String,Employee>();
	empMap.put("e1", new Employee(121,"Pramod",15000d));
	empMap.put("e1", new Employee(122,"Sachin",45000d));
	empMap.put("e1" , new Employee(123,"Gorkash",65000d));
	return empMap;
}

@GetMapping("showe")
public ResponseEntity<String>showE(){
	ResponseEntity<String> resp = new ResponseEntity<String>("Hello RE", HttpStatus.OK);
	return resp;
}
}
