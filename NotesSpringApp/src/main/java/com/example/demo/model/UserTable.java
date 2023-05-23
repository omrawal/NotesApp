package com.example.demo.model;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

//@Entity
@Component
public class UserTable {
//	@Id
	private String username="abc";
	private String password="def";
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "UserTable [username=" + username + ", password=" + password + "]";
	}
	
}
