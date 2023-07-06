package com.AltiriaSpring;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.AltiriaSpring.Service.DBMailMarketing.TblMailCampaignService;
import com.AltiriaSpring.Service.DBMailMarketing.TblMailCreditoService;
import com.AltiriaSpring.Service.DBMailMarketing.TblMailMarketingReporteService;
import com.AltiriaSpring.Service.dbaquamovil.TblDctosPeriodoService;
import com.AltiriaSpring.Service.dbaquamovil.TblLocalesService;
import com.AltiriaSpring.Service.dbaquamovil.TblTercerosService;


@Component
public class AppThreadAltiraSpring implements Runnable{
	
	private Integer  xIdLocal;
    private Integer  xIdPeriodo;
    private Integer  xidCampaigns;
    
    
    // Creamos un cosntructor de la clase AppThread y le pasamos como parametros las varibales xIdLocal y xIdPeriodo
    public AppThreadAltiraSpring(Integer  xIdLocal, Integer  xIdPeriodo, Integer  xidCampaigns) {
        this.xIdLocal = xIdLocal;
        this.xIdPeriodo = xIdPeriodo;
        this.xidCampaigns = xidCampaigns;
    }
	
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

	
	
	public void run() {
	
			

		     
		     String[] xNumerosCelularArr =null; // aquamovil
		     String razonSocial= ""; // aquamovil
		     String nombrePeriodo = ""; // aquamovil
		     String fechaConRecargo = "";// aquamovil
		     //String xTextoMensaje="";
		     
		    
		     
		        try {
		        	
			        // Obtenemos la conexión a la base de datos DBMailmarketing	  
			      
			        
			        String textoSMS= "";  //Acá guardamos el texto obtenido en el método consultarTextoSMS de la clase BDMailMarketing

				    int xidCampaign = 0;
				    int xIdPlantilla = 0;
				    int xIdMaximoReporte = 0;
				    
				    int xcreditoLocal = 0;
				    int xdebitoLocal = 0;
				    int xIdDcto = 0;
				    String xFechayHora = "";
				    
				    
				  //Obtenemos la consultas a la base de datos BDMailMarketing con sus respectivos métodos
				    textoSMS = tblMailCampaignService.consultarTextoSMS(xIdLocal, xidCampaigns);
				    xFechayHora = tblMailCampaignService.consultarFechayHora(xIdLocal, xidCampaigns);
				    xidCampaign =tblMailCampaignService.consultarIdCampaign(xIdLocal, xidCampaigns);
				    xIdPlantilla = tblMailCampaignService.consultarIdPlantilla(xIdLocal, xidCampaigns);
			        
				    xcreditoLocal = tblMailCreditoService.consultaCreditoLocal(xIdLocal, xidCampaigns);
				    xdebitoLocal = tblMailCreditoService.consultaDebitoLocal(xIdLocal, xidCampaigns);
				    xIdDcto = tblMailCreditoService.consultaIdDcto(xIdLocal, xidCampaigns);
			        
				    xIdMaximoReporte = tblMailMarketingReporteService.obtenerMaximoReporte();
				    
				  
				    
				    
				  //Obtenemos la consultas a la base de datos bdaquamovil con sus respectivos métodos 
				    razonSocial = tblLocalesService.consultarRazonSocial(xIdLocal);
				    nombrePeriodo = tblDctosPeriodoService.consultarNombrePeriodo(xIdLocal, xIdPeriodo);
				    fechaConRecargo = tblDctosPeriodoService.consultarFechaConRecargo(xIdLocal, xIdPeriodo);
				    xNumerosCelularArr = tblTercerosService.consultarNumerosCelular(xIdLocal).toArray(new String[0]);
				
				    
				    
				    
			
		            
		            
		            // Reemplazamos los parámetros del texto anteriormente obtenidos en la variable textoSMS
		            switch (xidCampaigns) {
		            case 18:
		                textoSMS = textoSMS.replaceFirst("xxx", razonSocial)
		                                   .replaceFirst("xxx", nombrePeriodo)
		                                   .replaceFirst("xxx", fechaConRecargo);
		                break;
		            case 200:
		                textoSMS = textoSMS.replaceFirst("xxx", razonSocial)
		                                   .replaceFirst("xxx", xFechayHora);
		                break;
		            default:
		                System.out.println("El idCampaingn no existe");
		                break;
		        }
		            
		            // Se cambian los "/" por "-" para que pueda tener un formato valido a la hora de verificar la fecha 
		            fechaConRecargo = fechaConRecargo.replace("/", "-");
		            
		            // Obtenemos la fecha actual
		            LocalDate fechaActual = LocalDate.now();
		            
		            // Obtenemos la fechaConRecargo como LocalDate
		            LocalDate fechaRecargo = LocalDate.parse(fechaConRecargo);
		            
		            // Validamos si la fechaRecargo es menor a la fecha actual 
		            if(fechaRecargo.isBefore(fechaActual)) {
		            	System.out.println("Fecha con recargo es menor a la fecha actual: " + fechaConRecargo);
		            	return;
		            }
		            
		            
		            
		            
		            // Validamos si el credito del local es mayor al debito 
		            if(xcreditoLocal > xdebitoLocal) {
		            	System.out.println("Credito suficiente para el envio del sms ");
		            }else {
		            	System.out.println("requiere recargar saldo local: " + xIdLocal);
		            	return;
		            }
		            System.out.println("xcreditoLocal " + xcreditoLocal);
		            System.out.println("xdebitoLocal " + xdebitoLocal);
		            
		 
		            // Recorre array celulares , los textos los arma antes
					for (int i = 0; i < xNumerosCelularArr.length; i++) { // Recorremos cada numero celular del array 
						

						//Por cada iteración creamos una instancia de la clase app llamada obj1 y le pasamos como argumento xNumerosCelularArr[i] y  textoSMS
						AltiriaSpringBootApplication obj1 = new AltiriaSpringBootApplication(xNumerosCelularArr[i], textoSMS);

						//Llamamos al método EnviaSms del objeto obj1 y le pasamos como argumento xNumerosCelularArr[i] y  textoSMS
						obj1.EnviaSms(xNumerosCelularArr[i], textoSMS);
						
						
						

					}// FIN DEL FOR    
		           
		           
		        } catch (SQLException e) {
		            e.printStackTrace();
		        } 


		}//FIN DEL RUN()  ******
	

}