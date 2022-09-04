package com.sistema.refa.orden_de_compra;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.sistema.refa.proveedor.Proveedor;
import com.sistema.refa.refaccion.Refaccion;

@Entity
public class Orden_de_compra {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 128, nullable = false, unique = true)
	private String descripcion;
	
	private Integer total_pzas;
	
	private Integer costo_total;
	
	private Date fecha_entrega;
	
	private Date fecha_compra;
	
	@ManyToOne
	@JoinColumn(name = "proveedor_id")
	private Proveedor proveedor;
	
	@ManyToOne
	@JoinColumn(name = "refaccion_id")
	private Refaccion refaccion;
	
	private Boolean condicion;
	
	private Boolean status;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getTotal_pzas() {
		return total_pzas;
	}

	public void setTotal_pzas(Integer total_pzas) {
		this.total_pzas = total_pzas;
	}

	public Integer getCosto_total() {
		return costo_total;
	}

	public void setCosto_total(Integer costo_total) {
		this.costo_total = costo_total;
	}

	public Date getFecha_entrega() {
		return fecha_entrega;
	}

	public void setFecha_entrega(Date fecha_entrega) {
		this.fecha_entrega = fecha_entrega;
	}

	public Date getFecha_compra() {
		return fecha_compra;
	}

	public void setFecha_compra(Date fecha_compra) {
		this.fecha_compra = fecha_compra;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public Refaccion getRefaccion() {
		return refaccion;
	}

	public void setRefaccion(Refaccion refaccion) {
		this.refaccion = refaccion;
	}

	public Boolean getCondicion() {
		return condicion;
	}

	public void setCondicion(Boolean condicion) {
		this.condicion = condicion;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Orden_de_compra() {
		super();
	}

	public Orden_de_compra(Integer id, String descripcion, Integer total_pzas, Integer costo_total, Date fecha_entrega,
			Date fecha_compra, Proveedor proveedor, Refaccion refaccion, Boolean condicion, Boolean status) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.total_pzas = total_pzas;
		this.costo_total = costo_total;
		this.fecha_entrega = fecha_entrega;
		this.fecha_compra = fecha_compra;
		this.proveedor = proveedor;
		this.refaccion = refaccion;
		this.condicion = condicion;
		this.status = status;
	}

	public Orden_de_compra(String descripcion) {
		super();
		this.descripcion = descripcion;
	}

	
	
	
}
