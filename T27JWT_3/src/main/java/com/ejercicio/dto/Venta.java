package com.ejercicio.dto;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "venta")
public class Venta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@JoinColumn(name = "cajero")
	private Cajero cajero;

	@ManyToOne
	@JoinColumn(name = "producto")
	private Producto producto;

	@ManyToOne
	@JoinColumn(name = "maquina")
	private MaquinaR maquinar;

	// CONTRUCTORES
	public Venta() {

	}

	public Venta(int id, Cajero cajero, Producto producto, MaquinaR maquinar) {
		super();
		this.id = id;
		this.cajero = cajero;
		this.producto = producto;
		this.maquinar = maquinar;
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
	 * @return the cajero
	 */
	public Cajero getCajero() {
		return cajero;
	}

	/**
	 * @param cajero the cajero to set
	 */
	public void setCajero(Cajero cajero) {
		this.cajero = cajero;
	}

	/**
	 * @return the producto
	 */
	public Producto getProducto() {
		return producto;
	}

	/**
	 * @param producto the producto to set
	 */
	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	/**
	 * @return the maquinar
	 */
	
	public MaquinaR getMaquinar() {
		return maquinar;
	}

	/**
	 * @param maquinar the maquinar to set
	 */
	public void setMaquinar(MaquinaR maquinar) {
		this.maquinar = maquinar;
	}

	@Override
	public String toString() {
		return "Venta [id=" + id + ", cajero=" + cajero + ", producto=" + producto + ", maquinar=" + maquinar + "]";
	}
	
	
}
