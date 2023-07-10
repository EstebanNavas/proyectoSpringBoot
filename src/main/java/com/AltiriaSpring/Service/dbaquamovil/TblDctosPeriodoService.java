package com.AltiriaSpring.Service.dbaquamovil;

import java.util.Optional;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AltiriaSpring.Model.dbaquamovil.TblDctosPeriodo;
import com.AltiriaSpring.Model.dbaquamovil.TblLocales;
import com.AltiriaSpring.Repository.dbaquamovil.TblDctosPeriodoRepo;
import com.AltiriaSpring.Repository.dbaquamovil.TblLocalesRepo;


@Service
public class TblDctosPeriodoService {
	
	@Autowired
	private TblDctosPeriodoRepo tblDctosPeriodoRepo;
	
	@Autowired
	private TblLocalesRepo tblLocalesRepo;
	
	// EXTRAER NOMBRE PERIODO
	
	public String consultarNombrePeriodo(int idLocal, int idPeriodo) {
	    // Buscamos el objeto TblLocales por su ID
	    Optional<TblLocales> localesOptional = tblLocalesRepo.findById(idLocal);
	    
	    if (localesOptional.isPresent()) { // Si se encontró un registro de TblLocales con el ID proporcionado
	        TblLocales locales = localesOptional.get(); // Obtenemos el objeto TblLocales
	        
	        // Buscamos el objeto TblDctosPeriodo por TblLocales y ID de período
	        Optional<TblDctosPeriodo> periodoOptional = tblDctosPeriodoRepo.findByLocalesAndIdPeriodo(locales, idPeriodo);
	        
	        
	        if (periodoOptional.isPresent()) { // Si se encontró un registro de TblDctosPeriodo que cumple las condiciones
	            TblDctosPeriodo periodo = periodoOptional.get(); // Obtenemos el objeto TblDctosPeriodo
	            String nombrePeriodo = periodo.getNombrePeriodo(); // Obtenemos el nombre del período
	            
	            // Imprimimos información de consulta
	            System.out.println("Query 2 - IDlocal: " + idLocal + "  idPeriodo: " + idPeriodo + " nombrePeriodo: " + nombrePeriodo);
	            
	            return nombrePeriodo; // Devolvemos el nombre del período
	        } else {
	            System.out.println("No se encontró ningún período con el idLocal: " + idLocal + " y idPeriodo: " + idPeriodo);
	            return ""; 
	        }
	    } else {
	        System.out.println("No se encontró el local con el idLocal: " + idLocal);
	        return ""; 
	    }
	}
	
	
	//EXTRER FECHA CON RECARGO

	public String consultarFechaConRecargo(int idLocal, int idPeriodo) {
	    // Buscamos el objeto TblLocales por su ID
	    Optional<TblLocales> localesOptional = tblLocalesRepo.findById(idLocal);

	    if (localesOptional.isPresent()) { // Si se encontró un registro de TblLocales con el ID proporcionado
	        TblLocales locales = localesOptional.get(); // Obtenemos el objeto TblLocales

	        // Buscamos el objeto TblDctosPeriodo por TblLocales y ID de período
	        Optional<TblDctosPeriodo> fechaOptional = tblDctosPeriodoRepo.findByLocalesAndIdPeriodo(locales, idPeriodo);
	        
	        if (fechaOptional.isPresent()) { // Si se encontró un registro de TblDctosPeriodo que cumple las condiciones
	            TblDctosPeriodo periodo = fechaOptional.get(); // Obtenemos el objeto TblDctosPeriodo
	            Date fechaConRecargo = periodo.getFechaConRecargo(); // Obtenemos la fecha con recargo en un objeto Date

	            // Formateamos la fecha en un formato legible
	            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	            
	            // Se obtiene la fechaConRecargo en un String y se guarda en la variable fechaConRecargoString
	            String fechaConRecargoString = dateFormat.format(fechaConRecargo);

	            // Imprimimos información de consulta
	            System.out.println("Query 3 - IDlocal: " + idLocal + "  idPeriodo: " + idPeriodo + " fechaConRecargo: " + fechaConRecargoString);

	            return fechaConRecargoString; // Devolvemos la fecha con recargo
	        } else {
	            System.out.println("No se encontró ninguna fecha con recargo con el idLocal: " + idLocal + " y idPeriodo: " + idPeriodo);
	            return "";
	        }
	    } else {
	        System.out.println("No se encontró el local con el idLocal: " + idLocal);
	        return "";
	    }
	}
}
