package com.AltiriaSpring.Model.DBMailMarketing;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tblMailCampaign")
public class TblMailCampaign {

	@Id
	@Column(name = "IDLOCAL")
	private Integer idLocal;
	
	@Column(name = "SISTEMA", columnDefinition = "nvarchar")
	private String sistema;
	
	@Column(name = "IDCAMPAIGN")
	private Integer idCampaign;
	
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
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "localesReporte", cascade = CascadeType.ALL)// Se establece relacion uno a muchos con la tabla tblMailMarketingReporte
	private List<TblMailMarketingReporte> reporte;
	
	@Override
    public String toString() {
        return "TblLocales [idLocal= " + idLocal + ", textoSMS= " + textoSMS + "]";
    }
	
//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "campaña", cascade = CascadeType.ALL)// Se establece relacion uno a muchos con la tabla tblMailMarketingReporte
//	private List<TblMailMarketingReporte> campañas;
//	
}
