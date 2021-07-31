package com.ufrn.cb.SisAEL.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ufrn.cb.SisAEL.entity.Reserva;
import com.ufrn.cb.SisAEL.service.FachadaService;

@RestController
@RequestMapping("reservas")
public class ReservaController {
	
	@Autowired
	FachadaService fachada;
	
	@PostMapping("cadastrar")
	public ResponseEntity<Reserva> cadastrar(@RequestBody Reserva reserva){
		
		Reserva dados = fachada.cadastrarReserva(reserva);
		return ResponseEntity.ok(dados);
	}
	
	@GetMapping
	public ResponseEntity<List<Reserva>> listar(){
		
		List<Reserva> reservas = fachada.listarReservas();
		
		return ResponseEntity.ok(reservas);
	}

}
