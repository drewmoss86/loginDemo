package com.javaProjects.models;

import java.sql.Date;

import javax.persistence.*;
import javax.xml.crypto.Data;

@Entity   //entity stands for a table for a database under models
public class User {

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) //set as auto increment for ID
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	
}
