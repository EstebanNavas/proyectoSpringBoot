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
		
		//Buscamos del TblMailCampaign el local
        Optional<TblMailCampaign> localOptional = tblMailCampaignRepo.findByIdLocalAndIdCampaign(idLocal, idCampaign);
        if (localOptional.isPresent()) { //  Si se encontró un registro de TblLocales con el ID y idCampaign proporcionados
            TblMailCampaign local = localOptional.get(); // Obtenekos el objeto TblMailCampaign
            
            String textoSMS = local.getTextoSMS(); // Obtenemos el textoSMS
            
            System.out.println("Query 5 - IDlocal: " + idLocal + "  textoSMS: " + textoSMS);
            return textoSMS;
        } else {
            System.out.println("No se encontró ningún local con el idLocal: " + idLocal + " y idCampaign: " + idCampaign);
            return "";
        }
    }
	
	// EXTRAEMOS LA FECHA Y HORA QUE ESTÁ PROGRAMADO EL ENVIO DEL SMS
	public String consultarFechayHora(int idLocal, int idCampaign) {
		
		//Buscamos del TblMailCampaign el local
        Optional<TblMailCampaign> localOptional = tblMailCampaignRepo.findByIdLocalAndIdCampaign(idLocal, idCampaign);
        if (localOptional.isPresent()) { //  Si se encontró un registro de TblLocales con el ID y idCampaign proporcionados
            TblMailCampaign local = localOptional.get(); // Obtenekos el objeto TblMailCampaign
            Date FechaYhora = local.getFechaYhora(); // Obtenemos la fecha y hora en un objeto Date
            
            // Formateamos la fecha a un formato legible
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            
            // Obtenemos la fecha y hora como String
            String fechayHoraString = dateFormat.format(FechaYhora);
            
            System.out.println("Query 6 - IDlocal: " + idLocal + "  FechaYhora: " + fechayHoraString);
            return fechayHoraString;
        } else {
            System.out.println("No se encontró ningún local con el idLocal: " + idLocal + " y idCampaign: " + idCampaign);
            return "";
        }
    }
	
	// EXTRAEMOS IDCAMPAÑA
	public Integer consultarIdCampaign(int idLocal, int idCampaign) {
		
		//Buscamos del TblMailCampaign el local
        Optional<TblMailCampaign> localOptional = tblMailCampaignRepo.findByIdLocalAndIdCampaign(idLocal, idCampaign);
        if (localOptional.isPresent()) {//  Si se encontró un registro de TblLocales con el ID y idCampaign proporcionados
            TblMailCampaign local = localOptional.get();// Obtenekos el objeto TblMailCampaign
            Integer idCampaña = local.getIdCampaign(); // obtenemos el idCampaing
            
            System.out.println("Query 7 - IDlocal: " + idLocal + "  idCampaña: " + idCampaña);
            return idCampaña;
        } else {
            System.out.println("No se encontró ningún local con el idLocal: " + idLocal + " y idCampaign: " + idCampaign);
            return 0 ;
        }
    }
	
	
	//EXTRAEMOS EL ID DE PLANTILLA
	public Integer consultarIdPlantilla(int idLocal, int idCampaign) {
		
		//Buscamos del TblMailCampaign el local
        Optional<TblMailCampaign> localOptional = tblMailCampaignRepo.findByIdLocalAndIdCampaign(idLocal, idCampaign);
        if (localOptional.isPresent()) { //  Si se encontró un registro de TblLocales con el ID y idCampaign proporcionados
            TblMailCampaign local = localOptional.get(); // Obtenekos el objeto TblMailCampaign
            Integer idplantilla = local.getIdPlantilla(); //obtenemos el idPlantilla
            
            System.out.println("Query 8 - IDlocal: " + idLocal + "  idplantilla: " + idplantilla);
            return idplantilla;
        } else {
            System.out.println("No se encontró ningún local con el idLocal: " + idLocal + " y idCampaign: " + idCampaign);
            return 0 ;
        }
    }
}

