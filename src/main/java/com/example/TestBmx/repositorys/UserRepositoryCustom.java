package com.example.TestBmx.repositorys;

import java.util.List;

import com.example.TestBmx.Entitys.User;

public interface UserRepositoryCustom {
	
	
	public List<User> findUsersByCriteria(String name, String email, Integer status, String password) throws Exception;

}
