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
	    Optional<TblLocales> localesOptional = tblLocalesRepo.findById(idLocal);
	    if (localesOptional.isPresent()) {
	        TblLocales locales = localesOptional.get();
	        List<TblTerceros> celulares = tblTercerosRepo.findByLocalesCelular(locales);
	        List<String> telefonosCelular = new ArrayList<>();
	        for (TblTerceros local : celulares) {
	            String telefonoCelular = local.getTelefonoCelular();
	            telefonosCelular.add(telefonoCelular);
	        }
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
