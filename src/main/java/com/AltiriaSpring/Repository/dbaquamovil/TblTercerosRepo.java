package com.AltiriaSpring.Repository.dbaquamovil;

import java.util.List;
import java.util.Optional;

import org.hibernate.query.NativeQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.AltiriaSpring.Model.dbaquamovil.TblLocales;
import com.AltiriaSpring.Model.dbaquamovil.TblTerceros;

@Repository
public interface TblTercerosRepo extends JpaRepository<TblTerceros, Integer> {
	
	//List<TblTerceros> findByLocalesCelular(TblLocales locales);
	
	@Query("SELECT t.telefonoCelular FROM TblTerceros t " +
			"WHERE t.idLocal = :idLocal " +
			"AND ISNUMERIC(t.telefonoCelular) = 1 " +
			"AND LEN(t.telefonoCelular) = 10 " +
			"AND t.idCliente IN :ids")
	List <String>  findByIdLocal(@Param("ids") List<String> ids, @Param("idLocal") int idLocal);
	
//	@Query("SELECT t.telefonoCelular FROM TblTerceros t " +
//			"JOIN FETCH t.TblMailCampaignCliente tc " +
//			"WHERE t.idLocal = :idLocal " +
//			"AND t.idCliente = tc.idCliente COLLATE Modern_Spanish_CI_AS " +
//			"AND ISNUMERIC(t.telefonoCelular) = 1 " +
//            "AND LEN(t.telefonoCelular) = 10 " +
//			"AND tc.idCampaign = :idCampaign")
//	List <String> findByIdLocalAndIdCampaign(@Param("idLocal") int idLocal, @Param("idCampaign") int idCampaign);
	
	@Query(
			value = "SELECT telefonoCelular FROM bdaquamovil.dbo.tblTerceros " +
			"JOIN BDMailMarketing.dbo.tblMailCampaignCliente " +
			" ON tblTerceros.idCliente =  tblMailCampaignCliente. idCliente COLLATE Modern_Spanish_CI_AS " +
			"WHERE tblTerceros.idLocal = ?1 " +
			"AND ISNUMERIC(tblTerceros.telefonoCelular) = 1 " +
            "AND LEN(tblTerceros.telefonoCelular) = 10 " +
			"AND tblMailCampaignCliente.idCampaign = ?2",
			nativeQuery = true
			)
	List <String> findByIdLocalAndIdCampaignNative( int idLocal, int idCampaign);
	
	
}

















