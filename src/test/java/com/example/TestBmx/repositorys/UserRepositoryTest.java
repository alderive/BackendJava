package com.example.TestBmx.repositorys;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.TestBmx.Entitys.User;

@DataJpaTest(properties = {
	    "spring.datasource.url=jdbc:postgresql://localhost:5432/postgres",
	    "spring.jpa.properties.hibernate.default_schema=testdb",
	    "spring.datasource.username=postgres",
	    "spring.datasource.password=Alemania60."
	})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ExtendWith(SpringExtension.class)
class UserRepositoryTest {
	
	@Autowired
    private UserRepository userRepository;
	
	
	
	private User user;

	
	@BeforeEach
    void setUp() {
		user = new User();
        user.setIduser(5);
        user.setName("John Doe");
        user.setEmail("amrjops@gmail.com.mx");
        user.setPassword("12345678");
        user.setStatus(1);
    }
	
	
	
	
	@Test
    void testFindUserById() {
        Optional<User> user = userRepository.findById(1);
        assertThat(user.isPresent());
        //assertTrue();
    }
	
	@Test
    public void testSaveAndFindById() {
        // Create a new user
        User user = new User();
        user.setIduser(1);
        user.setName("John Doe");

        // Save the user
        userRepository.save(user);

        // Retrieve user by ID
        User foundUser = userRepository.findById(1).orElse(null);
        
     // Verify user exists
        assertThat(foundUser).isNotNull();
        assertThat(foundUser.getName()).isEqualTo("John Doe");
    }



	





}
