package com.ejercicio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.ejercicio.dto.Pieza;
import com.ejercicio.service.PiezaServiceImpl;



@RestController
@RequestMapping("/api")
public class PiezaController {
	
	@Autowired
	PiezaServiceImpl piezaServiceImpl;
	
	@PreAuthorize("hasRole('USER')")
	@GetMapping("/piezas")
	public List<Pieza> listarPieza(){
		return piezaServiceImpl.listarPieza();
	}
	@PreAuthorize("hasRole('USER')")
	@PostMapping("/piezas")
	public Pieza guardarPieza(@RequestBody Pieza pieza) {
		return piezaServiceImpl.guardarPieza(pieza);
	}
	
	@PreAuthorize("hasRole('USER')")
	@GetMapping("/piezas/{codigo}")
	public Pieza piezaById(@PathVariable(name="codigo") int codigo) {
		Pieza pieza= new Pieza();
		pieza=piezaServiceImpl.piezaById(codigo);
		return pieza;
	}
	
	@PreAuthorize("hasRole('USER')")
	@PutMapping("/piezas/{codigo}")
	public Pieza actualizarPieza(@PathVariable(name="codigo")int codigo,@RequestBody Pieza pieza) {
		
		Pieza pieza_seleccionado= new Pieza();
		Pieza pieza_actualizado= new Pieza();
		pieza_seleccionado= piezaServiceImpl.piezaById(codigo);
		pieza_seleccionado.setNombre(pieza.getNombre());
		pieza_seleccionado.setSuministra(pieza.getSuministra());
		
		
		pieza_actualizado = piezaServiceImpl.actualizarPieza(pieza_seleccionado);
		
		return pieza_actualizado;
	}
	
	@PreAuthorize("hasRole('USER')")
	@DeleteMapping("/piezas/{codigo}")
	public void eliminarPieza(@PathVariable(name="codigo")int codigo) {
		piezaServiceImpl.eliminarPieza(codigo);
	}

}
