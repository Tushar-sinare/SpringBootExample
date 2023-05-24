package com.app.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.model.Employee;

@Controller
@RequestMapping("emp")
public class EmployeeController {
	@RequestMapping("reg")
	public String regPage(ModelMap map) {
		Employee emp = new Employee();
		map.addAttribute("employee", emp);
		return "Register";
	}

	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String saveData(@ModelAttribute Employee employee, ModelMap map) {
		map.addAttribute("emp", employee);
		return "Info";
	}

	@RequestMapping("all")
	public String showDates(ModelMap map) {
		map.addAttribute("message", "Hello UI");
		List<Employee> emps = Arrays.asList(new Employee(), new Employee(), new Employee());
		map.addAttribute("list", emps);
		return "Data";
	}
}
