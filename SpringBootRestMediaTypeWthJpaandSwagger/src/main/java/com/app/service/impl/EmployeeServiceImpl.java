package com.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.model.Employee;
import com.app.repo.EmployeeRepository;
import com.app.service.IEmployeeService;


@Service
public class EmployeeServiceImpl implements IEmployeeService {
@Autowired

private EmployeeRepository repo;

@Transactional
public Integer saveEmployee(Employee e) {
return repo.save(e).getEmpId();
}
@Transactional
public void updateEmployee(Employee e) {
repo.save(e);
}
@Transactional
public void deleteEmployee(Integer id) {
repo.deleteById(id);
}
@Transactional(readOnly =true)
public Optional<Employee> getOneEmployee(Integer id) {
return repo.findById(id);
}
@Transactional(readOnly = true)
public List<Employee> getAllEmployees() {
return repo.findAll();
}
@Transactional(readOnly = true)
public boolean isPresent(Integer id) {
return repo.existsById(id);
}
}

