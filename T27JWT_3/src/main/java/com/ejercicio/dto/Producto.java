package com.ejercicio.dto;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "productos")
public class Producto {
	@Id
	@Column(name = "codigoproducto")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigoproducto;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "precio")
	private int precio;
	

	@OneToMany
	@JoinColumn(name = "venta")
	private List<Venta> venta;

	// CONSTRUCTORES
	public Producto() {

	}

	public Producto(String nombre) {
		this.nombre = nombre;
	}

	
	public Producto(int codigoproducto, String nombre, int precio, List<Venta> venta) {
		super();
		this.codigoproducto = codigoproducto;
		this.nombre = nombre;
		this.precio = precio;
		this.venta = venta;
	}

	/**
	 * @return the codigoproducto
	 */
	public int getCodigoproducto() {
		return codigoproducto;
	}

	/**
	 * @param codigoproducto the codigoproducto to set
	 */
	public void setCodigoproducto(int codigoproducto) {
		this.codigoproducto = codigoproducto;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the precio
	 */
	public int getPrecio() {
		return precio;
	}

	/**
	 * @param precio the precio to set
	 */
	public void setPrecio(int precio) {
		this.precio = precio;
	}

	/**
	 * @return the venta
	 */
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Venta")
	public List<Venta> getVenta() {
		return venta;
	}

	/**
	 * @param venta the venta to set
	 */
	public void setVenta(List<Venta> venta) {
		this.venta = venta;
	}

	@Override
	public String toString() {
		return "Producto [codigoproducto=" + codigoproducto + ", nombre=" + nombre + ", precio=" + precio + ", venta="
				+ venta + "]";
	}

	

}
