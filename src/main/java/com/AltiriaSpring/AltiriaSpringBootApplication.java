package com.AltiriaSpring;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;






@SpringBootApplication
public class AltiriaSpringBootApplication {



	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(AltiriaSpringBootApplication.class, args);
		
		AppThreadService appThreadService = (AppThreadService) ctx.getBean("appThreadService");
		appThreadService.run();
		 System.out.println("Conexión OK");
	}
	
}
