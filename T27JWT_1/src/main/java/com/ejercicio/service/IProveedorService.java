package com.ejercicio.service;

import java.util.List;

import com.ejercicio.dto.Proveedor;

public interface IProveedorService {
	
	public List<Proveedor> listarProveedor(); // Listar 

	public Proveedor guardarProveedor(Proveedor proveedor); // CREATE

	public Proveedor proveedorById(int id); // READ

	public Proveedor actualizarProveedor(Proveedor proveedor); // UPDATE

	public void eliminarProveedor(int id);//  DELETE
}