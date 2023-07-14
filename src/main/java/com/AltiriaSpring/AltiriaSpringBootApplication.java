package com.AltiriaSpring;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;






@SpringBootApplication
public class AltiriaSpringBootApplication {



	public static void main(String[] args) {
		
		// Verificamos si se proporcionan los argumentos esperados
//        if (args.length != 3) {
//            System.out.println("Se requieren 3 argumentos: xIdLocal, xIdPeriodo, xidCampaigns");
//            return;
//        }
//        // Obtenemos los valores de los argumentos desde la consola
//        int xIdLocal = Integer.parseInt(args[0]);
//        int xIdPeriodo = Integer.parseInt(args[1]);
//        int xidCampaigns = Integer.parseInt(args[2]);
//        int xidPlantilla = Integer.parseInt(args[3]);
//        
        
		ApplicationContext ctx = SpringApplication.run(AltiriaSpringBootApplication.class, args);
		
		// Obtenemos el Bean de la clase AppThreadService del contexto de Spring y se gaurda en la variable  "appThreadService"
		AppThreadService appThreadService = (AppThreadService) ctx.getBean("appThreadService");
		
		// Asignamos los valores de los argumentos a las variables de AppThreadService
//        appThreadService.setXIdLocal(xIdLocal);
//        appThreadService.setXIdPeriodo(xIdPeriodo);
//        appThreadService.setXidCampaigns(xidCampaigns);
//        appThreadService.setXidCampaigns(xidPlantilla);
        
        // Ejecutamos el metodo run() de la clase AppThreadService
		appThreadService.run();
		 System.out.println("Conexión OK");
	}
	
}
