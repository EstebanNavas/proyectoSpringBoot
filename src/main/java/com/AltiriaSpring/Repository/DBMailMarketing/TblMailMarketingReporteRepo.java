package com.AltiriaSpring.Repository.DBMailMarketing;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.AltiriaSpring.Model.DBMailMarketing.TblMailMarketingReporte;

@Repository
public interface TblMailMarketingReporteRepo extends JpaRepository<TblMailMarketingReporte, Integer>{

}
