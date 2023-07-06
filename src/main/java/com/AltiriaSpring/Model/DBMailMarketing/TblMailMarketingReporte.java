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
	
	@Column(name = "SISTEMA", columnDefinition = "nvarchar")
	private String sistema;
	
	@Column(name = "IDCAMPAIGN")
	private Integer idCampaign;
	
	@Column(name = "IDPLANTILLA")
	private Integer idPlantilla;
	
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

	public Integer getIdReporte() {
		return idReporte;
	}

	public void setIdReporte(Integer idReporte) {
		this.idReporte = idReporte;
	}

	public String getSistema() {
		return sistema;
	}

	public void setSistema(String sistema) {
		this.sistema = sistema;
	}

	public Integer getIdCampaign() {
		return idCampaign;
	}

	public void setIdCampaign(Integer idCampaign) {
		this.idCampaign = idCampaign;
	}

	public Integer getIdPlantilla() {
		return idPlantilla;
	}

	public void setIdPlantilla(Integer idPlantilla) {
		this.idPlantilla = idPlantilla;
	}

	public Integer getIdDcto() {
		return idDcto;
	}

	public void setIdDcto(Integer idDcto) {
		this.idDcto = idDcto;
	}

	public Integer getIdRequerimiento() {
		return idRequerimiento;
	}

	public void setIdRequerimiento(Integer idRequerimiento) {
		this.idRequerimiento = idRequerimiento;
	}

	public String getDocumentoTercero() {
		return documentoTercero;
	}

	public void setDocumentoTercero(String documentoTercero) {
		this.documentoTercero = documentoTercero;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaHoraEvento() {
		return fechaHoraEvento;
	}

	public void setFechaHoraEvento(Date fechaHoraEvento) {
		this.fechaHoraEvento = fechaHoraEvento;
	}

	public String getException() {
		return exception;
	}

	public void setException(String exception) {
		this.exception = exception;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public TblMailCampaign getLocalesReporte() {
		return localesReporte;
	}

	public void setLocalesReporte(TblMailCampaign localesReporte) {
		this.localesReporte = localesReporte;
	}


	
//	@ManyToOne(fetch = FetchType.LAZY) // Se establece la relacion de muchos a uno con la tabla tblMailCampaign
//	@JoinColumn(name = "IDCAMPAIGN")
//	private TblMailCampaign campaña;
//	
//	@ManyToOne(fetch = FetchType.LAZY) // Se establece la relacion de muchos a uno con la tabla tblMailCampaign
//	@JoinColumn(name = "IDPLANTILLA")
//	private TblMailCampaign plantilla;
	
	

}
