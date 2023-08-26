package com.AltiriaSpring;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AltiriaSpring.Service.DBMailMarketing.TblMailCampaignClienteService;
import com.AltiriaSpring.Service.DBMailMarketing.TblMailCampaignService;
import com.AltiriaSpring.Service.DBMailMarketing.TblMailCreditoService;
import com.AltiriaSpring.Service.DBMailMarketing.TblMailMarketingReporteService;
//import com.AltiriaSpring.Service.dbaquamovil.TblDctosPeriodoService;
import com.AltiriaSpring.Service.dbaquamovil.TblLocalesService;
import com.AltiriaSpring.Service.dbaquamovil.TblTercerosService;
import com.AltiriaSpring.EnvioMensajeService;

@Service
public class AppThreadService implements Runnable {
	
	// Se declaran las variables qué serán los parametros
    private int xIdLocal  = 0;
    private Integer xidCampaigns = 0;

    
    public void setXIdLocal(int xIdLocal) {
        this.xIdLocal = xIdLocal;
    }

    public void setXidCampaigns(int xidCampaigns) {
        this.xidCampaigns = xidCampaigns;
    }
    
    
    //Se realiza la inyección de depencencias de los @service
    @Autowired
    private TblLocalesService tblLocalesService;
    
//    @Autowired
//    private TblDctosPeriodoService tblDctosPeriodoService;
    
    @Autowired
    private TblTercerosService tblTercerosService;
    
    @Autowired
    private TblMailCampaignService tblMailCampaignService;
    
    @Autowired
    private TblMailCreditoService tblMailCreditoService;
    
    @Autowired
    private TblMailMarketingReporteService tblMailMarketingReporteService;
    
    @Autowired
    private EnvioMensajeService envioMensajeService;
    
    @Autowired
    TblMailCampaignClienteService tblMailCampaignClienteService;

    
   
    
    @Override
    public void run() {
        
        List<String> xIdClientes = null;
        List<String> xTelefonoCelular = null;
        String razonSocial = "";
        String nombrePeriodo = "";
        String fechaConRecargo = "";
        String textoSMS = "";
        int xidCampaign = 0;
        int xIdPlantilla = 0;
        int xIdMaximoReporte = 0;
        int xcreditoLocal = 0;
        int xdebitoLocal = 0;
        int xIdDcto = 0;
        String xFechayHora = "";
        
        try {
        	
        	// Se obtienen los diferentes metodos de consulta para las bases de datos dbaquamovil y DBMailMarketing
            textoSMS = tblMailCampaignService.consultarTextoSMS(xIdLocal, xidCampaigns);
            xFechayHora = tblMailCampaignService.consultarFechayHora(xIdLocal, xidCampaigns);
            xidCampaign = tblMailCampaignService.consultarIdCampaign(xIdLocal, xidCampaigns);
            xIdPlantilla = tblMailCampaignService.consultarIdPlantilla(xIdLocal, xidCampaigns);
            xcreditoLocal = tblMailCreditoService.consultaCreditoLocal(xIdLocal);
            xdebitoLocal = tblMailCreditoService.consultaDebitoLocal(xIdLocal);
            xIdDcto = tblMailCreditoService.consultaIdDcto(xIdLocal);
            xIdMaximoReporte = tblMailMarketingReporteService.obtenerMaximoReporte();
            razonSocial = tblLocalesService.consultarRazonSocial(xIdLocal);
//            nombrePeriodo = tblDctosPeriodoService.consultarNombrePeriodo(xIdLocal);
//            fechaConRecargo = tblDctosPeriodoService.consultarFechaConRecargo(xIdLocal);
            xIdClientes = tblMailCampaignClienteService.obtenerIdClientes(xIdLocal, xidCampaigns);
            
            xTelefonoCelular =tblTercerosService.obtenerNumerosCelular(xIdLocal, xidCampaigns);
            
   
           
            
          
            
            
            // Se reemplazan las "xxx" del textoSMS dependiendo el xidCampaigns que le pasemos por parametro
//            switch (xidCampaigns) {
//                case 18:
//                    textoSMS = textoSMS.replaceFirst("xxx", razonSocial)
//                            .replaceFirst("xxx", nombrePeriodo)
//                            .replaceFirst("xxx", fechaConRecargo);
//                    break;
//                case 206:
//                    textoSMS = textoSMS.replaceFirst("xxx", razonSocial)
//                            .replaceFirst("xxx", xFechayHora);
//                    break;
//                default:
//                    System.out.println("El idCampaign no existe");
//                    return;
//            }
            
            // Se guarda el saludo del local en la variable saludo
            String saludo = "Saludos " + razonSocial + " ";
            // Se concatena el saludo con textoSMS
            textoSMS = saludo + textoSMS;
            
            
            // Se cambian los "/" por "-" para que pueda tener un formato valido a la hora de verificar la fecha 
//            fechaConRecargo = fechaConRecargo.replace("/", "-");
//            
//            // Obtenemos la fecha actual
//            LocalDate fechaActual = LocalDate.now();
//            
//            // Obtenemos la fechaConRecargo como LocalDate
//            LocalDate fechaRecargo = LocalDate.parse(fechaConRecargo);
//            
//            // Validamos si la fechaRecargo es menor a la fecha actual 
//            if(fechaRecargo.isBefore(fechaActual)) {
//            	System.out.println("Fecha con recargo es menor a la fecha actual: " + fechaConRecargo);
//            	return;
//            }
            
            
            // Validamos si el credito del local es mayor al debito
            if (xcreditoLocal > xdebitoLocal) {
                System.out.println("Credito suficiente para el envio del SMS");
            } else {
                System.out.println("Requiere recargar saldo local: " + xIdLocal);
                return;
            }
            
            System.out.println("xcreditoLocal " + xcreditoLocal);
            System.out.println("xdebitoLocal " + xdebitoLocal);
            
            
             // Recorremos el Array de celulares
            for (String numeroCelular : xTelefonoCelular) {
            	
            	//Creamos una instancia de la clase EnvioMensajeService y la guardamos en obj1
            	EnvioMensajeService obj1 = new EnvioMensajeService();
            	
            	// A obj1 le pasamos el metodo EnviaSms de la clase EnvioMensajeService y se pasan como parametros numeroCelular, textoSMS
                obj1.EnviaSms(numeroCelular, textoSMS);
                
                //Guardamos un registro por cada sms enviado en la tabla tblMailMarketingReporte
                tblMailMarketingReporteService.ingresaReporte( xIdLocal, xIdMaximoReporte, xidCampaign, xIdPlantilla, numeroCelular, textoSMS, xIdDcto);
                System.out.println("Registro guardado del local " + xIdLocal + " y El celular: " + numeroCelular);
                
                // Ingrementamos el bedito del local por cada sms enviado en la tabla tblMailCredito
                tblMailCreditoService.incrementarDebito(xIdLocal, xIdDcto);
                }
                
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}
