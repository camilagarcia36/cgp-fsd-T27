package com.ejercicio.dto;

import java.util.List;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "proveedores")
public class Proveedor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "nombre")
	private String nombre;

	@OneToMany
	@JoinColumn(name = "suministra")
	private List<Suministra> suministra;

	public Proveedor() {

	}

	
	public Proveedor(int id, String nombre, List<Suministra> suministra) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.suministra = suministra;
	}


	public Proveedor(String nombre) {
		this.nombre = nombre;
	}

	// GETTERS Y SETTERS
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setSuministra(List<Suministra> suministra) {
		this.suministra = suministra;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Suministra")
	public List<Suministra> getSuministra() {
		return suministra;
	}

	// TO STRING
	@Override
	public String toString() {
		return "Proveedor [id=" + id + ", nombre=" + nombre + ", suministra=" + suministra + "]";
	}

}
