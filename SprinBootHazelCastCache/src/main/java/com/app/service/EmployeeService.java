package com.app.service;

import java.util.List;

import com.app.model.Employee;

public interface EmployeeService {
	public Integer saveEmployee(Employee e);

	public List<Employee> getAllEmployees();

	public Employee getOneEmployee(Integer empId);

	public void deleteEmployee(Integer empId);

	public void update(Employee employee);
}
