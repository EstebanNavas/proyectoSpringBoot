package com.AltiriaSpring.Model.DBMailMarketing;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tblMailMarketingReporte")
public class TblMailMarketingReporte {
	
	@Id
	@Column(name = "IDREPORTE")
	private Integer idReporte;
	
//	@Column(name = "IDLOCAL")
//	private Integer idLocal;
	
	@Column(name = "SISTEMA", columnDefinition = "nvarchar")
	private String sistema;
	
//	@Column(name = "IDCAMPAIGN")
//	private Integer idCampaign;
	
//	@Column(name = "IDPLANTILLA")
//	private Integer idPlantilla;
	
	@Column(name = "IDDCTO")
	private Integer idDcto;
	
	@Column(name = "IDREQUERIMIENTO")
	private Integer idRequerimiento;
	
	@Column(name = "DOCUMENTOTERCERO", columnDefinition = "nvarchar")
	private String documentoTercero;
	
	@Column(name = "ESTADO")
	private Integer estado;
	
	@Column(name = "DESCRIPCION", columnDefinition = "nvarchar")
	private String descripcion;
	
	@Column(name = "FECHAHORAEVENTO")
	private Date fechaHoraEvento;
	
	@Column(name = "EXCEPTION", columnDefinition = "nvarchar")
	private String exception;
	
	@Column(name = "EMAIL", columnDefinition = "nvarchar")
	private String email;
	
	@Column(name = "CELULAR", columnDefinition = "nvarchar")
	private String celular;
	
	@ManyToOne(fetch = FetchType.LAZY) // Se establece la relacion de muchos a uno con la tabla tblMailCampaign
	@JoinColumn(name = "IDLOCAL")
	private TblMailCampaign localesReporte;
	
//	@ManyToOne(fetch = FetchType.LAZY) // Se establece la relacion de muchos a uno con la tabla tblMailCampaign
//	@JoinColumn(name = "IDCAMPAIGN")
//	private TblMailCampaign campaña;
//	
//	@ManyToOne(fetch = FetchType.LAZY) // Se establece la relacion de muchos a uno con la tabla tblMailCampaign
//	@JoinColumn(name = "IDPLANTILLA")
//	private TblMailCampaign plantilla;

}
