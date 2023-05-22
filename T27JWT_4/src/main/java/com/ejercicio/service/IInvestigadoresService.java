package com.ejercicio.service;

import java.util.List;

import com.ejercicio.dto.Investigadores;

public interface IInvestigadoresService {


	public List<Investigadores> listarInvestigadores(); 
	
	public Investigadores guardarInvestigadores(Investigadores Investigadores);	
	
	public Investigadores InvestigadoresXID(int id);
	
	public Investigadores actualizarInvestigadores(Investigadores Investigadores); 
	
	public void eliminarInvestigadores(int id);
}
