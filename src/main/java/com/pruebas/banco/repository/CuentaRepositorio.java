package com.pruebas.banco.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pruebas.banco.entity.Cuenta;

public interface CuentaRepositorio extends JpaRepository<Cuenta, Long> {

	@Query("select c from Cuenta c where c.persona=?1")
	public Optional<Cuenta> findByPersona(String persona);
	
}
