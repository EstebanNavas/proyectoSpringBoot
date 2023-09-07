package com.AltiriaSpring.Service.dbaquamovil;

import java.util.Optional;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

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
	

	public Map<String, String> obtenerNumerosCelularYAndIdCliente(int idLocal, int idCampaign){
		
		// Obtenemos la lista de los numeros de celular 
			List <TblTerceros> numerosCelular = tblTercerosRepo.obtenerTelefonosCelularAndIdClientes(idLocal, idCampaign);
			
			Map<String, String> celularIdClienteMap = new HashMap<>();
			
			for(TblTerceros registro : numerosCelular) {// Recorremos la lista de celulares 
				String idCliente = registro.getIdCliente();
		        String telefonoCelular = registro.getTelefonoCelular();
		        
		        if(telefonoCelular.length() == 10) {
		        	
		        	
		        	String numeroCelularConPrefijo = "57" + telefonoCelular; // Agregamos el prefijo 57 a cada número
		        	
		            // Llenamos el mapa con los valores de numeroCelular e idCliente
			        celularIdClienteMap.put(numeroCelularConPrefijo, idCliente);
			        
			        
					
					System.out.println("idCliente en obtenerNumerosCelularYAndIdCliente " + idCliente);
					System.out.println("telefonosCelular en obtenerNumerosCelularYAndIdCliente " + numeroCelularConPrefijo);
		        	
		        }
	
		        
		    
				
				
			}
			
			return celularIdClienteMap;
	}
	
}





























