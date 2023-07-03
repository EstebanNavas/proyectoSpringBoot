package com.AltiriaSpring.Model.dbaquamovil;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tblDctosPeriodo")
public class TblDctosPeriodo {

	@Id
	@Column(name = "IDPERIODO")
	private Integer idPeriodo;
	
	@Column(name = "NOMBREPERIODO")
	private String nombrePeriodo;
	
	@Column(name = "FECHACONRECARGO")
	private Date fechaConRecargo;
	
	@ManyToOne(fetch = FetchType.LAZY) // Se establece la relacion de muchos a uno con la tabla tblLocales
	@JoinColumn(name = "idLocal")
	private TblLocales locales;
	
	
	//GETTER Y SETTERS
	public Integer getIdPeriodo() {
		return idPeriodo;
	}

	public void setIdPeriodo(Integer idPeriodo) {
		this.idPeriodo = idPeriodo;
	}

	public String getNombrePeriodo() {
		return nombrePeriodo;
	}

	public void setNombrePeriodo(String nombrePeriodo) {
		this.nombrePeriodo = nombrePeriodo;
	}

	public Date getFechaConRecargo() {
		return fechaConRecargo;
	}

	public void setFechaConRecargo(Date fechaConRecargo) {
		this.fechaConRecargo = fechaConRecargo;
	}

	public TblLocales getLocales() {
		return locales;
	}

	public void setLocales(TblLocales locales) {
		this.locales = locales;
	}
	
	
	// CONSTRUCTORES
	public TblDctosPeriodo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TblDctosPeriodo(Integer idPeriodo, String nombrePeriodo, Date fechaConRecargo, TblLocales locales) {
		super();
		this.idPeriodo = idPeriodo;
		this.nombrePeriodo = nombrePeriodo;
		this.fechaConRecargo = fechaConRecargo;
		this.locales = locales;
	}
	
	
}
