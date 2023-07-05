package com.AltiriaSpring.Model.DBMailMarketing;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tblMailCredito")
public class TblMailCredito {

	@Id
	@Column(name = "IDLOCAL")
	private Integer idLocal;
	
	@Column(name = "SISTEMA", columnDefinition = "nvarchar")
	private String sistema;
	
	@Column(name = "IDTIPOORDEN")
	private Integer idTipoOrden;
	
	@Column(name = "IDDCTO")
	private Integer idDcto;
	
	@Column(name = "IDCAMPAIGN")
	private Integer idCampaign;
	
	@Column(name = "CREDITO")
	private Integer credito;
	
	@Column(name = "DEBITO")
	private Integer debito;
	
	
	
}
