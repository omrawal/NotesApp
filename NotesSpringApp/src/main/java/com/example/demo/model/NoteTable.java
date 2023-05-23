package com.example.demo.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

//@Entity
@Component
public class NoteTable {
//	@Id
	private int note_id=111;
	@Autowired
	private UserTable note_owner;
	private String note_title="NewTitle";
	private String note_description="NewDescription";
	public int getNote_id() {
		return note_id;
	}
	public void setNote_id(int note_id) {
		this.note_id = note_id;
	}
	public UserTable getNote_owner() {
		return note_owner;
	}
	public void setNote_owner(UserTable note_owner) {
		this.note_owner = note_owner;
	}
	public String getNote_title() {
		return note_title;
	}
	public void setNote_title(String note_title) {
		this.note_title = note_title;
	}
	public String getNote_description() {
		return note_description;
	}
	public void setNote_description(String note_description) {
		this.note_description = note_description;
	}
	@Override
	public String toString() {
		return "NoteTable [note_id=" + note_id + ", note_owner=" + note_owner + ", note_title=" + note_title
				+ ", note_description=" + note_description + "]";
	}
	
	
}
