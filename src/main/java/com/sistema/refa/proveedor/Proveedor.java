package com.sistema.refa.proveedor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.sistema.refa.refaccion.Refaccion;

@Entity
public class Proveedor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(length = 13, nullable = false)
	private String rfc;

	private String nombre;

	private String direccion_fiscal;

	private String moneda_pago;

	private String nacionalidad;

	@ManyToOne
	@JoinColumn(name = "refaccion_id")
	private Refaccion refaccion;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRfc() {
		return rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion_fiscal() {
		return direccion_fiscal;
	}

	public void setDireccion_fiscal(String direccion_fiscal) {
		this.direccion_fiscal = direccion_fiscal;
	}

	public String getMoneda_pago() {
		return moneda_pago;
	}

	public void setMoneda_pago(String moneda_pago) {
		this.moneda_pago = moneda_pago;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public Refaccion getRefaccion() {
		return refaccion;
	}

	public void setRefaccion(Refaccion refaccion) {
		this.refaccion = refaccion;
	}

	public Proveedor() {
		super();
	}

	public Proveedor(Integer id, String rfc, String nombre, String direccion_fiscal, String moneda_pago,
			String nacionalidad, Refaccion refaccion) {
		super();
		this.id = id;
		this.rfc = rfc;
		this.nombre = nombre;
		this.direccion_fiscal = direccion_fiscal;
		this.moneda_pago = moneda_pago;
		this.nacionalidad = nacionalidad;
		this.refaccion = refaccion;
	}
	
	public Proveedor(String rfc, String nombre, String direccion_fiscal, String moneda_pago,
			String nacionalidad, Refaccion refaccion) {
		super();
		this.rfc = rfc;
		this.nombre = nombre;
		this.direccion_fiscal = direccion_fiscal;
		this.moneda_pago = moneda_pago;
		this.nacionalidad = nacionalidad;
		this.refaccion = refaccion;
	}

	public Proveedor(String nombre) {
		super();
		this.nombre = nombre;

	}
}
