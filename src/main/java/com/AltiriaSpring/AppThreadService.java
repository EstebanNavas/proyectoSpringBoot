package com.AltiriaSpring;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

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
import com.AltiriaSpring.Model.dbaquamovil.TblTerceros;

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
        Map<String, String> xcelularIdClienteMap  = null;
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
            xcelularIdClienteMap =tblTercerosService.obtenerNumerosCelularYAndIdCliente(xIdLocal, xidCampaigns);
            
   

            
            
            // Validamos si el credito del local es mayor al debito
            if (xcreditoLocal > xdebitoLocal) {
                System.out.println("Credito suficiente para el envio del SMS");
            } else {
                System.out.println("Requiere recargar saldo local: " + xIdLocal);
                return;
            }
            
            System.out.println("xcreditoLocal " + xcreditoLocal);
            System.out.println("xdebitoLocal " + xdebitoLocal);
            
            System.out.println("Contenido de xcelularIdClienteMap antes del bucle: " + xcelularIdClienteMap);
            
             // Recorremos el Array de celulares
            for (String numeroCelular : xTelefonoCelular) {
            	
            	// Obtenemos el ID del cliente correspondiente al número de celular actual
                String idCliente = xcelularIdClienteMap.get(numeroCelular);
            	
                System.out.println("Contenido de xcelularIdClienteMap: " + xcelularIdClienteMap);
                
            	//Creamos una instancia de la clase EnvioMensajeService y la guardamos en obj1
            	EnvioMensajeService obj1 = new EnvioMensajeService();
            	
            	// A obj1 le pasamos el metodo EnviaSms de la clase EnvioMensajeService y se pasan como parametros numeroCelular, textoSMS
                obj1.EnviaSms(numeroCelular, textoSMS);
                
                
                
                //Guardamos un registro por cada sms enviado en la tabla tblMailMarketingReporte
                tblMailMarketingReporteService.ingresaReporte( xIdLocal, xIdMaximoReporte, xidCampaign, xIdPlantilla, numeroCelular, textoSMS, xIdDcto, idCliente);
                System.out.println("Registro guardado del local " + xIdLocal + "  El celular: " + numeroCelular + " Y el idCliente " + idCliente);
                
          
                
                // Ingrementamos el bedito del local por cada sms enviado en la tabla tblMailCredito
                tblMailCreditoService.incrementarDebito(xIdLocal, xIdDcto);
                }
                
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}
