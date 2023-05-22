package com.ejercicio.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejercicio.dao.ICientificoDAO;
import com.ejercicio.dto.Cientifico;



@Service
public class CientificosServiceImpl implements ICientificoService {

	@Autowired
	ICientificoDAO icientificoDAO;

	@Override
	public List<Cientifico> listarCientifico() {
		return icientificoDAO.findAll();
	}

	@Override
	public Cientifico guardarCientifico(Cientifico cientifico) {
		return icientificoDAO.save(cientifico);
	}

	@Override
	public Cientifico cientificoById(int idcientificos) {
		return icientificoDAO.findById(idcientificos).get();
	}

	@Override
	public Cientifico actualizarCientifico(Cientifico cientifico) {
		return icientificoDAO.save(cientifico);
	}

	@Override
	public void eliminarCientifico(int codigo) {
		icientificoDAO.deleteById(codigo);

	}

}
