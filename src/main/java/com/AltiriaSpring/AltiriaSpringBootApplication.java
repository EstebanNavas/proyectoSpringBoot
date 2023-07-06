package com.AltiriaSpring;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.AltiriaSpring.Repository.dbaquamovil.TblDctosPeriodoRepo;
import com.AltiriaSpring.Service.DBMailMarketing.TblMailCampaignService;
import com.AltiriaSpring.Service.DBMailMarketing.TblMailCreditoService;
import com.AltiriaSpring.Service.DBMailMarketing.TblMailMarketingReporteService;
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
	
	@Autowired
	private TblMailCampaignService tblMailCampaignService;
	
	@Autowired
	private TblMailCreditoService tblMailCreditoService;
	
	@Autowired
	TblMailMarketingReporteService  tblMailMarketingReporteService;


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
	        
	        tblMailCampaignService.consultarTextoSMS(100, 18);
	        tblMailCampaignService.consultarFechayHora(100, 18);
	        tblMailCampaignService.consultarIdCampaign(100, 18);
	        tblMailCampaignService.consultarIdPlantilla(100, 18);
	        
	        tblMailCreditoService.consultaCreditoLocal(100, 18);
	        tblMailCreditoService.consultaDebitoLocal(100, 18);
	        tblMailCreditoService.consultaIdDcto(100, 18);
	        
	        tblMailMarketingReporteService.obtenerMaximoReporte();
	    }
}
