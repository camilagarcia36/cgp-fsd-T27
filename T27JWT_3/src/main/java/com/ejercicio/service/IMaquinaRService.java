package com.ejercicio.service;

import java.util.List;


import com.ejercicio.dto.MaquinaR;

public interface IMaquinaRService {
	
	public List<MaquinaR> listarMaquinaR(); 

	public MaquinaR guardarMaquinaR(MaquinaR MaquinaR); 

	public MaquinaR maquinaRById(int codigocaja); 

	public MaquinaR actualizarMaquinaR(MaquinaR MaquinaR); 

	public void eliminarMaquinaR(int codigocaja);
}