package com.example.demo.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


//@Component
@Entity(name="note_table")
public class NoteTable {
	@Id
	private int note_id=111;
	private String note_owner;
	private String note_title="no_title";
	private String note_description="no_description";
	public int getNote_id() {
		return note_id;
	}
	public void setNote_id(int note_id) {
		this.note_id = note_id;
	}
	public String getNote_owner() {
		return note_owner;
	}
	public void setNote_owner(String note_owner) {
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
