package com.AltiriaSpring.Repository.dbaquamovil;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.AltiriaSpring.Model.dbaquamovil.TblDctosPeriodo;
import com.AltiriaSpring.Model.dbaquamovil.TblLocales;

@Repository
public interface TblDctosPeriodoRepo extends JpaRepository<TblDctosPeriodo, Integer> {
	Optional<TblDctosPeriodo> findByLocalesAndIdPeriodo(TblLocales locales, Integer idPeriodo); // Buscamos el idLocal y idPeriodo y le pasamos como argumento de busqueda locales y idPeriodo
	Optional<TblDctosPeriodo> findByLocalesAndFechaConRecargo(TblLocales locales, Integer idPeriodo); // Buscamos el idLocal y la FechaConRecargo y le pasamos como argumento de busqueda locales y idPeriodo

}
