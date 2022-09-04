package com.sistema.refa.almacen;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Almacen {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(length = 128, nullable = false, unique = true)
	private String nombre;
	
	@Column(length = 128, nullable = false, unique = false)
	private String direccion;
	
	private String encargado;
	
	private Integer total_pzas;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEncargado() {
		return encargado;
	}

	public void setEncargado(String encargado) {
		this.encargado = encargado;
	}

	public Integer getTotal_pzas() {
		return total_pzas;
	}

	public void setTotal_pzas(Integer total_pzas) {
		this.total_pzas = total_pzas;
	}
	
	public Almacen() {
		super();
	}

	public Almacen(Integer id, String nombre, String direccion, String encargado, Integer total_pzas) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.encargado = encargado;
		this.total_pzas = total_pzas;
	}

	public Almacen(Integer id) {
		super();
		this.id = id;
	}

	public Almacen(String nombre) {
		super();
		this.nombre = nombre;
	}
}
