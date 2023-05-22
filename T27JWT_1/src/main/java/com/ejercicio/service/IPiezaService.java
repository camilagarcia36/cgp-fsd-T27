package com.ejercicio.service;

import java.util.List;

import com.ejercicio.dto.Pieza;

public interface IPiezaService {

	//  CRUD
	public List<Pieza> listarPieza(); 

	public Pieza guardarPieza(Pieza pieza); 

	public Pieza piezaById(int codigo); // READ

	public Pieza actualizarPieza(Pieza pieza); // UPDATE

	public void eliminarPieza(int codigo);//  DELETE
}
