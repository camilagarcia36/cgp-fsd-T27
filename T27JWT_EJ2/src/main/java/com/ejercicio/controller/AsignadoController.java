package com.ejercicio.controller;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.ejercicio.dto.Asignado;
import com.ejercicio.service.AsignadoServiceImpl;

@RestController
@RequestMapping("/api")
public class AsignadoController {

	@Autowired
	AsignadoServiceImpl asignadoServiceImpl;;

	@PreAuthorize("hasRole('USER')")
	@GetMapping("/asignado")
	public List<Asignado> listarAsignado() {
		return asignadoServiceImpl.listarAsignado();
	}
	@PreAuthorize("hasRole('USER')")
	@PostMapping("/asignado")
	public Asignado guardarAsignado(@RequestBody Asignado asignado) {
		return asignadoServiceImpl.guardarAsignado(asignado);
	}
	@PreAuthorize("hasRole('USER')")
	@GetMapping("/asignado/{id}")
	public Asignado asignadoById(@PathVariable(name = "id") int id) {
		Asignado asignado = new Asignado();
		asignado = asignadoServiceImpl.asignadoById(id);
		return asignado;
	}
	@PreAuthorize("hasRole('USER')")
	@PutMapping("/asignado/{id}")
	public Asignado actualizarAsignado(@PathVariable(name = "id") int id, @RequestBody Asignado asignado) {

		Asignado asignado_seleccionado = new Asignado();
		Asignado asignado_actualizado = new Asignado();
		asignado_seleccionado = asignadoServiceImpl.asignadoById(id);
	
		asignado_seleccionado.setCientifico(asignado.getCientifico());
		asignado_seleccionado.setProyecto(asignado.getProyecto());

		asignado_actualizado = asignadoServiceImpl.actualizarAsignado(asignado_seleccionado);
		return asignado_actualizado;
	}
	@PreAuthorize("hasRole('USER')")
	@DeleteMapping("/asignado/{id}")
	public void eliminarAsignado(@PathVariable(name = "id") int id) {
		asignadoServiceImpl.eliminarAsignado(id);
	}
}