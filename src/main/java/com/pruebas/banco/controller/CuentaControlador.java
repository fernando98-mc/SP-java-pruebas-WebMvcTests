package com.pruebas.banco.controller;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pruebas.banco.entity.Cuenta;
import com.pruebas.banco.entity.TransaccionDTO;
import com.pruebas.banco.service.CuentaServicio;

@RestController
@RequestMapping("/api/cuentas")
public class CuentaControlador {

	@Autowired
	private CuentaServicio cuentaServicio;

	@GetMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public Cuenta verDetalles(@PathVariable Long id) {
		return cuentaServicio.findByID(id);
	}

	public ResponseEntity<?> transferirDinero(@RequestBody TransaccionDTO transaccionDTO) {
		cuentaServicio.transferirDinero(transaccionDTO.getCuentaOrigenID(), transaccionDTO.getCuentaDestinoID(),
				transaccionDTO.getMonto(), transaccionDTO.getBancoID());

		Map<String, Object> respuesta = new HashMap<>();
		respuesta.put("date", LocalDate.now().toString());
		respuesta.put("status", "ok");
		respuesta.put("mensaje", "Transferencia realizada con exito");
		respuesta.put("TransaccionDTO", transaccionDTO);

		return ResponseEntity.ok(respuesta);
	}

}
