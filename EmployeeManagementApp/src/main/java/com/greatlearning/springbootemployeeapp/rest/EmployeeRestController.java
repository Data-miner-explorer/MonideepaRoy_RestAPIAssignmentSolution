package com.greatlearning.springbootemployeeapp.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
//import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Sort.Direction;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.springbootemployeeapp.service.EmployeeService;
import com.greatlearning.springbootemployeeapp.entity.Employee;
//@ComponentScan(basePackages={"com.greatlearning.springbootemployeeapp"})
@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	@Autowired
	EmployeeService employeeservice;
	
	
	@GetMapping("/employees")
	public List<Employee> findAll(){
		return employeeservice.findAll();
	}
	//sort by first name
	@GetMapping("/employees/sort")
	public List<Employee> sortEmpByfName(@RequestParam("order") String dir) {
		Direction sortdir=Sort.Direction.DESC;
		if(dir=="asc") {
			sortdir=Sort.Direction.ASC;
		}
		else {
			sortdir=Sort.Direction.DESC;
		}
		return employeeservice.getEmployeesSortedByfirstName(sortdir);
	}
	@GetMapping("/employees/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId){
		Employee theEmployee =employeeservice.getEmployeeById(employeeId);
		if(theEmployee==null) {
			throw new RuntimeException("Employee id is missing");
		}
		return theEmployee;
	}
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee theEmployee) {
		employeeservice.save(theEmployee);
		return theEmployee;
		
	}
	@PutMapping("/employees/{employeeId}")
	public Employee updateEmployeeById(@PathVariable("employeeId") int employeeId, @RequestBody Employee theEmployee) {
		Employee tempEmp =employeeservice.getEmployeeById(theEmployee.getId());
		if(tempEmp == null) {
			throw new RuntimeException("The Employee cannot be found");
		}
		
		Employee updatedEmp = employeeservice.updateEmployeeById(employeeId, theEmployee);
		return updatedEmp;
	}
	@DeleteMapping("/employees/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId) {
		Employee tempEmp =employeeservice.getEmployeeById(employeeId);
		if(tempEmp == null) {
			throw new RuntimeException("The Employee cannot be found");
		}
		employeeservice.deleteByID(employeeId);
		return ("Deleted employee id - "+employeeId);
	}
	//Search by first name
	@GetMapping("/employees/search/{firstName}")
	public List<Employee> searchByfName(@PathVariable("firstName") String firstName) {
//		return new ResponseEntity<List<Employee>>(employeeservice.SearchByFirstName(firstName),HttpStatus.OK);
		List<Employee> responseList= employeeservice.SearchByFirstName(firstName);
		return responseList;
	}
	
	
}
