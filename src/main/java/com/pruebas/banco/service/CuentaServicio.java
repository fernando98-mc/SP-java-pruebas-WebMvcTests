package com.pruebas.banco.service;

import java.math.BigDecimal;
import java.util.List;

import com.pruebas.banco.entity.Cuenta;

public interface CuentaServicio {

	public List<Cuenta> listarCuentas();

	public Cuenta buscarCuentaPorID(Long id);

	public Cuenta guardarCuenta(Cuenta cuenta);

	public int revisarTotalTransferencias(Long BancoID);

	public BigDecimal revisarSaldo(Long cuentaID);

	public void transferirDinero(Long numCuentaOrigen, Long numCuentaDestino, BigDecimal monto, Long bancoID);

}
