package com.ejercicio.dao;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;

import com.ejercicio.dto.User;



public interface UserDAO extends JpaRepository<User, Long> {
	Optional<User> findByUsername(String username);

	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);
}
