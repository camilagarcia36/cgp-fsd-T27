package com.ejercicio.service;

import java.util.List;

import com.ejercicio.dto.Facultad;



public interface IFacultadService {

	public List<Facultad> listarFacultads(); 
	
	public Facultad guardarFacultad(Facultad Facultad);	
	
	public Facultad FacultadXID(int id);
	
	public Facultad actualizarFacultad(Facultad Facultad); 
	
	public void eliminarFacultad(int id);
	
}