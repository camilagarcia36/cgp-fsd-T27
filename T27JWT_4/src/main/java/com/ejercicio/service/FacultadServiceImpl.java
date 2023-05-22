package com.ejercicio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejercicio.dao.IFacultadDAO;
import com.ejercicio.dto.Facultad;


@Service
public class FacultadServiceImpl implements IFacultadService {

	@Autowired
	IFacultadDAO iFacultadDAO;

	@Override
	public List<Facultad> listarFacultads() {
		// TODO Auto-generated method stub
		return iFacultadDAO.findAll();
	}

	@Override
	public Facultad guardarFacultad(Facultad Facultad) {
		// TODO Auto-generated method stub
		return iFacultadDAO.save(Facultad);
	}

	@Override
	public Facultad FacultadXID(int id) {
		// TODO Auto-generated method stub
		return iFacultadDAO.findById(id).get();
	}

	@Override
	public Facultad actualizarFacultad(Facultad Facultad) {
		// TODO Auto-generated method stub
		return iFacultadDAO.save(Facultad);
	}

	@Override
	public void eliminarFacultad(int id) {
		// TODO Auto-generated method stub
		iFacultadDAO.deleteById(id);
	}
	
}