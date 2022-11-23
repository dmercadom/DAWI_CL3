package com.CL3.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import lombok.Data;

@Data
@Table(name = "reservas")
@Entity
public class Reservas {
	@Id
	private int codigo;
	private String nombre;
	private String apellido;
	private java.sql.Date fchregistro;
	
	@ManyToOne
	@JoinColumn(name = "id_carrera", insertable = true, updatable = true)
	private Carreras objCarreras;

}
