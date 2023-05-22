package com.ejercicio.dto;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "piezas")
public class Pieza {
	@Id
	@Column(name = "codigo")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;
	@Column(name = "nombre")
	private String nombre;

	@OneToMany
	@JoinColumn(name = "suministra")
	private List<Suministra> suministra;

	// CONSTRUCTORES
	public Pieza() {

	}
	
	

	public Pieza(int codigo, String nombre, List<Suministra> suministra) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.suministra = suministra;
	}



	public Pieza(String nombre) {
		this.nombre = nombre;
	}

	// GETTERS Y SETTERS
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
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
		return "Pieza [codigo=" + codigo + ", nombre=" + nombre + ", suministra=" + suministra + "]";
	}

}
