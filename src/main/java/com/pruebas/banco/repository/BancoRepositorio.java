package com.pruebas.banco.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pruebas.banco.entity.Banco;

public interface BancoRepositorio extends JpaRepository<Banco, Long> {

	
	
}
