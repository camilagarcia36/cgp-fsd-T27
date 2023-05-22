package com.ejercicio.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="equipos")//en caso que la tabala sea diferente
public class Equipos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//busca ultimo valor e incrementa desde id final de db
	private int id;
	
	@Column(name = "numserie")//no hace falta si se llama igual
	private String numserie;

	@Column(name = "nombre")//no hace falta si se llama igual
	private String nombre_facultad;

	@ManyToOne
	@JoinColumn(name = "facultad")
	Facultad facultad;
	
	@OneToMany
	@JoinColumn(name = "numserie")
	private List<Reserva> reserva;

	public Equipos() {
		super();
	}

	public Equipos(int id, String numserie, String nombre_facultad, Facultad facultad, List<Reserva> reserva) {
		super();
		this.id = id;
		this.numserie = numserie;
		this.nombre_facultad = nombre_facultad;
		this.facultad = facultad;
		this.reserva = reserva;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNumserie(String numserie) {
		this.numserie = numserie;
	}
	
	public String getNumserie() {
		return numserie;
	}

	public String getNombre_facultad() {
		return nombre_facultad;
	}

	public void setNombre_facultad(String nombre_facultad) {
		this.nombre_facultad = nombre_facultad;
	}

	public Facultad getFacultad() {
		return facultad;
	}

	public void setFacultad(Facultad facultad) {
		this.facultad = facultad;
	}

	public List<Reserva> getReserva() {
		return reserva;
	}

	public void setReserva(List<Reserva> reserva) {
		this.reserva = reserva;
	}

	@Override
	public String toString() {
		return "Equipos [numserie=" + id + ", nombre_facultad=" + nombre_facultad + ", facultad=" + facultad
				+ ", reserva=" + reserva + "]";
	}

}
