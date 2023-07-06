package com.AltiriaSpring.Service.DBMailMarketing;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AltiriaSpring.Model.DBMailMarketing.TblMailCampaign;
import com.AltiriaSpring.Model.DBMailMarketing.TblMailCredito;
import com.AltiriaSpring.Repository.DBMailMarketing.TblMailCreditoRepo;

@Service
public class TblMailCreditoService {

	@Autowired
	private TblMailCreditoRepo tblMailCreditoRepo;
	
	//CONSULTA CREDITO LOCAL
	public Integer consultaCreditoLocal(int idLocal, int idCampaign) {
        Optional<TblMailCredito> localOptional = tblMailCreditoRepo.findByIdLocalAndIdCampaign(idLocal, idCampaign);
        if (localOptional.isPresent()) {
        	TblMailCredito local = localOptional.get();
            Integer credito = local.getCredito();
            System.out.println("Query 9 - IDlocal: " + idLocal + "  credito: " + credito);
            return credito;
        } else {
            System.out.println("No se encontró ningún local con el idLocal: " + idLocal + " y idCampaign: " + idCampaign);
            return 0 ;
        }
    }
	
	// CONSULTA DEBITO LOCAL 
	public Integer consultaDebitoLocal(int idLocal, int idCampaign) {
        Optional<TblMailCredito> localOptional = tblMailCreditoRepo.findByIdLocalAndIdCampaign(idLocal, idCampaign);
        if (localOptional.isPresent()) {
        	TblMailCredito local = localOptional.get();
            Integer debito = local.getDebito();
            System.out.println("Query 10 - IDlocal: " + idLocal + "  debito: " + debito);
            return debito;
        } else {
            System.out.println("No se encontró ningún local con el idLocal: " + idLocal + " y idCampaign: " + idCampaign);
            return 0 ;
        }
    }
	
	// CONSULTA IdDcto LOCAL
	public Integer consultaIdDcto(int idLocal, int idCampaign) {
        Optional<TblMailCredito> localOptional = tblMailCreditoRepo.findByIdLocalAndIdCampaign(idLocal, idCampaign);
        if (localOptional.isPresent()) {
        	TblMailCredito local = localOptional.get();
            Integer idDctoLocal = local.getIdDcto();
            System.out.println("Query 11 - IDlocal: " + idLocal + "  idDctoLocal: " + idDctoLocal);
            return idDctoLocal;
        } else {
            System.out.println("No se encontró ningún local con el idLocal: " + idLocal + " y idCampaign: " + idCampaign);
            return 0 ;
        }
    }
	
}
