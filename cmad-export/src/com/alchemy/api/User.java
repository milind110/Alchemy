package com.alchemy.api;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@Entity
public class User {
	
	//TODO change this to a unique user ID later on.
	@Id
	private String email;
	private String name;

	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public User(String name, String email) {
		this.name = name;
		this.email = email;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
