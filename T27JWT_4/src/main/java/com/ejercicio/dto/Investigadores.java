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
@Table(name="investigadores")//en caso que la tabala sea diferente
public class Investigadores {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//busca ultimo valor e incrementa desde id final de db
	private int id;
	
	@Column(name = "dni")//no hace falta si se llama igual
	private String dni;
	
	@Column(name = "nom_apels")//no hace falta si se llama igual
	private String nomapels;
	
	@ManyToOne
	@JoinColumn(name = "facultad")
	Facultad facultad;
	
	@OneToMany
	@JoinColumn(name = "dni")
	private List<Reserva> reserva;

	public Investigadores() {
		super();
	}


	public Investigadores(int id, String dni, Facultad facultad, String nomapels, List<Reserva> reserva) {
		super();
		this.id = id;
		this.dni = dni;
		this.facultad = facultad;
		this.nomapels = nomapels;
		this.reserva = reserva;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Facultad getFacultad() {
		return facultad;
	}

	public void setFacultad(Facultad facultad) {
		this.facultad = facultad;
	}

	public String getNomapels() {
		return nomapels;
	}

	public void setNomapels(String nomapels) {
		this.nomapels = nomapels;
	}

	public List<Reserva> getReserva() {
		return reserva;
	}

	public void setReserva(List<Reserva> reserva) {
		this.reserva = reserva;
	}

	@Override
	public String toString() {
		return "InvestigadoresServiceIMPL [dni=" + dni + ", facultad=" + facultad + ", nomapels=" + nomapels
				+ ", reserva=" + reserva + "]";
	}

}
