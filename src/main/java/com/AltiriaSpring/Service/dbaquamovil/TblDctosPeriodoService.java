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
	    // Buscar el objeto TblLocales por su ID
	    Optional<TblLocales> localesOptional = tblLocalesRepo.findById(idLocal);
	    
	    if (localesOptional.isPresent()) { // Si se encontró un registro de TblLocales con el ID proporcionado
	        TblLocales locales = localesOptional.get(); // Obtener el objeto TblLocales
	        
	        // Buscar el objeto TblDctosPeriodo por TblLocales y ID de período
	        Optional<TblDctosPeriodo> periodoOptional = tblDctosPeriodoRepo.findByLocalesAndIdPeriodo(locales, idPeriodo);
	        
	        
	        if (periodoOptional.isPresent()) { // Si se encontró un registro de TblDctosPeriodo que cumple las condiciones
	            TblDctosPeriodo periodo = periodoOptional.get(); // Obtener el objeto TblDctosPeriodo
	            String nombrePeriodo = periodo.getNombrePeriodo(); // Obtener el nombre del período
	            
	            // Imprimir información de consulta
	            System.out.println("Query 2 - IDlocal: " + idLocal + "  idPeriodo: " + idPeriodo + " nombrePeriodo: " + nombrePeriodo);
	            
	            return nombrePeriodo; // Devolver el nombre del período
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
	    // Buscar el objeto TblLocales por su ID
	    Optional<TblLocales> localesOptional = tblLocalesRepo.findById(idLocal);

	    if (localesOptional.isPresent()) { // Si se encontró un registro de TblLocales con el ID proporcionado
	        TblLocales locales = localesOptional.get(); // Obtener el objeto TblLocales

	        // Buscar el objeto TblDctosPeriodo por TblLocales y ID de período
	        Optional<TblDctosPeriodo> fechaOptional = tblDctosPeriodoRepo.findByLocalesAndIdPeriodo(locales, idPeriodo);
	        System.out.println("prueba");
	        if (fechaOptional.isPresent()) { // Si se encontró un registro de TblDctosPeriodo que cumple las condiciones
	            TblDctosPeriodo periodo = fechaOptional.get(); // Obtener el objeto TblDctosPeriodo
	            Date fechaConRecargo = periodo.getFechaConRecargo(); // Obtener la fecha con recargo

	            // Formatear la fecha en un formato legible
	            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	            String fechaConRecargoString = dateFormat.format(fechaConRecargo);

	            // Imprimir información de consulta
	            System.out.println("Query 3 - IDlocal: " + idLocal + "  idPeriodo: " + idPeriodo + " fechaConRecargo: " + fechaConRecargoString);

	            return fechaConRecargoString; // Devolver la fecha con recargo
	        } else {
	            System.out.println("No se encontró ningún período con el idLocal: " + idLocal + " y idPeriodo: " + idPeriodo);
	            return "";
	        }
	    } else {
	        System.out.println("No se encontró el local con el idLocal: " + idLocal);
	        return "";
	    }
	}
}
