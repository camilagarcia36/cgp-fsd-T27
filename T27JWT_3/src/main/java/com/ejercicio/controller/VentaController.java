package com.ejercicio.controller;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.ejercicio.dto.Venta;
import com.ejercicio.service.VentaServiceImpl;

@RestController
@RequestMapping("/api")
public class VentaController {

	@Autowired
	VentaServiceImpl ventaServiceImpl;;
	@PreAuthorize("hasRole('USER')")
	@GetMapping("/Venta")
	public List<Venta> listarVenta() {
		return ventaServiceImpl.listarVenta();
	}
	@PreAuthorize("hasRole('USER')")
	@PostMapping("/Venta")
	public Venta guardarVenta(@RequestBody Venta venta) {
		return ventaServiceImpl.guardarVenta(venta);
	}
	@PreAuthorize("hasRole('USER')")
	@GetMapping("/Venta/{id}")
	public Venta ventaById(@PathVariable(name = "id") int id) {
		Venta venta = new Venta();
		venta = ventaServiceImpl.ventaById(id);
		return venta;
	}
	@PreAuthorize("hasRole('USER')")
	@PutMapping("/Venta/{id}")
	public Venta actualizarVenta(@PathVariable(name = "id") int id, @RequestBody Venta venta) {

		Venta venta_seleccionado = new Venta();
		Venta venta_actualizado = new Venta();
		venta_seleccionado = ventaServiceImpl.ventaById(id);
		venta_seleccionado.setId(id);
		venta_seleccionado.setCajero(venta.getCajero());
		venta_seleccionado.setMaquinar(venta.getMaquinar());
		venta_seleccionado.setProducto(venta.getProducto());

		venta_actualizado = ventaServiceImpl.actualizarVenta(venta_seleccionado);
		return venta_actualizado;
	}
	@PreAuthorize("hasRole('USER')")
	@DeleteMapping("/Venta/{id}")
	public void eliminarEmpleado(@PathVariable(name = "id") int id) {
		ventaServiceImpl.eliminarVenta(id);
	}
}