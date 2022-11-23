package com.CL3.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.CL3.model.Carreras;

import lombok.Data;

@Data
@Table(name = "carreras")
@Entity
public class Carreras {
	
	@Id
	private int id_carrera;
	private String descripcion;
}
