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
import com.example.demo.repository.UserTableDao;

@Controller
public class NoteAppController {
	
	@Autowired
	UserTableDao userDao;
	
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
		return noteList.toString();
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
	public String createNote(@RequestParam(name="note_title") String note_title,
			@RequestParam()String note_description,@RequestParam()String note_owner) {

		NoteTable newNote=new NoteTable();
		newNote.setNote_id((int)(Math.random() * (max_range - min_range + 1) + min_range));
		newNote.setNote_description(note_description);
		newNote.setNote_title(note_title);
		UserTable user=userDao.getByUsername(note_owner);
		if(user==null) {
			return "User '"+note_owner+"' does not exist";
		}
		newNote.setNote_owner(user);
		noteList.add(newNote);
		return "Note Added Successfully";
	}
	
	

}
