package com.example.TestBmx.Entitys;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="users")
@Data
public class User {
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer iduser;	
	private String name;
	private String email;
	private Integer status;
	private String password;

}
