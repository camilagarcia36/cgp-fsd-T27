package com.ejercicio.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.ejercicio.dto.Proyecto;
import com.ejercicio.service.ProyectoServiceImpl;

@RestController
@RequestMapping("/api")
public class ProyectoController {

	@Autowired
	ProyectoServiceImpl proyectoServiceImpl;
	@PreAuthorize("hasRole('USER')")
	@GetMapping("/proyectos")
	public List<Proyecto> listarProyecto() {
		return proyectoServiceImpl.listarProyecto();
	}
	@PreAuthorize("hasRole('USER')")
	@PostMapping("/proyectos")
	public Proyecto guardarProyecto(@RequestBody Proyecto proyecto) {
		return proyectoServiceImpl.guardarProyecto(proyecto);
	}
	@PreAuthorize("hasRole('USER')")
	@GetMapping("/proyectos/{id}")
	public Proyecto proveedorById(@PathVariable(name = "id") int id) {
		Proyecto proyecto = new Proyecto();
		proyecto = proyectoServiceImpl.proyectoById(id);
		return proyecto;
	}
	@PreAuthorize("hasRole('USER')")
	@PutMapping("/proyectos/{id}")
	public Proyecto actualizarProyecto(@PathVariable(name = "id") int id, @RequestBody Proyecto proyecto) {

		Proyecto proyecto_seleccionado = new Proyecto();
		Proyecto proyecto_actualizado = new Proyecto();
		proyecto_seleccionado = proyectoServiceImpl.proyectoById(id);
		proyecto_seleccionado.setNombre(proyecto.getNombre());
		proyecto_seleccionado.setAsignado(proyecto.getAsignado());

		proyecto_actualizado = proyectoServiceImpl.actualizarProyecto(proyecto_seleccionado);
		return proyecto_actualizado;
	}
	@PreAuthorize("hasRole('USER')")
	@DeleteMapping("/proyectos/{id}")
	public void eliminarProyecto(@PathVariable(name = "id") int id) {
		proyectoServiceImpl.eliminarProyecto(id);
	}

}