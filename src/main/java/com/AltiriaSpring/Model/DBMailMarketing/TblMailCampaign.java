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
	
	@Column(name = "fechaHora")
	private Date fechaYhora;
	
	@Column(name = "TEXTOMENSAJE", columnDefinition = "nvarchar")
	private String textoMensaje;
	
	@Column(name = "textoSMS", columnDefinition = "nvarchar")
	private String textoSMS;
	
	@Column(name = "SUBJECT", columnDefinition = "nvarchar")
	private String subject;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "localesReporte", cascade = CascadeType.ALL)// Se establece relacion uno a muchos con la tabla tblMailMarketingReporte
	private List<TblMailMarketingReporte> reporte;

	
	//GETTERS Y SETTERS
	public Integer getIdLocal() {
		return idLocal;
	}

	public void setIdLocal(Integer idLocal) {
		this.idLocal = idLocal;
	}

	public Integer getIdCampaign() {
		return idCampaign;
	}

	public void setIdCampaign(Integer idCampaign) {
		this.idCampaign = idCampaign;
	}

	public String getNombreCampaign() {
		return NombreCampaign;
	}

	public void setNombreCampaign(String nombreCampaign) {
		NombreCampaign = nombreCampaign;
	}

	public String getPeriodicidad() {
		return periodicidad;
	}

	public void setPeriodicidad(String periodicidad) {
		this.periodicidad = periodicidad;
	}

	public Integer getIdPlantilla() {
		return idPlantilla;
	}

	public void setIdPlantilla(Integer idPlantilla) {
		this.idPlantilla = idPlantilla;
	}

	public Date getFechaYhora() {
		return fechaYhora;
	}

	public void setFechaYhora(Date fechaYhora) {
		this.fechaYhora = fechaYhora;
	}

	public String getTextoMensaje() {
		return textoMensaje;
	}

	public void setTextoMensaje(String textoMensaje) {
		this.textoMensaje = textoMensaje;
	}

	public String getTextoSMS() {
		return textoSMS;
	}

	public void setTextoSMS(String textoSMS) {
		this.textoSMS = textoSMS;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public List<TblMailMarketingReporte> getReporte() {
		return reporte;
	}

	public void setReporte(List<TblMailMarketingReporte> reporte) {
		this.reporte = reporte;
	}

	public void setSistema(String sistema) {
		this.sistema = sistema;
	}
	
	
	
}
