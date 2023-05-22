package com.ejercicio.service;

import java.util.List;

import com.ejercicio.dto.Asignado;

public interface IAsignadoService {

	// Metodos del CRUD
	public List<Asignado> listarAsignado(); //  All

	public Asignado guardarAsignado(Asignado asignado); //CREATE

	public Asignado asignadoById(int id); //  READ

	public Asignado actualizarAsignado(Asignado asignado); // UPDATE

	public void eliminarAsignado(int id);//  DELETE
}
