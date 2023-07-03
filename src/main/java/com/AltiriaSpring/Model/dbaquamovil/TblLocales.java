package com.AltiriaSpring.Model.dbaquamovil;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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

	public void setIdLocal(Integer idLocal) {
		this.idLocal = idLocal;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

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
