package com.ejercicio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejercicio.dao.IProveedorDAO;
import com.ejercicio.dto.Proveedor;

@Service
public class ProveedorServiceImpl implements IProveedorService{


	@Autowired
	IProveedorDAO iProveedorDAO;

	@Override
	public List<Proveedor> listarProveedor() {
		return iProveedorDAO.findAll();
	}

	@Override
	public Proveedor guardarProveedor(Proveedor proveedor) {
		return iProveedorDAO.save(proveedor);
	}

	@Override
	public Proveedor proveedorById(int id) {
		return iProveedorDAO.findById(id).get();
	}

	@Override
	public Proveedor actualizarProveedor(Proveedor proveedor) {
		return iProveedorDAO.save(proveedor);
	}

	@Override
	public void eliminarProveedor(int id) {
		iProveedorDAO.deleteById(id);

	}

}
