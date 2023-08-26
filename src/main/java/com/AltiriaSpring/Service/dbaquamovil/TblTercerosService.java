package com.AltiriaSpring.Service.dbaquamovil;

import java.util.Optional;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.AltiriaSpring.Model.dbaquamovil.TblLocales;
import com.AltiriaSpring.Model.dbaquamovil.TblTerceros;
import com.AltiriaSpring.Repository.dbaquamovil.TblTercerosRepo;
import com.AltiriaSpring.Repository.dbaquamovil.TblLocalesRepo;

@Service
public class TblTercerosService {

	@Autowired
	private TblTercerosRepo tblTercerosRepo;

	@Autowired
	private TblLocalesRepo tblLocalesRepo;

	// EXTRAER NÚMEROS DE TELEFONO CELULAR
	
	public List <String> obtenerNumerosCelular (int idLocal, int idCampaign){
		
		// Obtenemos la lista de los numeros de celular 
		List <String> numerosCelular = tblTercerosRepo.findByIdLocalAndIdCampaignNative(idLocal, idCampaign);
		
		// se crea una nueva lista para guardar los numeroCelularConPrefijo
		List<String> telefonosCelular = new ArrayList<>();
		
		for(String celular : numerosCelular) {// Recorremos la lista de celulares 
			
			if(celular.length() == 10) { // Validamos si el celular tiene 10 digitos
				System.out.println("El celular del idCliente es :" + celular);
				
				String numeroCelularConPrefijo = "57" + celular; // Agregamos el prefijo 57 a cada número
				
				System.out.println("El celular del idCliente con prefijo es :" + numeroCelularConPrefijo);
				telefonosCelular.add(String.valueOf(numeroCelularConPrefijo)); // Se agregan los numeroCelularConPrefijo a la lista telefonosCelular
			}
			
			
			
		}
		
		return telefonosCelular;
	}
	
	
//	public List <String> obtenerTelefonosCelular(@Param("idLocal") int idLocal, @Param("idCampaign") int idCampaign){
//		
//		List <String> telefonosCelular = tblTercerosRepo.findByIdLocalAndIdCampaign(idLocal, idCampaign);
//		
//		for(String celular : telefonosCelular) {// Recorremos la lista de celulares 
//			
//		
//				System.out.println("El celular del idCliente desde collate es :" + celular);
//
//		}
//		
//		return telefonosCelular;
//	}
	
	
//	public List <String> obtenerTelefonosCelular(int idLocal, int idCampaign){
//		
//		List <String> telefonosCelular = tblTercerosRepo.findByIdLocalAndIdCampaignNative(idLocal, idCampaign);
//		
//		
//		
//		for(String celular : telefonosCelular) {// Recorremos la lista de celulares 
//			
//		
//				System.out.println("El celular del idCliente desde collate es :" + celular);
//
//		}
//		
//		return telefonosCelular;
//	}
	
}





























