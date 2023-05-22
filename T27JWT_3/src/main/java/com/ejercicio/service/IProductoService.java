package com.ejercicio.service;

import java.util.List;

import com.ejercicio.dto.Producto;


public interface IProductoService {

	public List<Producto> listarProducto(); 

	public Producto guardarProducto(Producto producto); 

	public Producto productoById(int codigoproducto);

	public Producto actualizarProducto(Producto producto); 

	public void eliminarProducto(int codigoproducto);
}
