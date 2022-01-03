package com.greatlearning.springbootemployeeapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;


import com.greatlearning.springbootemployeeapp.entity.Employee;

public interface EmployeeService {
	public List<Employee> findAll();
	public void save(Employee theEmployee);
	public void deleteByID(int theId);
	public Employee getEmployeeById(int id);
	public Employee updateEmployeeById(int employeeId, Employee tempEmp);
	public List<Employee> SearchByFirstName(String firstName);
	public List<Employee> getEmployeesSortedByfirstName(Direction direction);

}
