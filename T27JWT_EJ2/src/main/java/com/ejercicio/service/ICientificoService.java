package com.ejercicio.service;

import java.util.List;

import com.ejercicio.dto.Cientifico;

public interface ICientificoService {

	//  CRUD
	public List<Cientifico> listarCientifico(); 

	public Cientifico guardarCientifico(Cientifico cientifico); 

	public Cientifico cientificoById(int idcientificos); // READ

	public Cientifico actualizarCientifico(Cientifico cientifico); // UPDATE

	public void eliminarCientifico(int idcientificos);//  DELETE
}
