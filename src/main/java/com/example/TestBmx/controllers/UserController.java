package com.example.TestBmx.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.TestBmx.Entitys.User;
import com.example.TestBmx.services.ServiceUser;
import com.example.TestBmx.vo.ApiResponse2;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	ServiceUser service;

	
	
	/**
	 * Method for save record of entity User
	 * @param user is the object to save
	 * @return ApiResponse2 with 
	 * 			Estatus  Code 200(Ok) or 121(Fail)
	 * 			Mensaje  Information about result of service invoked
	 * 			Data     Object resulted
	 */
	@PostMapping("/save")
    public ApiResponse2 createUser(@RequestBody User user) {
		System.out.println("Received request: " + user);
		ApiResponse2 response = new ApiResponse2();
		Map<String, Object> retorno = new HashMap<>();
		try {
			if (user.getIduser() != null && user.getIduser() > 0) {
				Optional<User> usre = service.getUserById(user.getIduser());
				if(usre != null) {
					throw new Exception("El usuario ya existe.");
				}
				
			}
			User usr = service.save(user);
			retorno.put("Estatus", 200);
			retorno.put("Mensaje", "Usuario realizado de forma satisfactoria");
			retorno.put("Data", usr);	
		} catch (Exception e) {
			retorno.put("Estatus", 150);
			retorno.put("mensaje", "Ocurrio un error, favor de indicar a su administrador de sistema: " + e.getMessage());
			retorno.put("Data", user);			
		} 
			response.setUserMap(retorno);
			return response;
		
    }
	
	/**
	 * Method for delete record of entity User
	 * @param user is the object to delete
	 * @return ApiResponse2 with 
	 * 			Estatus         Code 200(Ok) or 121(Fail)
	 * 			Mensaje         Information about result of service invoked
	 * 			Data, Data1     Object resulted
	 */
	@PostMapping("/delete")
    public ApiResponse2 deleteUser(@RequestBody User user) {
		System.out.println("Received request: " + user);
		ApiResponse2 response = new ApiResponse2();
		Map<String, Object> retorno = new HashMap<>();
		try {
			if (user.getIduser() != null && user.getIduser() > 0) {
				Optional<User> usre = service.getUserById(user.getIduser());
				if(usre != null) {
					service.deleteUserById(user.getIduser());
					retorno.put("Estatus", 200);
					retorno.put("Mensaje", "Usuario eliminado de forma satisfactoria");
					retorno.put("Data", user);	
				}else {
					throw new Exception("El usuario no existe.");
				}
			}
			
		} catch (Exception e) {
			retorno.put("Estatus", 122);
			retorno.put("mensaje", "Ocurrio un error, favor de indicar a su administrador de sistema: " + e.getMessage());
			retorno.put("Data", user);			
		} 
			response.setUserMap(retorno);
			return response;
		
    }
	
	
	/**
	 * Method for get all records of entity User
	 * @param N/A
	 * @return ApiResponse2 with 
	 * 			Estatus         Code 200(Ok) or 121(Fail)
	 * 			Mensaje         Information about result of service invoked
	 * 			Data, Data1     Objects resulted
	 */
	@GetMapping("/getUsers")
    public ApiResponse2 getUsers() {
		ApiResponse2 response = new ApiResponse2();
		Map<String, Object> retorno = new HashMap<>();
		try {			
			retorno.put("Estatus", 200);
			retorno.put("Mensaje", "Consulta realizada de forma satisfactoria");
			List<User> consulta = service.findAll();
			if (consulta.isEmpty()) {
			    System.out.println("No data found!");
			}

			retorno.put("Data", consulta);				
			} catch (Exception e) {
			retorno = new HashMap<>();
			retorno.put("Estatus", 123);
			retorno.put("mensaje", "Ocurrio un error, favor de indicar a su administrador de sistema: " + e.getMessage());			
		} 
			response.setUserMap(retorno);
			return response;
		
    }
	
	/**
	 * Method for get record of entity User
	 * @param user is the object to find
	 * @return ApiResponse2 with 
	 * 			Estatus         Code 200(Ok) or 121(Fail)
	 * 			Mensaje         Information about result of service invoked
	 * 			Data            Object resulted
	 */
	@GetMapping("/getUser")
    public ApiResponse2 getUser(@RequestBody User user) {
		ApiResponse2 response = new ApiResponse2();
		Map<String, Object> retorno = new HashMap<>();
		try {			
			if (user.getIduser() != null && user.getIduser() > 0) {
				Optional<User> usre = service.getUserById(user.getIduser());
				if(usre == null) {
					throw new Exception("El usuario no existe.");
				} else {
					retorno.put("Estatus", 200);
					retorno.put("Mensaje", "Usuario consultad de forma satisfactoria");
					retorno.put("Data", usre);	
				}
			}
			} catch (Exception e) {
			retorno = new HashMap<>();
			retorno.put("mensaje", "Ocurrio un error, favor de indicar a su administrador de sistema: " + e.getMessage());			
		} 
			response.setUserMap(retorno);
			return response;
		
    }
	
	

	/**
	 * Method for update record of entity User
	 * @param user is the object to update
	 * @return ApiResponse2 with 
	 * 			Estatus         Code 200(Ok) or 121(Fail)
	 * 			Mensaje         Information about result of service invoked
	 * 			Data            Object resulted
	 */
	
	@PostMapping("/update")
    public ApiResponse2 updateUser(@RequestBody User user) {
		System.out.println("Received request: " + user);
		ApiResponse2 response = new ApiResponse2();
		Map<String, Object> retorno = new HashMap<>();
		try {
			if (user.getIduser() != null && user.getIduser() > 0) {
				Optional<User> usre = service.getUserById(user.getIduser());
				if(usre == null) {
					throw new Exception("El usuario no existe.");
				}				
			}
			User usr = service.save(user);
			retorno.put("Estatus", 200);
			retorno.put("Mensaje", "Usuario actualizado de forma satisfactoria");
			retorno.put("Data1", usr);	
		} catch (Exception e) {
			retorno.put("mensaje", "Ocurrio un error, favor de indicar a su administrador de sistema: " + e.getMessage());
			retorno.put("Data", user);			
		} 
			response.setUserMap(retorno);
			return response;
		
    }

}

	
	

