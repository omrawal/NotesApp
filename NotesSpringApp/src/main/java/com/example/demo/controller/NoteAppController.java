package com.example.demo.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.NoteTable;
import com.example.demo.model.UserTable;
import com.example.demo.repository.UserTableDao;

@Controller
public class NoteAppController {
	
	@Autowired
	UserTableDao userDao;
	
	int min_range=1,max_range=999;
	public List<UserTable> userList=new ArrayList<>();
	public List<NoteTable> noteList=new ArrayList<>();
	
	@RequestMapping("/")
	public String homepage() {
		return "index.jsp";
	}
	
	@RequestMapping("/getUser")
	@ResponseBody
	public String userpage() {
		return userList.toString();
	}
	
	@RequestMapping("/getNote")
	@ResponseBody
	public String notepage() {
		return noteList.toString();
	}
	
	@RequestMapping("/addUser")
	public String createUser(UserTable user) {
		if(!userDao.existsByUsername(user.getUsername())) {
			userDao.save(user);
			userList.add(user);
			System.out.println("Success");
		}
		else {
			System.out.println("Username '"+user.getUsername()+"' Not unique");
		}
		
		return "index.jsp";
	}
	
	private UserTable getNoteUserIfExist(String username) {
		for(UserTable user:userList) {
			if(user.getUsername().equals(username)) {
				return user;
			}
		}
		return null;
	}
	
	@RequestMapping("/addNote")
	@ResponseBody()
	public String createNote(@RequestParam(name="note_title") String note_title,
			@RequestParam()String note_description,@RequestParam()String note_owner) {

		NoteTable newNote=new NoteTable();
		newNote.setNote_id((int)(Math.random() * (max_range - min_range + 1) + min_range));
		newNote.setNote_description(note_description);
		newNote.setNote_title(note_title);
		UserTable user=getNoteUserIfExist(note_owner);
		if(user==null) {
			return "User '"+note_owner+"' does not exist";
		}
		newNote.setNote_owner(user);
		noteList.add(newNote);
		return "Note Added Successfully";
	}
	
	

}
