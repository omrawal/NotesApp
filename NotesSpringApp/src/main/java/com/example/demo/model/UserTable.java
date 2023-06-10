package com.example.demo.model;
import com.example.demo.model.HashFunction;
import java.security.NoSuchAlgorithmException;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "user_table")
//@Component
public class UserTable {
	@Id
	private String username;
	private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) throws NoSuchAlgorithmException {
		this.password = HashFunction.getHashString(password);
	}
	@Override
	public String toString() {
		return "UserTable [username=" + username + ", password=" + password + "]";
	}
	
}
