package com.ufrn.cb.SisAEL.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ufrn.cb.SisAEL.entity.Sala;
import com.ufrn.cb.SisAEL.service.FachadaService;

@RestController
public class SalaController {
	
	@Autowired
	FachadaService fachada;
	
	public ResponseEntity<Sala> cadastrar(@RequestBody Sala sala) {
		
		
		return ResponseEntity.ok(null);
		
	}

}
