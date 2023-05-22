package com.ejercicio.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ejercicio.dto.Producto;

public interface IProductoDAO extends JpaRepository<Producto, Integer> {

}