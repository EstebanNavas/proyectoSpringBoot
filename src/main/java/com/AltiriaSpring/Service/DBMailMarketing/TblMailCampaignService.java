package com.AltiriaSpring.Service.DBMailMarketing;

import java.text.SimpleDateFormat;
import java.util.Optional;

import java.util.Date;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AltiriaSpring.Model.DBMailMarketing.TblMailCampaign;
import com.AltiriaSpring.Repository.DBMailMarketing.TblMailCampaignRepo;

@Service
public class TblMailCampaignService {
	
	@Autowired
	private TblMailCampaignRepo tblMailCampaignRepo;
	
	// EXTRAEMOS EL MENSAJE DE TEXTO
	public String consultarTextoSMS(int idLocal, int idCampaign) {
        Optional<TblMailCampaign> localOptional = tblMailCampaignRepo.findByIdLocalAndIdCampaign(idLocal, idCampaign);
        if (localOptional.isPresent()) {
            TblMailCampaign local = localOptional.get();
            String textoSMS = local.getTextoSMS();
            System.out.println("Query 5 - IDlocal: " + idLocal + "  textoSMS: " + textoSMS);
            return textoSMS;
        } else {
            System.out.println("No se encontró ningún local con el idLocal: " + idLocal + " y idCampaign: " + idCampaign);
            return "";
        }
    }
	
	// EXTRAEMOS LA FECHA Y HORA QUE ESTÁ PROGRAMADO EL ENVIO DEL SMS
	public String consultarFechayHora(int idLocal, int idCampaign) {
        Optional<TblMailCampaign> localOptional = tblMailCampaignRepo.findByIdLocalAndIdCampaign(idLocal, idCampaign);
        if (localOptional.isPresent()) {
            TblMailCampaign local = localOptional.get();
            Date FechaYhora = local.getFechaYhora();
            
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String fechaConRecargoString = dateFormat.format(FechaYhora);
            
            System.out.println("Query 6 - IDlocal: " + idLocal + "  FechaYhora: " + fechaConRecargoString);
            return fechaConRecargoString;
        } else {
            System.out.println("No se encontró ningún local con el idLocal: " + idLocal + " y idCampaign: " + idCampaign);
            return "";
        }
    }
	
	// EXTRAEMOS IDCAMPAÑA
	public Integer consultarIdCampaign(int idLocal, int idCampaign) {
        Optional<TblMailCampaign> localOptional = tblMailCampaignRepo.findByIdLocalAndIdCampaign(idLocal, idCampaign);
        if (localOptional.isPresent()) {
            TblMailCampaign local = localOptional.get();
            Integer idCampaña = local.getIdCampaign();
            System.out.println("Query 7 - IDlocal: " + idLocal + "  idCampaña: " + idCampaña);
            return idCampaña;
        } else {
            System.out.println("No se encontró ningún local con el idLocal: " + idLocal + " y idCampaign: " + idCampaign);
            return 0 ;
        }
    }
	
	
	//EXTRAEMOS EL ID DE PLANTILLA
	public Integer consultarIdPlantilla(int idLocal, int idCampaign) {
        Optional<TblMailCampaign> localOptional = tblMailCampaignRepo.findByIdLocalAndIdCampaign(idLocal, idCampaign);
        if (localOptional.isPresent()) {
            TblMailCampaign local = localOptional.get();
            Integer idplantilla = local.getIdPlantilla();
            System.out.println("Query 8 - IDlocal: " + idLocal + "  idplantilla: " + idplantilla);
            return idplantilla;
        } else {
            System.out.println("No se encontró ningún local con el idLocal: " + idLocal + " y idCampaign: " + idCampaign);
            return 0 ;
        }
    }
}

