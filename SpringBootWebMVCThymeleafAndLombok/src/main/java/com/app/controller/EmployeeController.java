package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EmployeeController {
	
@RequestMapping("reg")
public String showEmployee() {
	System.out.println("Hello How Are You");
	return "Register";
}
}
