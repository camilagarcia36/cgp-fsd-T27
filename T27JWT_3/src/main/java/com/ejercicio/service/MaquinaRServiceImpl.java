package com.ejercicio.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejercicio.dao.IMaquinaRDAO;
import com.ejercicio.dto.MaquinaR;

@Service
public class MaquinaRServiceImpl implements IMaquinaRService{


	@Autowired
	IMaquinaRDAO imaquinaRDAO;

	@Override
	public List<MaquinaR> listarMaquinaR() {
		return imaquinaRDAO.findAll();
	}

	@Override
	public MaquinaR guardarMaquinaR(MaquinaR maquinaR) {
		return imaquinaRDAO.save(maquinaR);
	}

	@Override
	public MaquinaR maquinaRById(int codigocaja) {
		return imaquinaRDAO.findById(codigocaja).get();
	}

	@Override
	public MaquinaR actualizarMaquinaR(MaquinaR maquinaR) {
		return imaquinaRDAO.save(maquinaR);
	}

	@Override
	public void eliminarMaquinaR(int codigocaja) {
		imaquinaRDAO.deleteById(codigocaja);

	}

}
