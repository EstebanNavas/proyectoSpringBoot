
package com.AltiriaSpring.Model.dbaquamovil;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tblTerceros")
public class TblTerceros {
	
	@Id
	@Column(name = "IDCLIENTE", columnDefinition = "nvarchar")
	private Integer idCliente;
	
	
	@Column(name = "TELEFONOCELULAR", columnDefinition = "nvarchar")
	private String telefonoCelular;
	
	
	@ManyToOne(fetch = FetchType.LAZY) // Se establece la relacion de muchos a uno con la tabla tblLocales
	@JoinColumn(name = "idLocal", referencedColumnName = "idLocal")
	private TblLocales localesCelular;

	
	
	//GETTER Y SETTERS
	public Integer getIdCliente() {
		return idCliente;
	}


	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}


	public String getTelefonoCelular() {
		return telefonoCelular;
	}


	public void setTelefonoCelular(String telefonoCelular) {
		this.telefonoCelular = telefonoCelular;
	}


	public TblLocales getLocalesCelular() {
		return localesCelular;
	}


	public void setLocalesCelular(TblLocales localesCelular) {
		this.localesCelular = localesCelular;
	}


	// CONSTRUCTORES
	public TblTerceros() {
		super();
		// TODO Auto-generated constructor stub
	}


	public TblTerceros(Integer idCliente, String telefonoCelular, TblLocales localesCelular) {
		super();
		this.idCliente = idCliente;
		this.telefonoCelular = telefonoCelular;
		this.localesCelular = localesCelular;
	}
	
	
}
