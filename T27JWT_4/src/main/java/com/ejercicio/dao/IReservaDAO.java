package com.ejercicio.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ejercicio.dto.Reserva;

public interface IReservaDAO extends JpaRepository<Reserva, Integer>{

}