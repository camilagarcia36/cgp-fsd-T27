package com.ejercicio.service;

import java.util.List;

import com.ejercicio.dto.Suministra;

public interface ISuministraService {

	// Metodos del CRUD
	public List<Suministra> listarSuministra(); //  All

	public Suministra guardarSuministra(Suministra suministra); //CREATE

	public Suministra suministraById(int id); //  READ

	public Suministra actualizarSuministra(Suministra suministra); // UPDATE

	public void eliminarSuministra(int id);//  DELETE
}
