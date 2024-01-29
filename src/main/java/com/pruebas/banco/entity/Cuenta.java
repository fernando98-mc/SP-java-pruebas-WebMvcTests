package com.pruebas.banco.entity;

import java.math.BigDecimal;
import java.util.Objects;

import com.pruebas.banco.exceptions.SaldoInsuficienteException;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cuentas")
public class Cuenta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nombre;

	private BigDecimal saldo;

	public Cuenta() {

	}

	public Cuenta(Long id, String nombre, BigDecimal saldo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.saldo = saldo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	public void realizarDebito(BigDecimal monto) {
		BigDecimal nuevosaldo = this.saldo.subtract(monto);
		if (nuevosaldo.compareTo(BigDecimal.ZERO) < 0) {
			throw new SaldoInsuficienteException("Saldo insuficiente");
		}
		this.saldo = nuevosaldo;
	}

	public void realizarCredito(BigDecimal monto) {
		this.saldo = saldo.add(monto);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nombre, saldo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cuenta other = (Cuenta) obj;
		return Objects.equals(id, other.id) && Objects.equals(nombre, other.nombre)
				&& Objects.equals(saldo, other.saldo);
	}

}
