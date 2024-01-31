package com.pruebas.banco.entity;

import java.math.BigDecimal;

public class TransaccionDTO {

	private Long cuentaOrigenID;

	private Long cuentaDestinoID;

	private BigDecimal monto;

	private Long bancoID;

	public Long getCuentaOrigenID() {
		return cuentaOrigenID;
	}

	public void setCuentaOrigenID(Long cuentaOrigenID) {
		this.cuentaOrigenID = cuentaOrigenID;
	}

	public Long getCuentaDestinoID() {
		return cuentaDestinoID;
	}

	public void setCuentaDestinoID(Long cuentaDestinoID) {
		this.cuentaDestinoID = cuentaDestinoID;
	}

	public BigDecimal getMonto() {
		return monto;
	}

	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}

	public Long getBancoID() {
		return bancoID;
	}

	public void setBancoID(Long bandoID) {
		this.bancoID = bandoID;
	}

}
