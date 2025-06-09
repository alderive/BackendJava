package com.example.TestBmx.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.TestBmx.Entitys.User;

@Service
public interface ServiceUser {
	
		
	public User save(User user) throws Exception;
	
	public List<User> findAll() throws Exception;
	
	public Optional<User> getUserById(Integer id) throws Exception;
	
	 public void deleteUserById(Integer id) throws Exception; 
	
}
