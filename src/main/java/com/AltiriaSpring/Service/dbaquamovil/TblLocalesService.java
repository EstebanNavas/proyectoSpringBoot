package com.AltiriaSpring.Service.dbaquamovil;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AltiriaSpring.Model.dbaquamovil.TblLocales;
import com.AltiriaSpring.Repository.dbaquamovil.TblLocalesRepo;

@Service
public class TblLocalesService {

	@Autowired
	TblLocalesRepo tblLocalesRepo;
	
	// EXTRAER EL ID DEL LOCAL Y SU RAZÓN SOCIAL 
	  public String consultarRazonSocial(int idLocal) {
		  
		   // Buscammos el Objeto TblLocales por su id
	        Optional<TblLocales> localOptional = tblLocalesRepo.findById(idLocal);
	        
	        if (localOptional.isPresent()) { // Si se encontró un registro de TblLocales con el ID proporcionado
	        	
	            TblLocales local = localOptional.get();// Obtenemos el objeto TblLocales
	            
	            String razonSocial = local.getRazonSocial(); // Obtenemos la razonSocial
	          // Imprimimos información de consulta
	            System.out.println("Query 1 - IDlocal: " + idLocal + "  razonSocial: " + razonSocial);
	            return razonSocial;
	        } else {
	            System.out.println("No se encontró ningún local con el idLocal: " + idLocal);
	            return "";
	        }
	    }
}
