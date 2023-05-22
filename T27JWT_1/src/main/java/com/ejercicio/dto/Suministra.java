package com.ejercicio.dto;

import javax.persistence.Column;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;




@Entity
@Table(name = "suministra")
public class Suministra {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "precio")
	private int precio;

	@ManyToOne
	@JoinColumn(name = "codigopieza")
	private Pieza pieza;

	@ManyToOne
	@JoinColumn(name = "idproveedor")
	private Proveedor proveedor;

	
	public Suministra() {

	}

	public Suministra(int precio, Pieza pieza, Proveedor proveedor) {
		this.precio = precio;
		this.pieza = pieza;
		this.proveedor = proveedor;
	}

	// GETTERS Y SETTERS
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public Pieza getPieza() {
		return pieza;
	}

	public void setPieza(Pieza pieza) {
		this.pieza = pieza;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	// TO STRING
	@Override
	public String toString() {
		return "Suministra [id=" + id + ", precio=" + precio + ", pieza=" + pieza + ", proveedor=" + proveedor + "]";
	}

}
