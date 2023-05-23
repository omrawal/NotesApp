package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.NoteTable;
import com.example.demo.model.UserTable;

@Controller
public class NoteAppController {
	
	@RequestMapping("/")
	public String homepage() {
		UserTable user=new UserTable();
		System.out.println(user);
		NoteTable note=new NoteTable();
		System.out.println(note);
		return "index.jsp";
	}
}
