package com.AltiriaSpring.Repository.DBMailMarketing;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.AltiriaSpring.Model.DBMailMarketing.TblMailCampaignCliente;

@Repository
public interface TblMailCampaignClienteRepo extends JpaRepository<TblMailCampaignCliente, Integer>{

	// Obtenemos una lista de los idClientes del idCampaign X 
	@Query("SELECT t.idCliente FROM TblMailCampaignCliente t " +
			"WHERE t.idLocal = :idLocal " +
			"AND t.idCampaign = :idCampaign ")
	List<String> findByIdLocal(@Param("idLocal") int idLocal, @Param("idCampaign") int idCampaign);
}
