package com.example.TestBmx.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.TestBmx.services.ServiceTest;


@RestController
@RequestMapping("/")
public class MyController {
	
	// Inyectar las propiedades desde application.properties
    @Value("${mi.saludo}")
    private String saludo;

    @Value("${mi.nombre}")
    private String nombre;
    
    @Autowired
    ServiceTest service;


	@GetMapping("public/hello")
    public String publicEndpoint() {
		try {
			return service.getCstomer("1");
		} catch (Exception e) {
			return "Ocurrio un error:";
		}
    }
	
	@GetMapping("hello")
    public String privateEndpoint() {
        try {
			return service.getCstomer("1");
		} catch (Exception e) {
			return "Ocurrio un error:";
		}
    }

	@GetMapping("public/saludo")
    public ResponseEntity<String> saludar() {
        try { 
			return ResponseEntity.ok(service.getCstomer("0"));
		} catch (Exception e) {
			return ResponseEntity.ok("Ocurrio un error:");
		}
    }
	
	// Recibir parámetros de consulta con @RequestParam
    @GetMapping("public/buscar")
    public String buscar(@RequestParam("nombre") String nombre, @RequestParam(value = "edad", required = false) Integer edad) {
        String resultado = "Buscando usuario con nombre: " + nombre;
        if (edad != null) {
            resultado += " y edad: " + edad;
        }
        return resultado;
    }

	
    @GetMapping("public/propiedades")
    public String mostrarPropiedades() {
        return saludo + " Soy " + nombre + ".";
    }



}
