package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.Employee;
import com.app.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private EmployeeService service;

	@RequestMapping("/reg")
	public String showReg(Model map) {
		// Form backing object
		map.addAttribute("employee", new Employee());
		return "Register";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveData(@ModelAttribute Employee employee, Model map) {
		// insert into DB
		Integer id = service.saveEmployee(employee);
		map.addAttribute("message", "employee '" + id + "' created");
		// clear form backing object
		map.addAttribute("employee", new Employee());
		return "Register";
	}

	@RequestMapping("/all")
	public String showAll(Model map) {
		// fetch data from DB
		List<Employee> emps = service.getAllEmployees();
		// send data to UI
		map.addAttribute("list", emps);
		return "Data";
	}

	@RequestMapping("/view/{id}")
	public String viewOne(@PathVariable Integer id, Model map) throws Exception {
		Employee e = service.getOneEmployee(id);
		map.addAttribute("ob", e);
		return "View";
	}

	@RequestMapping("/delete/{id}")
	public String deleteOne(@PathVariable Integer id, Model map) {
		service.deleteEmployee(id);
		// fetch all new data
		List<Employee> emps = service.getAllEmployees();
		// send data to UI
		map.addAttribute("list", emps);
		// success message
		map.addAttribute("message", "Employee '" + id + "' deleted");
		return "Data";
	}

	@RequestMapping("/edit")
	public String edit(@RequestParam Integer id, Model map) {
		Employee emp = service.getOneEmployee(id);
		map.addAttribute("employee", emp);
		return "EmployeeDataEdit";
	}

	@RequestMapping("/update")
	public String update(@ModelAttribute Employee e) {
		service.update(e);
		;
		return "redirect:all";
	}
}
