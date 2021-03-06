package com.alchemy.api;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@Entity
public class User {
	
	//TODO change this to a unique user ID later on.
	@Id	
	private String userId;
	private String email;
	private String name;
	private String password;

	public User() {
		// TODO Auto-generated constructor stub
	}
		
	public User(String name, String email, String userId, String password) {
		this.name = name;
		this.email = email;
		this.userId = userId;
		this.password = password;		
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

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
}
