package com.AltiriaSpring.Service.DBMailMarketing;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AltiriaSpring.Model.DBMailMarketing.TblMailCredito;
import com.AltiriaSpring.Model.DBMailMarketing.TblMailMarketingReporte;
import com.AltiriaSpring.Repository.DBMailMarketing.TblMailCreditoRepo;
import com.AltiriaSpring.Repository.DBMailMarketing.TblMailMarketingReporteRepo;

@Service
public class TblMailMarketingReporteService {

	@Autowired
	private TblMailMarketingReporteRepo tblMailMarketingReporteRepo;
	
	//OBTENEMOS EL REPORTE MÁXIMO DE IDREPORTE
	public Integer obtenerMaximoReporte() {
        Integer maxIdReporte = tblMailMarketingReporteRepo.findMaxIdReporte();
        if (maxIdReporte != null) {
            System.out.println("Query 12 - maxIdReporte: " + maxIdReporte);
            return maxIdReporte;
        } else {
            System.out.println("No se encontró máximo reporte");
            return 0;
        }
    }
}
