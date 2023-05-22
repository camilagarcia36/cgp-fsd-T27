package com.ejercicio.service;

import java.util.List;

import com.ejercicio.dto.Cajero;


public interface ICajeroService {

	public List<Cajero> listarCajero(); 

	public Cajero guardarCajero(Cajero cajero); 

	public Cajero cajeroById(int id);

	public Cajero actualizarCajero(Cajero cajero); 

	public void eliminarCajero(int id);
}
