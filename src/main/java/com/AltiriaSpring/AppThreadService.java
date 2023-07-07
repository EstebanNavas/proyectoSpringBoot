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
    private Integer xIdLocal  = 100;
    private Integer xIdPeriodo = 202304;
    private Integer xidCampaigns = 18;
    
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
            
            fechaConRecargo = fechaConRecargo.replace("/", "-");
            LocalDate fechaActual = LocalDate.now();
            LocalDate fechaRecargo = LocalDate.parse(fechaConRecargo);
            
            if (fechaRecargo.isBefore(fechaActual)) {
                System.out.println("Fecha con recargo es menor a la fecha actual: " + fechaConRecargo);
                return;
            }
            
            if (xcreditoLocal > xdebitoLocal) {
                System.out.println("Credito suficiente para el envio del SMS");
            } else {
                System.out.println("Requiere recargar saldo local: " + xIdLocal);
                return;
            }
            
            System.out.println("xcreditoLocal " + xcreditoLocal);
            System.out.println("xdebitoLocal " + xdebitoLocal);
            
            for (String numeroCelular : xNumerosCelularArr) {
            	EnvioMensajeService obj1 = new EnvioMensajeService();
                obj1.EnviaSms(numeroCelular, textoSMS);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
