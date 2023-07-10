package com.AltiriaSpring.Service.dbaquamovil;

import java.util.Optional;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
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
	public List<String> consultarNumerosCelular(int idLocal) {
		
		// Buscamos el objeto TblLocales por id
		Optional<TblLocales> localesOptional = tblLocalesRepo.findById(idLocal);
		
		if (localesOptional.isPresent()) { // Si se encontró un registro de TblLocales con el ID proporcionado
			TblLocales locales = localesOptional.get();// Obtenemos el objeto TblLocales
			
			//Obtenemos los registros de la tabla TblTerceros que tengan el idLocal especificado
			List<TblTerceros> celulares = tblTercerosRepo.findByLocalesCelular(locales);
			
			// Se crea una lista para almanecar los registros obtenidos
			List<String> telefonosCelular = new ArrayList<>();
			
			for (TblTerceros local : celulares) { // Recorremos la lista de celulares 
				
				if (local.getTelefonoCelular().length() == 10) { // Validamos que los números celular tengas una longitud de 10 caracteres
					String telefonoCelular = local.getTelefonoCelular(); // Buscamos el telegonoCelular
					
					String numeroCelularConPrefijo = "57" + telefonoCelular; // Agregamos el prefijo 57 a cada número
					telefonosCelular.add(String.valueOf(numeroCelularConPrefijo)); // Se agregan los numeroCelularConPrefijo a la lista telefonosCelular
				}

			}
			
			// Verificamos si se encontraron números celular 
			if (!telefonosCelular.isEmpty()) {
				System.out.println("Query 4 - IDlocal: " + idLocal + "  telefonosCelular: " + telefonosCelular);
				return telefonosCelular;
			} else {
				System.out.println("No se encontró ningún número celular para el local con el idLocal: " + idLocal);
				return Collections.emptyList();
			}
		} else {
			System.out.println("No se encontró el local con el idLocal: " + idLocal);
			return Collections.emptyList();
		}
	}
}
