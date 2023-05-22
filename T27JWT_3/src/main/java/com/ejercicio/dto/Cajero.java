package com.ejercicio.dto;

import java.util.List;


import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name = "cajeros")
public class Cajero {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "nombre")
	private String nombre;

	@OneToMany
	@JoinColumn(name = "venta")
	private List<Venta> venta;

	// CONSTRUCTORES
	public Cajero() {

	}

	public Cajero(int id, String nombre, List<Venta> venta) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.venta = venta;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the nomApels
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nomApels the nomApels to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
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
		return "Cajero [id=" + id + ", nomApels=" + nombre + ", venta=" + venta + "]";
	}

	

}
