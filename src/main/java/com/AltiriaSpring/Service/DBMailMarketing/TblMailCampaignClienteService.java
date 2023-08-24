package com.AltiriaSpring.Service.DBMailMarketing;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.AltiriaSpring.Repository.DBMailMarketing.TblMailCampaignClienteRepo;

@Service
public class TblMailCampaignClienteService {

	@Autowired
	TblMailCampaignClienteRepo tblMailCampaignClienteRepo;
	
	public List<String> obtenerIdClientes(@Param("idLocal") int idLocal, @Param("idCampaign") int idCampaign){
		
		List<String> idCLientes = tblMailCampaignClienteRepo.findByIdLocal(idLocal, idCampaign);
		
		for(String idCliente : idCLientes) {
			System.out.println("El idLCiente es : " + idCliente);
			
		}
		return idCLientes;
				
	}
}
