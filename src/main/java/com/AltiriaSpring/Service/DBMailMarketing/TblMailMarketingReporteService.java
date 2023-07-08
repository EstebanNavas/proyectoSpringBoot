package com.AltiriaSpring.Service.DBMailMarketing;

import java.util.Optional;
import java.sql.Timestamp;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AltiriaSpring.Model.DBMailMarketing.TblMailCampaign;
import com.AltiriaSpring.Model.DBMailMarketing.TblMailMarketingReporte;
import com.AltiriaSpring.Repository.DBMailMarketing.TblMailCampaignRepo;
import com.AltiriaSpring.Repository.DBMailMarketing.TblMailMarketingReporteRepo;

@Service
public class TblMailMarketingReporteService {

	@Autowired
	private TblMailMarketingReporteRepo tblMailMarketingReporteRepo;
	
	@Autowired
	private TblMailCampaignRepo tblMailCampaignRepo;
	
	//OBTENEMOS EL REPORTE MÁXIMO DE IDREPORTE
	public Integer obtenerMaximoReporte() {
        Integer maxIdReporte = tblMailMarketingReporteRepo.findMaxIdReporte();
        if (maxIdReporte != null) {
            System.out.println("Query 12 - maxIdReporte: " + maxIdReporte);
            return maxIdReporte;
        } else {
            System.out.println("No se encontró máximo reporte");
            return 0;
        }
    }
	
		public boolean ingresaReporte(int xIdLocal, int xIdMaximoReporte, int xidCampaign, int xIdPlantilla,
			    String xnumerosCelular, String xTextoSMS, int xIdDcto) {
		
    	String xSistema = "aquamovil"; 	
									
    	int xidRequerimiento = 1;						
    	int xestado = 1;
    	String xexception = "";
    	String xemail = "";
    

    	Timestamp xfechaHoraEvento = new Timestamp(System.currentTimeMillis()); 

    	
    	Optional<TblMailCampaign> localesOptional = tblMailCampaignRepo.findByIdLocal(xIdLocal);
    	TblMailCampaign localesReporte = localesOptional.get();
    	
		    TblMailMarketingReporte reporte = new TblMailMarketingReporte();
		    
		    reporte.setLocalesReporte(localesReporte); //IdLocal
		    reporte.setSistema(xSistema);
		    reporte.setIdCampaign(xidCampaign);
		    reporte.setIdPlantilla(xIdPlantilla);
		    reporte.setIdDcto(xIdDcto);
		    reporte.setIdRequerimiento(xidRequerimiento);
		    reporte.setDocumentoTercero(xnumerosCelular);
		    
		    reporte.setEstado(xestado);
		    reporte.setDescripcion(xTextoSMS);
		    reporte.setFechaHoraEvento(xfechaHoraEvento);
		    reporte.setException("");
		    reporte.setEmail("");
		    reporte.setCelular(xnumerosCelular);

		    tblMailMarketingReporteRepo.save(reporte);

		    return true;
		}
}
