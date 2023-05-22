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
@Table(name = "maquinas_registradoras")
public class MaquinaR {

	@Id
	@Column(name = "codigocaja")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigocaja;
	@Column(name = "piso")
	private int piso;

	@OneToMany
	@JoinColumn(name = "venta")
	private List<Venta> venta;

	// CONSTRUCTORES
	public MaquinaR() {

	}

	public MaquinaR(int codigocaja, int piso, List<Venta> venta) {
		super();
		this.codigocaja = codigocaja;
		this.piso = piso;
		this.venta = venta;
	}

	/**
	 * @return the codigocaja
	 */
	public int getCodigocaja() {
		return codigocaja;
	}

	/**
	 * @param codigocaja the codigocaja to set
	 */
	public void setCodigocaja(int codigocaja) {
		this.codigocaja = codigocaja;
	}

	/**
	 * @return the piso
	 */
	public int getPiso() {
		return piso;
	}

	/**
	 * @param piso the piso to set
	 */
	public void setPiso(int piso) {
		this.piso = piso;
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
		return "MaquinaR [codigocaja=" + codigocaja + ", piso=" + piso + ", venta=" + venta + "]";
	}

	
	
}
