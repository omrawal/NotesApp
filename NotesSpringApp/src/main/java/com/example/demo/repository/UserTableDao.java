package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.UserTable;

public interface UserTableDao extends JpaRepository<UserTable, String>  {

	boolean existsByUsername(String username);
	
}
