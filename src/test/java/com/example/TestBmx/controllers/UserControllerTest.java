package com.example.TestBmx.controllers;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import com.example.TestBmx.Entitys.User;
import com.example.TestBmx.services.ServiceUser;
import com.example.TestBmx.vo.ApiResponse2;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {

	@Mock
	private ServiceUser serviceUser;

	@InjectMocks
	private UserController userController;

	private User user;

	@BeforeEach
	void setUp() {
		user = new User();
		user.setIduser(999);
		user.setName("Test User");
		user.setEmail("test@example.com");
		user.setStatus(1);
		user.setPassword("123456789");

	}

	@Test
	void testCreateUser() throws Exception {
		when(serviceUser.save(user)).thenReturn(user);
		when(serviceUser.getUserById(user.getIduser())).thenReturn(null);
		ApiResponse2 response = userController.createUser(user);
		assertEquals(200, response.getUserMap().get("Estatus"));
		assertEquals("Usuario realizado de forma satisfactoria", response.getUserMap().get("Mensaje"));
	}

	@Test
	void testDeleteUser() throws Exception {
		when(serviceUser.getUserById(user.getIduser())).thenReturn(Optional.ofNullable(user));
		doNothing().when(serviceUser).deleteUserById(user.getIduser());
		ApiResponse2 response = userController.deleteUser(user);
		assertEquals(200, response.getUserMap().get("Estatus"));
		assertEquals("Usuario eliminado de forma satisfactoria", response.getUserMap().get("Mensaje"));
	}

	@Test
	void testGetUsers() throws Exception {
		when(serviceUser.findAll()).thenReturn(List.of(user));
		ApiResponse2 response = userController.getUsers();
		assertEquals(200, response.getUserMap().get("Estatus"));
		assertEquals("Consulta realizada de forma satisfactoria", response.getUserMap().get("Mensaje"));
	}

	@Test
	void testGetUser() throws Exception {
		when(serviceUser.getUserById(user.getIduser())).thenReturn(Optional.of(user));
		ApiResponse2 response = userController.getUser(user);
		assertEquals(200, response.getUserMap().get("Estatus"));
		assertEquals("Usuario consultad de forma satisfactoria", response.getUserMap().get("Mensaje"));
	}

	@Test
	void testUpdateUser() throws Exception {
		when(serviceUser.getUserById(user.getIduser())).thenReturn(Optional.of(user));
		when(serviceUser.save(user)).thenReturn(user);
		ApiResponse2 response = userController.updateUser(user);
		assertEquals(200, response.getUserMap().get("Estatus"));
		assertEquals("Usuario actualizado de forma satisfactoria", response.getUserMap().get("Mensaje"));
	}

}