package com.ejercicio.dto;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="reserva")//en caso que la tabala sea diferente
public class Reserva {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//busca ultimo valor e incrementa desde id final de db
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "investigador")
	Investigadores investigadores;
	
	@ManyToOne
	@JoinColumn(name = "equipo")
	Equipos equipos;
	
	@Temporal(TemporalType.DATE)
	private Date comienzo;
	
	@Temporal(TemporalType.DATE)
	private Date fin;

	public Reserva() {
		super();
	}

	public Reserva(int id, Investigadores investigadores, Equipos equipos, Date comienzo, Date fin) {
		super();
		this.id = id;
		this.investigadores = investigadores;
		this.equipos = equipos;
		this.comienzo = comienzo;
		this.fin = fin;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Investigadores getInvestigadores() {
		return investigadores;
	}

	public void setInvestigadores(Investigadores investigadores) {
		this.investigadores = investigadores;
	}

	public Equipos getEquipos() {
		return equipos;
	}

	public void setEquipos(Equipos equipos) {
		this.equipos = equipos;
	}

	public Date getComienzo() {
		return comienzo;
	}

	public void setComienzo(Date comienzo) {
		this.comienzo = comienzo;
	}

	public Date getFin() {
		return fin;
	}

	public void setFin(Date fin) {
		this.fin = fin;
	}

	@Override
	public String toString() {
		return "Reserva [id=" + id + ", investigadores=" + investigadores + ", equipos=" + equipos + ", comienzo="
				+ comienzo + ", fin=" + fin + "]";
	}
}
