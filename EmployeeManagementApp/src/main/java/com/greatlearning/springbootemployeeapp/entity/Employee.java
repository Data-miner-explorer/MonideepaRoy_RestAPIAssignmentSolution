package com.greatlearning.springbootemployeeapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Table(name = "employee")
@Data
@NoArgsConstructor
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	@Column(name="email")
	private String email;
	
	public Employee(String fName,String lName, String email) {
		this.firstName = fName;
		this.lastName = lName;
		this.email = email;
	}

}
