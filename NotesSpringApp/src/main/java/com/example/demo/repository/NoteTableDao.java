package com.example.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.NoteTable;

public interface NoteTableDao extends JpaRepository<NoteTable, Integer>  {
	
}
