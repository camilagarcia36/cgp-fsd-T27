package com.ejercicio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.ejercicio.dto.Cajero;
import com.ejercicio.service.CajeroServiceImpl;

@RestController
@RequestMapping("/api")
public class CajeroController {

	@Autowired
	CajeroServiceImpl cajeroServiceImpl;
	@PreAuthorize("hasRole('USER')")
	@GetMapping("/Cajeros")
	public List<Cajero> listarCajero() {
		return cajeroServiceImpl.listarCajero();
	}
	@PreAuthorize("hasRole('USER')")
	@PostMapping("/Cajeros")
	public Cajero guardarCajero(@RequestBody Cajero cajero) {
		return cajeroServiceImpl.guardarCajero(cajero);
	}
	@PreAuthorize("hasRole('USER')")
	@GetMapping("/Cajeros/{id}")
	public Cajero cajeroById(@PathVariable(name = "id") int id) {
		Cajero cajero = new Cajero();
		cajero = cajeroServiceImpl.cajeroById(id);
		return cajero;
	}
	@PreAuthorize("hasRole('USER')")
	@PutMapping("/Cajeros/{id}")
	public Cajero actualizarCajero(@PathVariable(name = "id") int id, @RequestBody Cajero cajero) {

		Cajero cajero_seleccionado = new Cajero();
		Cajero cajero_actualizado = new Cajero();
		cajero_seleccionado = cajeroServiceImpl.cajeroById(id);
		cajero_seleccionado.setNombre(cajero.getNombre());
		cajero_seleccionado.setVenta(cajero.getVenta());

		cajero_actualizado = cajeroServiceImpl.actualizarCajero(cajero_seleccionado);
		return cajero_actualizado;
	}
	@PreAuthorize("hasRole('USER')")
	@DeleteMapping("/Cajeros/{id}")
	public void eliminarCajero(@PathVariable(name = "id") int id) {
		cajeroServiceImpl.eliminarCajero(id);
	}

}