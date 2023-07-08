package com.AltiriaSpring;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;






@SpringBootApplication
public class AltiriaSpringBootApplication {



	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(AltiriaSpringBootApplication.class, args);
		
		// Obtenemos el Bean de la clase AppThreadService del contexto de Spring y se gaurda en la variable  "appThreadService"
		AppThreadService appThreadService = (AppThreadService) ctx.getBean("appThreadService");
		// Ejecutamos el metodo run() de la clase AppThreadService
		appThreadService.run();
		 System.out.println("Conexión OK");
	}
	
}
