package com.sistema.refa.pedimento;

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
public class Pedimento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(length = 128, nullable = false, unique = true)
	private String descripcion;
	
	private Integer total_pzas;
	
	private Integer costo_total;
	
	private Date fecha_entrega;
	
	@ManyToOne
	@JoinColumn(name = "refaccion_id")
	private Refaccion refaccion;
	
	@ManyToOne
	@JoinColumn(name = "proveedor_id")
	private Proveedor proveedor;

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

	public Refaccion getRefaccion() {
		return refaccion;
	}

	public void setRefaccion(Refaccion refaccion) {
		this.refaccion = refaccion;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public Pedimento() {
		super();
	}

	public Pedimento(Integer id, String descripcion, Integer total_pzas, Integer costo_total, Date fecha_entrega,
			Refaccion refaccion, Proveedor proveedor) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.total_pzas = total_pzas;
		this.costo_total = costo_total;
		this.fecha_entrega = fecha_entrega;
		this.refaccion = refaccion;
		this.proveedor = proveedor;
	}
	
	public Pedimento(String descripcion) {
		super();
		this.descripcion = descripcion;
	}
	
	

}
