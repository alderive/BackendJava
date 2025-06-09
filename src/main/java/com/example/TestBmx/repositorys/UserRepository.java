package com.example.TestBmx.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.TestBmx.Entitys.User;

import jakarta.transaction.Transactional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

		
	/*
	 * @Transactional
	 * 
	 * @Query("DELETE  FROM users  WHERE iduser = :userId") void
	 * deleteUserById(@Param("userId") Integer userId);
	 */
	 

}
