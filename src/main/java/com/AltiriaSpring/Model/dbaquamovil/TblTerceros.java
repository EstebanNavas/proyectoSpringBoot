
package com.AltiriaSpring.Model.dbaquamovil;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tblTerceros")
public class TblTerceros {
	
	@Id
	@Column(name = "IDLOCAL")
	private Integer idLocal;
	
	@Column(name = "TELEFONOCELULAR", columnDefinition = "nvarchar")
	private String telefonoCelular;

}
