package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.NoteTable;
import com.example.demo.model.UserTable;
import com.example.demo.repository.NoteTableDao;
import com.example.demo.repository.UserTableDao;

@RestController
public class NoteAppRestController {
	
	@Autowired
	UserTableDao userDao;
	
	@Autowired
	NoteTableDao noteDao;
	
	@GetMapping(path="/getAllUsers")//,produces= {"application/json"})
	public List<UserTable> getAllUsers(){
		return userDao.findAll();
	}
	
	@GetMapping(path="/getAllNotes")
	public List<NoteTable> getAllNotes(){
		return noteDao.findAll();
	}
	
	@GetMapping(path="/get_user/{username}")
	public UserTable getUserByUsername(@PathVariable("username") String username) {
		return userDao.getByUsername(username);
	}
	
	@PostMapping(path="/create_user")
	public String createNewUser (UserTable newUser) {
		System.out.println(newUser);
		if(!userDao.existsByUsername(newUser.getUsername())) {
			userDao.save(newUser);
			return("Success");
		}
		else {
			return("Username '"+newUser.getUsername()+"' Not unique");
		}
//		return "User "+newUser.getUsername()+" Saved Successfully";
	}
	
	
}
