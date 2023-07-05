package com.AltiriaSpring.Repository.dbaquamovil;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.AltiriaSpring.Model.dbaquamovil.TblLocales;
import com.AltiriaSpring.Model.dbaquamovil.TblTerceros;

@Repository
public interface TblTercerosRepo extends JpaRepository<TblTerceros, Integer> {
	
	List<TblTerceros> findByLocalesCelular(TblLocales locales);
}
