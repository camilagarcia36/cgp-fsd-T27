package com.ejercicio.dao;



import org.springframework.data.jpa.repository.JpaRepository;

import com.ejercicio.dto.Venta;

public interface IVentaDAO extends JpaRepository<Venta, Integer> {


}