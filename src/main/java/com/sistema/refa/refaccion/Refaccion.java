package com.sistema.refa.refaccion;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.sistema.refa.almacen.Almacen;
import com.sistema.refa.proveedor.Proveedor;

@Entity
public class Refaccion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(length = 128, nullable = false, unique = true)
	private String nombre;
	
	private String no_parte;
	
	private Date fecha_cad;

	private float costo;
	
	private Integer total_pzas;

	@ManyToOne
	@JoinColumn(name = "almacen_id")
	private Almacen almacen;
	
	@ManyToOne
	@JoinColumn(name = "proveedor_id")
	private Proveedor proveedor;
	
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

	public String getNo_parte() {
		return no_parte;
	}

	public void setNo_parte(String no_parte) {
		this.no_parte = no_parte;
	}

	public Date getFecha_cad() {
		return fecha_cad;
	}

	public void setFecha_cad(Date fecha_cad) {
		this.fecha_cad = fecha_cad;
	}

	public float getCosto() {
		return costo;
	}

	public void setCosto(float costo) {
		this.costo = costo;
	}

	public Integer getTotal_pzas() {
		return total_pzas;
	}

	public void setTotal_pzas(Integer total_pzas) {
		this.total_pzas = total_pzas;
	}

	public Almacen getAlmacen() {
		return almacen;
	}
	
	public void setAlmacen(Almacen almacen) {
		this.almacen = almacen;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public Refaccion() {
		super();
	}

	public Refaccion(Integer id, String nombre, String no_parte, Date fecha_cad, float costo, Integer total_pzas,
			Almacen almacen, Proveedor proveedor) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.no_parte = no_parte;
		this.fecha_cad = fecha_cad;
		this.costo = costo;
		this.total_pzas = total_pzas;
		this.almacen = almacen;
		this.proveedor = proveedor;
	}

	public Refaccion(String nombre) {
		super();
		this.nombre = nombre;
	}

}
