package com.ejercicio.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ejercicio.dto.Cajero;



public interface ICajeroDAO extends JpaRepository<Cajero, Integer> {

}