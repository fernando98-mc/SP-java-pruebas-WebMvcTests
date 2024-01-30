package com.pruebas.banco;

import java.math.BigDecimal;
import java.util.Optional;

import com.pruebas.banco.entity.Banco;
import com.pruebas.banco.entity.Cuenta;

public class Datos {

	public static Optional<Cuenta> crearCuenta001() {
		return Optional.of(new Cuenta(1L, "daya", new BigDecimal("999")));
	}

	public static Optional<Cuenta> crearCuenta002() {
		return Optional.of(new Cuenta(2L, "tania", new BigDecimal("1000")));
	}

	public static Optional<Banco> crearBanco() {
		return Optional.of(new Banco(1L, "Bank01", 0));
	}

}
