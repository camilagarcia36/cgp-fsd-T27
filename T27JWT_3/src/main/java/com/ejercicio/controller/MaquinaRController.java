package com.ejercicio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.ejercicio.dto.MaquinaR;
import com.ejercicio.service.MaquinaRServiceImpl;


@RestController
@RequestMapping("/api")
public class MaquinaRController {

	@Autowired
MaquinaRServiceImpl maquinaRServiceImpl;
	@PreAuthorize("hasRole('USER')")
	@GetMapping("/Maquinas")
	public List<MaquinaR> listarMaquinaR() {
		return maquinaRServiceImpl.listarMaquinaR();
	}
	@PreAuthorize("hasRole('USER')")
	@PostMapping("/Maquinas")
	public MaquinaR guardarMaquinaR(@RequestBody MaquinaR maquinaR) {
		return maquinaRServiceImpl.guardarMaquinaR(maquinaR);
	}
	@PreAuthorize("hasRole('USER')")
	@GetMapping("/Maquinas/{codigocaja}")
	public MaquinaR maquinaRById(@PathVariable(name = "codigocaja") int codigocaja) {
		MaquinaR maquinaR = new MaquinaR();
		maquinaR = maquinaRServiceImpl.maquinaRById(codigocaja);
		return maquinaR;
	}
	@PreAuthorize("hasRole('USER')")
	@PutMapping("/Maquinas/{codigocaja}")
	public MaquinaR actualizarMaquinaR(@PathVariable(name = "codigocaja") int codigocaja, @RequestBody MaquinaR maquinaR) {

		MaquinaR maquinaR_seleccionado = new MaquinaR();
		MaquinaR maquinaR_actualizado = new MaquinaR();
		maquinaR_seleccionado = maquinaRServiceImpl.maquinaRById(codigocaja);

		maquinaR_seleccionado.setPiso(maquinaR.getPiso());
		maquinaR_seleccionado.setVenta(maquinaR.getVenta());

		maquinaR_actualizado = maquinaRServiceImpl.actualizarMaquinaR(maquinaR_seleccionado);
		return maquinaR_actualizado;
	}
	@PreAuthorize("hasRole('USER')")
	@DeleteMapping("/Maquinas/{codigocaja}")
	public void eliminarMaquinaR(@PathVariable(name = "codigocaja") int codigocaja) {
		maquinaRServiceImpl.eliminarMaquinaR(codigocaja);
	}

}