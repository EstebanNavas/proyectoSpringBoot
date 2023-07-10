	package com.AltiriaSpring.Repository.dbaquamovil;
	
	import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.AltiriaSpring.Model.dbaquamovil.TblLocales;
	
	@Repository
	public interface TblLocalesRepo extends JpaRepository<TblLocales,Integer> {
		Optional<TblLocales> findByIdLocal(Integer idLocal); // Buscamos el idLocal
	}
