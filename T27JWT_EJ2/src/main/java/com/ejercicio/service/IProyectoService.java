package com.ejercicio.service;

import java.util.List;

import com.ejercicio.dto.Proyecto;

public interface IProyectoService {
	
	public List<Proyecto> listarProyecto(); // Listar 

	public Proyecto guardarProyecto(Proyecto proyecto); // CREATE

	public Proyecto proyectoById(int id); // READ

	public Proyecto actualizarProyecto(Proyecto proyecto); // UPDATE

	public void eliminarProyecto(int id);//  DELETE
}