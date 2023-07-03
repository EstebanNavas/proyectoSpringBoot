package com.AltiriaSpring.Model.dbaquamovil;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
}
