package com.sistema.refa.garantia;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Garantia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	
	private Boolean condicion;
	
	private Date duracion;
	
	/*@ManyToOne
	@JoinColumn(name = "almacen_id")
	private Almacen almacen; */

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getCondicion() {
		return condicion;
	}

	public void setCondicion(Boolean condicion) {
		this.condicion = condicion;
	}

	public Date getDuracion() {
		return duracion;
	}

	public void setDuracion(Date duracion) {
		this.duracion = duracion;
	}



	public Garantia() {
		super();
	}

	public Garantia(Integer id, Boolean condicion, Date duracion) {
		super();
		this.id = id;
		this.condicion = condicion;
		this.duracion = duracion;
	}
	
	public Garantia(Integer id) {
		super();
		this.id = id;

	}
	
	

	

}
