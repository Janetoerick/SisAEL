package com.ufrn.cb.SisAEL.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping("/{nomeUsuario}")
	public ResponseEntity<Pesquisador> obterPorNomeUsuario(@PathVariable(value="nomeUsuario") String nome){
		
		return ResponseEntity.ok(fachada.obterPesquisadorPorNome(nome));
	}

}
