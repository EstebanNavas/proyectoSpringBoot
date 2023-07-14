//package com.AltiriaSpring.Service.dbaquamovil;
//
//import java.util.Optional;
//import java.util.Date;
//import java.text.SimpleDateFormat;
//import java.time.format.DateTimeFormatter;
//import java.time.LocalDate;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.AltiriaSpring.Model.dbaquamovil.TblDctosPeriodo;
//import com.AltiriaSpring.Model.dbaquamovil.TblLocales;
//import com.AltiriaSpring.Repository.dbaquamovil.TblDctosPeriodoRepo;
//import com.AltiriaSpring.Repository.dbaquamovil.TblLocalesRepo;
//
//
//@Service
//public class TblDctosPeriodoService {
//	
//	@Autowired
//	private TblDctosPeriodoRepo tblDctosPeriodoRepo;
//	
//	@Autowired
//	private TblLocalesRepo tblLocalesRepo;
//	
//	// EXTRAER NOMBRE PERIODO
//	
//	public String consultarNombrePeriodo(int idLocal) {
//	    // Buscamos el objeto TblLocales por su ID
//	    Optional<TblLocales> localesOptional = tblLocalesRepo.findById(idLocal);
//	    
//	    if (localesOptional.isPresent()) { // Si se encontró un registro de TblLocales con el ID proporcionado
//	        TblLocales locales = localesOptional.get(); // Obtenemos el objeto TblLocales
//	        
//	        // Buscamos el objeto TblDctosPeriodo por TblLocales y ID de período
//	        Optional<TblDctosPeriodo> periodoOptional = tblDctosPeriodoRepo.findByLocales(locales);
//	        
//	        
//	        if (periodoOptional.isPresent()) { // Si se encontró un registro de TblDctosPeriodo que cumple las condiciones
//	            TblDctosPeriodo periodo = periodoOptional.get(); // Obtenemos el objeto TblDctosPeriodo
//	            String nombrePeriodo = periodo.getNombrePeriodo(); // Obtenemos el nombre del período
//	           
//
//	            
//	            return nombrePeriodo; // Devolvemos el nombre del período
//	        } else {
//	            System.out.println("No se encontró ningún período con el idLocal: ");
//	            return ""; 
//	        }
//	    } else {
//	        System.out.println("No se encontró el local con el idLocal: " + idLocal);
//	        return ""; 
//	    }
//	}
//	
//	
//	//EXTRER FECHA CON RECARGO
//
//	public String consultarFechaConRecargo(int idLocal) {
//	    // Buscamos el objeto TblLocales por su ID
//	    Optional<TblLocales> localesOptional = tblLocalesRepo.findById(idLocal);
//
//	    if (localesOptional.isPresent()) { // Si se encontró un registro de TblLocales con el ID proporcionado
//	        TblLocales locales = localesOptional.get(); // Obtenemos el objeto TblLocales
//
//	        // Buscamos el objeto TblDctosPeriodo por TblLocales y ID de período
//	        Optional<TblDctosPeriodo> fechaOptional = tblDctosPeriodoRepo.findByLocales(locales);
//	        
//	        if (fechaOptional.isPresent()) { // Si se encontró un registro de TblDctosPeriodo que cumple las condiciones
//	            TblDctosPeriodo periodo = fechaOptional.get(); // Obtenemos el objeto TblDctosPeriodo
//	            Date fechaConRecargo = periodo.getFechaConRecargo(); // Obtenemos la fecha con recargo en un objeto Date
//
//	            // Formateamos la fecha en un formato legible
//	            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//	            
//	            // Se obtiene la fechaConRecargo en un String y se guarda en la variable fechaConRecargoString
//	            String fechaConRecargoString = dateFormat.format(fechaConRecargo);
//
//
//	            return fechaConRecargoString; // Devolvemos la fecha con recargo
//	        } else {
//	            System.out.println("No se encontró ninguna fecha con recargo con el idLocal: " + idLocal);
//	            return "";
//	        }
//	    } else {
//	        System.out.println("No se encontró el local con el idLocal: " + idLocal);
//	        return "";
//	    }
//	}
//}
