package com.AltiriaSpring.Model.dbaquamovil;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tblLocales")
public class TblLocales {

	@Id
	@Column(name = "IDLOCAL")
	private Integer idLocal;
	
	@Column(name = "RAZONSOCIAL", columnDefinition = "nvarchar")
	private String razonSocial;

	public Integer getIdLocal() {
		return idLocal;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "locales", cascade = CascadeType.ALL)// Se establece relacion uno a muchos con la tabla tblDctosPeriodo
	private List<TblDctosPeriodo> periodos;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "localesCelular", cascade = CascadeType.ALL)// Se establece relacion uno a muchos con la tabla tblDctosPeriodo
	private List<TblTerceros> numerosCelular;

	
	//GETTER Y SETTERS
	public void setIdLocal(Integer idLocal) {
		this.idLocal = idLocal;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	
	// CONSTRUCTORES
	public TblLocales() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TblLocales(Integer idLocal, String razonSocial) {
		super();
		this.idLocal = idLocal;
		this.razonSocial = razonSocial;
	}
	
	
	
}
