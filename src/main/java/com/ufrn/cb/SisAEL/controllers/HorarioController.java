package com.ufrn.cb.SisAEL.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ufrn.cb.SisAEL.entity.HorarioDaReserva;
import com.ufrn.cb.SisAEL.service.FachadaService;

@RestController
@RequestMapping("horarios")
public class HorarioController {
	
	@Autowired
	private FachadaService fachada;
	
	@PostMapping("cadastrar")
	public ResponseEntity<HorarioDaReserva> cadastrarHorario(@RequestBody HorarioDaReserva horario) {
		
		
		
		return ResponseEntity.ok(fachada.cadastrarHorario(horario));
		
	}

}
