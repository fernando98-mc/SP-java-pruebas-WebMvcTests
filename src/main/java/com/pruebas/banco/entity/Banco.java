package com.pruebas.banco.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "bancos")
public class Banco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long d;

	private String nombre;

	@Column(name = "total_transferencias")
	private int totalTransferencias;

	public Banco() {

	}

	public Banco(Long d, String nombre, int totalTransferencias) {
		super();
		this.d = d;
		this.nombre = nombre;
		this.totalTransferencias = totalTransferencias;
	}

	public Long getD() {
		return d;
	}

	public void setD(Long d) {
		this.d = d;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getTotalTransferencias() {
		return totalTransferencias;
	}

	public void setTotalTransferencias(int totalTransferencias) {
		this.totalTransferencias = totalTransferencias;
	}

}
