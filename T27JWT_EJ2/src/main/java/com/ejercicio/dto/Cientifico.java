package com.ejercicio.dto;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "cientificos")
public class Cientifico {
	@Id
	@Column(name = "idcientificos")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idcientificos;
	@Column(name = "nom_apels")
	private String nombreApellido;
	@Column(name = "dni")
	private String dni;
	
	@OneToMany
	@JoinColumn(name = "asignado")
	private List<Asignado> asignado;

	public Cientifico(int idcientificos, String nombreApellido, String dni, List<Asignado> asignado) {
		super();
		this.idcientificos = idcientificos;
		this.nombreApellido = nombreApellido;
		this.dni = dni;
		this.asignado = asignado;
	}

	public Cientifico() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the idcientificos
	 */
	public int getIdcientificos() {
		return idcientificos;
	}

	/**
	 * @param idcientificos the idcientificos to set
	 */
	public void setIdcientificos(int idcientificos) {
		this.idcientificos = idcientificos;
	}

	/**
	 * @return the nombreApellido
	 */
	public String getNombreApellido() {
		return nombreApellido;
	}

	/**
	 * @param nombreApellido the nombreApellido to set
	 */
	public void setNombreApellido(String nombreApellido) {
		this.nombreApellido = nombreApellido;
	}

	/**
	 * @return the dni
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * @param dni the dni to set
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}

	/**
	 * @return the asignado
	 */
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Asignado")
	public List<Asignado> getAsignado() {
		return asignado;
	}

	/**
	 * @param asignado the asignado to set
	 */
	public void setAsignado(List<Asignado> asignado) {
		this.asignado = asignado;
	}

	@Override
	public String toString() {
		return "Cientifico [idcientificos=" + idcientificos + ", nombreApellido=" + nombreApellido + ", dni=" + dni
				+ "]";
	}



}
