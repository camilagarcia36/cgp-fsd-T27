package com.ejercicio.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejercicio.dao.ICajeroDAO;
import com.ejercicio.dto.Cajero;

@Service
public class CajeroServiceImpl implements ICajeroService {

	@Autowired
	ICajeroDAO icajeroDAO;

	@Override
	public List<Cajero> listarCajero() {
		return icajeroDAO.findAll();
	}

	@Override
	public Cajero guardarCajero(Cajero cajero) {
		return icajeroDAO.save(cajero);
	}

	@Override
	public Cajero cajeroById(int id) {
		return icajeroDAO.findById(id).get();
	}

	@Override
	public Cajero actualizarCajero(Cajero cajero) {
		return icajeroDAO.save(cajero);
	}

	@Override
	public void eliminarCajero(int id) {
		icajeroDAO.deleteById(id);

	}

}
