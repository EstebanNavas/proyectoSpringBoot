package com.AltiriaSpring.Repository.DBMailMarketing;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.AltiriaSpring.Model.DBMailMarketing.TblMailCampaign;
import com.AltiriaSpring.Model.DBMailMarketing.TblMailCredito;

@Repository
public interface TblMailCreditoRepo extends JpaRepository<TblMailCredito, Integer> {
	Optional<TblMailCredito> findByIdLocal(Integer idLocal);
	List<TblMailCredito> findByIdLocalAndIdDcto(int idLocal, int idDcto);
}
