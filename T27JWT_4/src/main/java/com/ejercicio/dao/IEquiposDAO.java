package com.ejercicio.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ejercicio.dto.Equipos;

public interface IEquiposDAO extends JpaRepository<Equipos, Integer>{

}