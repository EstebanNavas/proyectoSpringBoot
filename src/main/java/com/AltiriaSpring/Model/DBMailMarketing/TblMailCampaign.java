package com.AltiriaSpring.Model.DBMailMarketing;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tblMailCampaign")
public class TblMailCampaign {

	@Id
	@Column(name = "IDLOCAL")
	private Integer idLocal;
	
	@Column(name = "SISTEMA", columnDefinition = "nvarchar")
	private String sistema;
	
	@Column(name = "NOMBRECAMPAIGN", columnDefinition = "nvarchar")
	private String NombreCampaign;
	
	@Column(name = "PERIODICIDAD", columnDefinition = "nvarchar")
	private String periodicidad;
	
	@Column(name = "IDPLANTILLA")
	private Integer idPlantilla;
	
	@Column(name = "FECHA/HORA")
	private Date fechaYhora;
	
	@Column(name = "TEXTOMENSAJE", columnDefinition = "nvarchar")
	private String textoMensaje;
	
	@Column(name = "TEXTOSMS", columnDefinition = "nvarchar")
	private String textoSMS;
	
	@Column(name = "SUBJECT", columnDefinition = "nvarchar")
	private String subject;
	
	
}
