package com.ejercicio.dao;



import org.springframework.data.jpa.repository.JpaRepository;

import com.ejercicio.dto.Asignado;

public interface IAsignadoDAO extends JpaRepository<Asignado, Integer> {


}