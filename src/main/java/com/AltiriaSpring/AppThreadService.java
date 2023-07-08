package com.AltiriaSpring;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AltiriaSpring.Service.DBMailMarketing.TblMailCampaignService;
import com.AltiriaSpring.Service.DBMailMarketing.TblMailCreditoService;
import com.AltiriaSpring.Service.DBMailMarketing.TblMailMarketingReporteService;
import com.AltiriaSpring.Service.dbaquamovil.TblDctosPeriodoService;
import com.AltiriaSpring.Service.dbaquamovil.TblLocalesService;
import com.AltiriaSpring.Service.dbaquamovil.TblTercerosService;
import com.AltiriaSpring.EnvioMensajeService;

@Service
public class AppThreadService implements Runnable {
	
	// Se declaran las variables qué serán los parametros
    private int xIdLocal  = 100;
    private Integer xIdPeriodo = 202304;
    private Integer xidCampaigns = 18;
    
    
    //Se realiza la inyección de depencencias de los @service
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
    private TblMailMarketingReporteService tblMailMarketingReporteService;
    
    @Autowired
    private EnvioMensajeService envioMensajeService;
    
//    public AppThreadService(Integer xIdLocal, Integer xIdPeriodo, Integer xidCampaigns) {
//        this.xIdLocal = xIdLocal;
//        this.xIdPeriodo = xIdPeriodo;
//        this.xidCampaigns = xidCampaigns;
//    }
//    
    
   
    
    @Override
    public void run() {
        String[] xNumerosCelularArr = null;
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
            xcreditoLocal = tblMailCreditoService.consultaCreditoLocal(xIdLocal, xidCampaigns);
            xdebitoLocal = tblMailCreditoService.consultaDebitoLocal(xIdLocal, xidCampaigns);
            xIdDcto = tblMailCreditoService.consultaIdDcto(xIdLocal, xidCampaigns);
            xIdMaximoReporte = tblMailMarketingReporteService.obtenerMaximoReporte();
            razonSocial = tblLocalesService.consultarRazonSocial(xIdLocal);
            nombrePeriodo = tblDctosPeriodoService.consultarNombrePeriodo(xIdLocal, xIdPeriodo);
            fechaConRecargo = tblDctosPeriodoService.consultarFechaConRecargo(xIdLocal, xIdPeriodo);
            xNumerosCelularArr = tblTercerosService.consultarNumerosCelular(xIdLocal).toArray(new String[0]);
            
            // Se reemplazan las "xxx" del textoSMS dependiendo el xidCampaigns que le pasemos por parametro
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
                    System.out.println("El idCampaign no existe");
                    return;
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
            if (xcreditoLocal > xdebitoLocal) {
                System.out.println("Credito suficiente para el envio del SMS");
            } else {
                System.out.println("Requiere recargar saldo local: " + xIdLocal);
                return;
            }
            
            System.out.println("xcreditoLocal " + xcreditoLocal);
            System.out.println("xdebitoLocal " + xdebitoLocal);
            
            
             // Recorremos el Array de celulares
            for (String numeroCelular : xNumerosCelularArr) {
            	
            	//Creamos una instancia de la clase EnvioMensajeService y la guardamos en obj1
            	EnvioMensajeService obj1 = new EnvioMensajeService();
            	
            	// A obj1 le pasamos el metodo EnviaSms de la clase EnvioMensajeService y se pasan como parametros numeroCelular, textoSMS
                obj1.EnviaSms(numeroCelular, textoSMS);
                
                tblMailMarketingReporteService.ingresaReporte( xIdLocal, xIdMaximoReporte, xidCampaign, xIdPlantilla, numeroCelular, textoSMS, xIdDcto);
                System.out.println("Registro guardado del local " + xIdLocal + " y El celular: " + numeroCelular);
                }
                
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}
