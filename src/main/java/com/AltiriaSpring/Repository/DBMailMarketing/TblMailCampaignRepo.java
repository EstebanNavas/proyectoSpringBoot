package com.AltiriaSpring.Repository.DBMailMarketing;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.AltiriaSpring.Model.DBMailMarketing.TblMailCampaign;
import com.AltiriaSpring.Model.dbaquamovil.TblLocales;


@Repository
public interface TblMailCampaignRepo extends JpaRepository<TblMailCampaign, Integer> {
	Optional<TblMailCampaign> findByIdLocalAndIdCampaignAndIdPlantilla(Integer idLocal, Integer idCampaign, Integer idPlantilla);
	Optional<TblMailCampaign> findByIdLocal(Integer idLocal);
}
