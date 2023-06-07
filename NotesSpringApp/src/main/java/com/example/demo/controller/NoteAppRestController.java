package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
}
