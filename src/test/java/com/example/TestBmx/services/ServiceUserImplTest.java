package com.example.TestBmx.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.TestBmx.Entitys.User;
import com.example.TestBmx.repositorys.UserRepository;

@ExtendWith(MockitoExtension.class)
public class ServiceUserImplTest {

    @Mock
    private UserRepository repo;

    @InjectMocks
    private ServiceUserImpl serviceUser;

    private User user;

    @BeforeEach
    void setUp() {
        user = new User();
        user.setIduser(1);
        user.setName("John Doe");
    }

    @Test
    void testSaveUser() throws Exception {
        when(repo.saveAndFlush(user)).thenReturn(user);
        User savedUser = serviceUser.save(user);
        assertNotNull(savedUser);
        assertEquals("John Doe", savedUser.getName());
    }

    @Test
    void testFindAllUsers() throws Exception {
        when(repo.findAll()).thenReturn(Arrays.asList(user));
        assertFalse(serviceUser.findAll().isEmpty());
    }

    @Test
    void testGetUserById() throws Exception {
        when(repo.findById(1)).thenReturn(Optional.of(user));
        Optional<User> foundUser = serviceUser.getUserById(1);
        assertTrue(foundUser.isPresent());
        assertEquals("John Doe", foundUser.get().getName());
    }

    @Test
    void testDeleteUserById() throws Exception {
        doNothing().when(repo).deleteById(1);
        serviceUser.deleteUserById(1);
        verify(repo, times(1)).deleteById(1);
    }
}