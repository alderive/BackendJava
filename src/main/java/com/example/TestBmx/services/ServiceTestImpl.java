package com.example.TestBmx.services;

import org.springframework.stereotype.Service;

@Service
public class ServiceTestImpl implements ServiceTest {

	@Override
	public String getCstomer(String id) throws Exception {
		// TODO Auto-generated method stub
		return "mensaje desde el servicio";
	}

}
