package com.ejercicio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejercicio.dao.IProductoDAO;
import com.ejercicio.dto.Producto;

@Service
public class ProductoServiceImpl implements IProductoService {

	@Autowired
	IProductoDAO iproductoDAO;

	@Override
	public List<Producto> listarProducto() {
		return iproductoDAO.findAll();
	}

	@Override
	public Producto guardarProducto(Producto producto) {
		return iproductoDAO.save(producto);
	}

	@Override
	public Producto productoById(int codigoproducto) {
		return iproductoDAO.findById(codigoproducto).get();
	}

	@Override
	public Producto actualizarProducto(Producto producto) {
		return iproductoDAO.save(producto);
	}

	@Override
	public void eliminarProducto(int codigoproducto) {
		iproductoDAO.deleteById(codigoproducto);

	}

}
