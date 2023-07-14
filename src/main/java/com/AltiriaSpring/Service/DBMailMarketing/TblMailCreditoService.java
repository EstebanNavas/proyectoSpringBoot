package com.AltiriaSpring.Service.DBMailMarketing;

import java.util.Optional;
import java.util.List;

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
	public Integer consultaCreditoLocal(int idLocal) {
		
		//Buscamos de TblMailCredito el local
        Optional<TblMailCredito> localOptional = tblMailCreditoRepo.findByIdLocal(idLocal);
        if (localOptional.isPresent()) {//  Si se encontró un registro de TblMailCredito con el ID y idCampaign proporcionados
        	TblMailCredito local = localOptional.get();// Obtenekos el objeto TblMailCredito
            Integer credito = local.getCredito(); // Obtenemos el credito del local
            
            System.out.println("Query 9 - IDlocal: " + idLocal + "  credito: " + credito);
            return credito;
        } else {
            System.out.println("No se encontró ningún local con el idLocal: " + idLocal );
            return 0 ;
        }
    }
	
	// CONSULTA DEBITO LOCAL 
	public Integer consultaDebitoLocal(int idLocal) {
		
		//Buscamos de TblMailCredito el local
        Optional<TblMailCredito> localOptional = tblMailCreditoRepo.findByIdLocal(idLocal);
        if (localOptional.isPresent()) {//  Si se encontró un registro de TblMailCredito con el ID y idCampaign proporcionados
        	TblMailCredito local = localOptional.get();// Obtenemos el objeto TblMailCredito
            Integer debito = local.getDebito();// Obtenekos el debito del local
            
            System.out.println("Query 10 - IDlocal: " + idLocal + "  debito: " + debito);
            return debito;
        } else {
            System.out.println("No se encontró ningún local con el idLocal: " + idLocal);
            return 0 ;
        }
    }
	
	// CONSULTA IdDcto LOCAL
	public Integer consultaIdDcto(int idLocal) {
		
		//Buscamos de TblMailCredito el local
        Optional<TblMailCredito> localOptional = tblMailCreditoRepo.findByIdLocal(idLocal);
        if (localOptional.isPresent()) {//  Si se encontró un registro de TblMailCredito con el ID y idCampaign proporcionados
        	TblMailCredito local = localOptional.get();// Obtenemos el objeto TblMailCredito
            Integer idDctoLocal = local.getIdDcto(); // obtenemos el idDcto
            
            System.out.println("Query 11 - IDlocal: " + idLocal + "  idDctoLocal: " + idDctoLocal);
            return idDctoLocal;
        } else {
            System.out.println("No se encontró ningún local con el idLocal: " + idLocal);
            return 0 ;
        }
    }
	
	public boolean incrementarDebito(int xIdLocal, int xIdDcto) {
		
		//Realizamos una consulta a la tabla tblMailCredito y el resultado se guarda en la lista consultaDebito
		List<TblMailCredito> consultaDebito = tblMailCreditoRepo.findByIdLocalAndIdDcto(xIdLocal, xIdDcto);
        
		// Verificamos si consultaDebito no está vacia
        if (!consultaDebito.isEmpty()) {
        	
        	// Se obtiene el primer elemento de la consulta
            TblMailCredito debito = consultaDebito.get(0);
            
            // Obtén el valor actual de "debito"
            int debitoActual = debito.getDebito();
            
            // Incrementa el valor de "debito" en 1
            int nuevoDebito = debitoActual + 1;
            
            // Actualiza el valor de "debito" en el objeto TblMailCredito
            debito.setDebito(nuevoDebito);
            
            // Guarda los cambios en la base de datos
            tblMailCreditoRepo.save(debito);
            
            return true;
        } else {
            System.out.println("No se encontró el objeto TblMailCredito");
            return false;
        }
    }
	
}
