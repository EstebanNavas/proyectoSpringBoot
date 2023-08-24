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
	
	public List <String> obtenerNumerosCelular (@Param("ids") List<String> ids, @Param("idLocal") int idLocal){
		
		// Obtenemos la lista de los numeros de celular 
		List <String> numerosCelular = tblTercerosRepo.findByIdLocal(ids, idLocal);
		
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
}
