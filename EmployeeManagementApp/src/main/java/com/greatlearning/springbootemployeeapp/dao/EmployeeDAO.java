package com.greatlearning.springbootemployeeapp.dao;

import java.util.List;

import com.greatlearning.springbootemployeeapp.entity.Employee;

public interface EmployeeDAO {
	public List<Employee> findAll();
	public Employee findById(int theId);
	public void save(Employee theEmployee);
	public void deleteByID(int theId);

}
