package com.AltiriaSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AltiriaSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(AltiriaSpringBootApplication.class, args);
		
		System.out.println("Conexión OK");
	}
   
}
