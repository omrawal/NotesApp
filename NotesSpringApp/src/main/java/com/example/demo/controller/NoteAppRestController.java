package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
	
	int min_range=1,max_range=999;
	
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
	
	@PostMapping("/create_note")
	public String createNewNote(NoteTable note) {
		System.out.println("->>>>>>"+note);
		if(!userDao.existsByUsername(note.getNote_owner())) {
			return("User by Username '"+note.getNote_owner()+"' Not Found");
		}
		else {
			int note_id=note.getNote_id();
			while(noteDao.existsById(note_id)) {
				note_id=((int)(Math.random() * (max_range - min_range + 1) + min_range));
			}
			note.setNote_id(note_id);
			System.out.println(note);
			noteDao.save(note);
			return "Note Added Successfully";
		}
		
	}
	
	
	
	
}
