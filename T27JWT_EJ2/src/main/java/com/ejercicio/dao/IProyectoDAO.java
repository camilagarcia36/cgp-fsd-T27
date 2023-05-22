package com.ejercicio.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ejercicio.dto.Proyecto;

public interface IProyectoDAO extends JpaRepository<Proyecto, Integer> {

}