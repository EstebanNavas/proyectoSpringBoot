package com.AltiriaSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.ServerSocket;
import java.nio.channels.FileLock;
import java.util.concurrent.TimeUnit;
import java.net.Socket;

@SpringBootApplication
public class AltiriaSpringBootApplication {

    public static void main(String[] args) {
        // Verificamos si se proporcionan los argumentos esperados
//        if (args.length != 2) {
//            System.out.println("Se requieren 2 argumentos: xIdLocal, xidCampaigns");
//            return;
//        }
//        
//        int xIdLocal = Integer.parseInt(args[0]);
//        int xidCampaigns = Integer.parseInt(args[1]);
        
        
        int xIdLocal = 100;
        int xidCampaigns = 243;
        
        

        // Ejecutamos la aplicación Spring y obtenemos el contexto
        ConfigurableApplicationContext ctx = SpringApplication.run(AltiriaSpringBootApplication.class, args);

        // Obtenemos el Bean de la clase AppThreadService del contexto de Spring y lo guardamos en la variable "appThreadService"
        AppThreadService appThreadService = ctx.getBean(AppThreadService.class);

        // Asignamos los valores de los argumentos a las variables de AppThreadService
        appThreadService.setXIdLocal(xIdLocal);
        appThreadService.setXidCampaigns(xidCampaigns);

        // Ejecutamos el método run() de la clase AppThreadService
        appThreadService.run();
        
        System.out.println("Conexión OK");

        // Cerramos el contexto de Spring para liberar recursos, incluida la EntityManagerFactory
        ctx.close();
    }
}