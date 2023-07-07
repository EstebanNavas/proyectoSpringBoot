package com.AltiriaSpring;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.annotation.PostConstruct;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;



@SpringBootApplication
public class AltiriaSpringBootApplication {
	//Declaramos las variiables de instancia 
	String numeroCel;
	String textoSms;

	
	// En el constructor de la clase Main inicializamos las variables de instancia numeroCel y textoSms
	public AltiriaSpringBootApplication(String numeroCel, String textoSms){  
			this.numeroCel = numeroCel; // Utilizamos la palabra clave "this"  para hacer referencia a las variables de instancia de la clase
			this.textoSms=textoSms;
	   } 	 



	public static void main(String[] args) {
		SpringApplication.run(AltiriaSpringBootApplication.class, args);
		
		 System.out.println("Conexión OK");
		 
		 
		 

	        
		
	}
	

		
	  
	  
		
}
