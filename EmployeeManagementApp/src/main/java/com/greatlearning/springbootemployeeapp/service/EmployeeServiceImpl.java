package com.greatlearning.springbootemployeeapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.greatlearning.springbootemployeeapp.dao.EmployeeDAO;
import com.greatlearning.springbootemployeeapp.entity.Employee;
import com.greatlearning.springbootemployeeapp.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeDAO employeeDAO;
	@Autowired
	EmployeeRepository employeeRepository;
	

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return employeeDAO.findAll();
	}
	

	@Override
	public Employee getEmployeeById(int theId) {
		return employeeRepository.findById(theId).get();
	}
//	public Employee findById(int theId) {
//		// TODO Auto-generated method stub
//		return employeeDAO.findById(theId);
//	}

	@Override
	public void save(Employee theEmployee) {
		// TODO Auto-generated method stub
		employeeDAO.save(theEmployee);
	}

	@Override
	public void deleteByID(int theId) {
		// TODO Auto-generated method stub
		employeeRepository.deleteById(theId);
	}


	@Override
	public Employee updateEmployeeById(int employeeId, Employee tempEmp) {
		// TODO Auto-generated method stub
		Employee empDB = employeeRepository.findById(employeeId).get();
		if(empDB == null) {
			throw new RuntimeException("The Employee cannot be found");	
		}
		empDB.setEmail(tempEmp.getEmail());
		empDB.setFirstName(tempEmp.getFirstName());
		empDB.setLastName(tempEmp.getLastName());
//		employeeRepository.save(empDB);
		
//		return employeeRepository.findById(employeeId).get();
		return employeeRepository.save(empDB);
	}


	@Override
	public List<Employee> SearchByFirstName(String firstName) {
		// TODO Auto-generated method stub
//		List<Employee> list = (List<Employee>) new 
//				 ResponseEntity<List<Employee>>(employeeRepository.
//				 SearchByFirstName(firstName),HttpStatus.OK);
		List<Employee> listEmp = employeeRepository.findByFirstName(firstName);
				 
		return listEmp;
		
	}


	@Override
	public List<Employee> getEmployeesSortedByfirstName(Direction direction) {
		// TODO Auto-generated method stub
		return employeeRepository.findAll(Sort.by(direction, "firstName"));
	}



}
