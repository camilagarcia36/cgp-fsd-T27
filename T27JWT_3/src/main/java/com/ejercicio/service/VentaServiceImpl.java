package com.ejercicio.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejercicio.dao.IVentaDAO;
import com.ejercicio.dto.Venta;

@Service
public class VentaServiceImpl implements IVentaService {

	@Autowired
	IVentaDAO iventaDAO;

	@Override
	public List<Venta> listarVenta() {
		return iventaDAO.findAll();
	}

	@Override
	public Venta guardarVenta(Venta Venta) {
		return iventaDAO.save(Venta);
	}

	@Override
	public Venta ventaById(int id) {
		return iventaDAO.findById(id).get();
	}

	@Override
	public Venta actualizarVenta(Venta Venta) {
		return iventaDAO.save(Venta);
	}

	@Override
	public void eliminarVenta(int id) {
		iventaDAO.deleteById(id);
		
	}
}
