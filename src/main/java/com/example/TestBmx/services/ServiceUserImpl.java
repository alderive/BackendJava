package com.example.TestBmx.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TestBmx.Entitys.User;
import com.example.TestBmx.repositorys.UserRepository;

@Service
public class ServiceUserImpl implements ServiceUser {
	
	@Autowired
	UserRepository repo;
	
	
	@Override
	public User save(User user) throws Exception {
		return user = repo.saveAndFlush(user); 
	}

	@Override
	public List<User> findAll() throws Exception {
		return repo.findAll();
	}

	@Override
	public Optional<User> getUserById(Integer id) throws Exception {
		return repo.findById(id);
	}
	
	
	  @Override 
	  public void deleteUserById(Integer id) throws Exception {
		  repo.deleteById(id);
	  }

}
