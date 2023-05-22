package com.ejercicio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ejercicio.dto.Reserva;
import com.ejercicio.service.ReservaServiceImpl;


@RestController
@RequestMapping("/api")
public class ReservaController {
	@Autowired
	ReservaServiceImpl reservaServiceImpl;
	@PreAuthorize("hasRole('USER')")
	@GetMapping("/Reserva")
	public List<Reserva> listarReserva(){
		return reservaServiceImpl.listarReservas();
	}
	
	@PreAuthorize("hasRole('USER')")
	@PostMapping("/Reserva")
	public Reserva salvarReserva(@RequestBody Reserva Reserva) {
		
		return reservaServiceImpl.guardarReserva(Reserva);
	}
	
	@PreAuthorize("hasRole('USER')")
	@GetMapping("/Reserva/{id}")
	public Reserva ReservaXID(@PathVariable(name="id") int id) {
		
		Reserva Reserva_xid= new Reserva();
		
		Reserva_xid=reservaServiceImpl.ReservaXID(id);
		
		System.out.println("Reserva XID: "+Reserva_xid);
		
		return Reserva_xid;
	}
	@PreAuthorize("hasRole('USER')")
	@PutMapping("/Reserva/{id}")
	public Reserva actualizarReserva(@PathVariable(name="id")int id,@RequestBody Reserva Reserva) {
		
		Reserva Reserva_seleccionado= new Reserva();
		Reserva Reserva_actualizado= new Reserva();
		
		Reserva_seleccionado= reservaServiceImpl.ReservaXID(id);
		
		
		Reserva_seleccionado.setInvestigadores(Reserva.getInvestigadores());
		Reserva_seleccionado.setEquipos(Reserva.getEquipos());
		Reserva_seleccionado.setComienzo(Reserva.getComienzo());
		Reserva_seleccionado.setFin(Reserva.getFin());
		
		Reserva_actualizado = reservaServiceImpl.actualizarReserva(Reserva_seleccionado);
		
		System.out.println("El Reserva actualizado es: "+ Reserva_actualizado);
		
		return Reserva_actualizado;
	}
	@PreAuthorize("hasRole('USER')")
	@DeleteMapping("/Reserva/{id}")
	public void eleiminarReserva(@PathVariable(name="id")int id) {
		reservaServiceImpl.eliminarReserva(id);
	}
	

}
