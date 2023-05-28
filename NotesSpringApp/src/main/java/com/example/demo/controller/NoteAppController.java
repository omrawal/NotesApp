package com.example.demo.controller;

import java.security.NoSuchAlgorithmException;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.NoteTable;
import com.example.demo.model.UserTable;
import com.example.demo.model.HashFunction;
import com.example.demo.repository.NoteTableDao;
import com.example.demo.repository.UserTableDao;

@Controller
public class NoteAppController {
	
	@Autowired
	UserTableDao userDao;
	
	@Autowired
	NoteTableDao noteDao;
	
	int min_range=1,max_range=999;
	public List<NoteTable> noteList=new ArrayList<>();
	
	@RequestMapping("/")
	public String homepage() {
		return "index.jsp";
	}
	
	@RequestMapping("/getUser")
	@ResponseBody
	public String userpage() {
		return userDao.findAll().toString();
	}
	
	@RequestMapping("/getNote")
	@ResponseBody
	public String notepage() {
		return noteDao.findAll().toString();
	}
	
	@RequestMapping("/addUser")
	public String createUser(UserTable user) throws NoSuchAlgorithmException {
		if(!userDao.existsByUsername(user.getUsername())) {
			user.setPassword(HashFunction.getHashString(user.getPassword()));
			userDao.save(user);
			System.out.println("Success");
		}
		else {
			System.out.println("Username '"+user.getUsername()+"' Not unique");
		}
		
		return "index.jsp";
	}
	
	
	@RequestMapping("/addNote")
	@ResponseBody()
	public String createNote(NoteTable note) {
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
