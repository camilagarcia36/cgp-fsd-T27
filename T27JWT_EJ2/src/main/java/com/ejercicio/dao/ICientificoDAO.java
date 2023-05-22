package com.ejercicio.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ejercicio.dto.Cientifico;

public interface ICientificoDAO extends JpaRepository<Cientifico, Integer> {

}