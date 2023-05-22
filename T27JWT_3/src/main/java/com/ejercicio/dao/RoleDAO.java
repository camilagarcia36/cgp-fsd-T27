package com.ejercicio.dao;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;

import com.ejercicio.dto.ERole;
import com.ejercicio.dto.Role;



public interface RoleDAO extends JpaRepository<Role, Long> {
	Optional<Role> findByName(ERole name);
}
