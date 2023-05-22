package com.ejercicio.service;

import java.util.List;

import com.ejercicio.dto.Equipos;


public interface IEquiposService {

	public List<Equipos> listarEquipos(); 
	
	public Equipos guardarEquipos(Equipos Equipos);	
	
	public Equipos EquiposXID(int id);
	
	public Equipos actualizarEquipos(Equipos Equipos); 
	
	public void eliminarEquipos(int id);
	
}