package com.ejercicio.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ejercicio.dto.Proveedor;

public interface IProveedorDAO extends JpaRepository<Proveedor, Integer> {

}