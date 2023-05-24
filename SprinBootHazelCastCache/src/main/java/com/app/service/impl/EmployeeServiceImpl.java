package com.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.model.Employee;
import com.app.repo.EmployeeRepository;
import com.app.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository repo;

	@Transactional
	public Integer saveEmployee(Employee e) {
		/*
		 * Employee e1=repo.save(e); Integer id=e1.getEmpId(); return id;
		 */
		return repo.save(e).getEmpId();
	}

	@Transactional(readOnly = true)
	public List<Employee> getAllEmployees() {
		return repo.findAll();
	}

	@Transactional(readOnly = true)
	@Cacheable(value = "emp-cache", key = "#empId")
	public Employee getOneEmployee(Integer empId) {
		Optional<Employee> e = repo.findById(empId);
		if (e.isPresent()) {
			return e.get();
		}
		return null;
	}

	@Transactional
	@CacheEvict(value = "emp-cache", key = "#empId")
	public void deleteEmployee(Integer empId) {
		repo.deleteById(empId);
	}

	@Override
	@CachePut(value = "emp-cache", key = "#empId")
	public void update(Employee e) {
		repo.save(e);
	}
}