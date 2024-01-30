package com.pruebas.banco.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pruebas.banco.entity.Banco;
import com.pruebas.banco.entity.Cuenta;
import com.pruebas.banco.repository.BancoRepositorio;
import com.pruebas.banco.repository.CuentaRepositorio;

@Service
public class CuentaServicioIMPL implements CuentaServicio {

	@Autowired
	private CuentaRepositorio cuentaRepositorio;

	@Autowired
	private BancoRepositorio bancoRepositorio;

	@Override
	@Transactional(readOnly = true)
	public List<Cuenta> listAll() {
		return cuentaRepositorio.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Cuenta findByID(Long id) {
		return cuentaRepositorio.findById(id).orElseThrow();
	}

	@Override
	@Transactional
	public Cuenta saveAccount(Cuenta cuenta) {
		return cuentaRepositorio.save(cuenta);
	}

	@Override
	@Transactional(readOnly = true)
	public int revisarTotalTransferencias(Long BancoID) {
		Banco banco = bancoRepositorio.findById(BancoID).orElseThrow();
		return banco.getTotalTransferencias();
	}

	@Override
	@Transactional(readOnly = true)
	public BigDecimal revisarSaldo(Long cuentaID) {
		Cuenta cuenta = cuentaRepositorio.findById(cuentaID).orElseThrow();
		return cuenta.getSaldo();
	}

	@Override
	public void transferirDinero(Long numCuentaOrigen, Long numCuentaDestino, BigDecimal monto, Long bancoID) {
		Cuenta cuentaOrigen = cuentaRepositorio.findById(numCuentaOrigen).orElseThrow();
		cuentaOrigen.realizarDebito(monto);
		cuentaRepositorio.save(cuentaOrigen);

		Cuenta cuentaDestino = cuentaRepositorio.findById(numCuentaDestino).orElseThrow();
		cuentaDestino.realizarCredito(monto);
		cuentaRepositorio.save(cuentaDestino);

		Banco banco = bancoRepositorio.findById(bancoID).orElseThrow();
		int totalTransferencias = banco.getTotalTransferencias();
		banco.setTotalTransferencias(++totalTransferencias);
		bancoRepositorio.save(banco);

	}

}
