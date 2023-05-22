package com.ejercicio.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.ejercicio.dto.Proveedor;
import com.ejercicio.service.ProveedorServiceImpl;

@RestController
@RequestMapping("/api")
public class ProveedorController {

	@Autowired
	ProveedorServiceImpl proveedorServiceImpl;
	@PreAuthorize("hasRole('USER')")
	@GetMapping("/proveedores")
	public List<Proveedor> listarProveedor() {
		return proveedorServiceImpl.listarProveedor();
	}
	@PreAuthorize("hasRole('USER')")
	@PostMapping("/proveedores")
	public Proveedor guardarProveedor(@RequestBody Proveedor proveedor) {
		return proveedorServiceImpl.guardarProveedor(proveedor);
	}
	@PreAuthorize("hasRole('USER')")
	@GetMapping("/proveedores/{id}")
	public Proveedor proveedorById(@PathVariable(name = "id") int id) {
		Proveedor proveedor = new Proveedor();
		proveedor = proveedorServiceImpl.proveedorById(id);
		return proveedor;
	}
	@PreAuthorize("hasRole('USER')")
	@PutMapping("/proveedores/{id}")
	public Proveedor actualizarProveedor(@PathVariable(name = "id") int id, @RequestBody Proveedor proveedor) {

		Proveedor proveedor_seleccionado = new Proveedor();
		Proveedor proveedor_actualizado = new Proveedor();
		proveedor_seleccionado = proveedorServiceImpl.proveedorById(id);

		proveedor_seleccionado.setNombre(proveedor.getNombre());
		proveedor_seleccionado.setSuministra(proveedor.getSuministra());

		proveedor_actualizado = proveedorServiceImpl.actualizarProveedor(proveedor_seleccionado);
		return proveedor_actualizado;
	}
	@PreAuthorize("hasRole('USER')")
	@DeleteMapping("/proveedores/{id}")
	public void eliminarProveedor(@PathVariable(name = "id") int id) {
		proveedorServiceImpl.eliminarProveedor(id);
	}

}