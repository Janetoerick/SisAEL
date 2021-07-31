package com.ufrn.cb.SisAEL.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ufrn.cb.SisAEL.entity.Pesquisador;
import com.ufrn.cb.SisAEL.service.FachadaService;

@RestController
@RequestMapping("pesquisadores")
public class PesquisadorController {
	
	@Autowired
	FachadaService fachada;
	
	@PostMapping("cadastrar")
	public ResponseEntity<Pesquisador> 
				cadastrar(@RequestBody Pesquisador pesquisador){
		
		Pesquisador p = fachada.cadastrarPesquisador(pesquisador);
		return ResponseEntity.ok(p);
		
	}

}
