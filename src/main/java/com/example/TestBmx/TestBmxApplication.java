package com.example.TestBmx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.example.TestBmx")
public class TestBmxApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestBmxApplication.class, args);
	}

}
