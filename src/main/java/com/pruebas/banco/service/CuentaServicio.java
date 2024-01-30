package com.pruebas.banco.service;

import java.math.BigDecimal;
import java.util.List;

import com.pruebas.banco.entity.Cuenta;

public interface CuentaServicio {

	public List<Cuenta> listAll();

	public Cuenta findByID(Long id);

	public Cuenta saveAccount(Cuenta cuenta);

	public int revisarTotalTransferencias(Long BancoID);

	public BigDecimal revisarSaldo(Long cuentaID);

	public void transferirDinero(Long numCuentaOrigen, Long numCuentaDestino, BigDecimal monto, Long bancoID);

}
