package com.greatlearning.springbootemployeeapp.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.greatlearning.springbootemployeeapp.entity.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
	
	private EntityManager entityManager;
	
	@Autowired
	public EmployeeDAOImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	 }
	
	

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Employee> theQuery =currentSession.createQuery("from Employee", Employee.class);
		List<Employee> employees = theQuery.getResultList();
		return employees;
	}

	@Override
	public Employee findById(int theId) {
		// TODO Auto-generated method stub
		Session currentSession = entityManager.unwrap(Session.class);
		Employee employee = currentSession.get(Employee.class, theId);
		return employee;
	}

	@Override
	public void save(Employee theEmployee) {
		// TODO Auto-generated method stub
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.save(theEmployee);
		
	}

	@Override
	public void deleteByID(int theId) {
		// TODO Auto-generated method stub
		Session currentSession = entityManager.unwrap(Session.class);
		Query theQuery = currentSession.createQuery("delete from employee where id = :employeeId");
		theQuery.setParameter("employeeId",theId);
		theQuery.executeUpdate();
	}
	
}
