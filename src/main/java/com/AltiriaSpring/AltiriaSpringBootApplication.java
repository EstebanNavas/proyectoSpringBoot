package com.AltiriaSpring;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.AltiriaSpring.Repository.dbaquamovil.TblDctosPeriodoRepo;
import com.AltiriaSpring.Service.dbaquamovil.TblDctosPeriodoService;
import com.AltiriaSpring.Service.dbaquamovil.TblLocalesService;
import com.AltiriaSpring.Service.dbaquamovil.TblTercerosService;

@SpringBootApplication
public class AltiriaSpringBootApplication {
	
	@Autowired
    private TblLocalesService tblLocalesService;
	@Autowired
	private TblDctosPeriodoService tblDctosPeriodoService;
	
	@Autowired
	private TblTercerosService tblTercerosService;


	public static void main(String[] args) {
		SpringApplication.run(AltiriaSpringBootApplication.class, args);
		
		 System.out.println("Conexión OK");
	        
		
	}
	
	  @PostConstruct
	    public void executeServiceMethod() {
	        tblLocalesService.consultarRazonSocial(100);
	        tblDctosPeriodoService.consultarNombrePeriodo(100, 202304);
	        tblDctosPeriodoService.consultarFechaConRecargo(100, 202304);
	        tblTercerosService.consultarNumerosCelular(100);
	    }
}
