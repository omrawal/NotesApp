package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NoteAppController {
	
	@RequestMapping("/")
	public String homepage() {
		return "index.jsp";
	}
}
