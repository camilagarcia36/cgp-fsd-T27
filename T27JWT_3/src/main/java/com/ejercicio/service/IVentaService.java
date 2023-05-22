package com.ejercicio.service;

import java.util.List;

import com.ejercicio.dto.Venta;

public interface IVentaService {

	// Metodos del CRUD
	public List<Venta> listarVenta();

	public Venta guardarVenta(Venta venta); 

	public Venta ventaById(int id); 

	public Venta actualizarVenta(Venta venta); 

	public void eliminarVenta(int id);
}
