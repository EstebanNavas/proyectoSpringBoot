package com.AltiriaSpring.Repository.DBMailMarketing;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.AltiriaSpring.Model.DBMailMarketing.TblMailMarketingReporte;

@Repository
public interface TblMailMarketingReporteRepo extends JpaRepository<TblMailMarketingReporte, Integer>{
	  @Query("SELECT MAX(r.idReporte) FROM TblMailMarketingReporte r")
	    Integer findMaxIdReporte();
}
