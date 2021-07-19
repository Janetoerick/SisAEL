package com.ufrn.cb.SisAEL.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ufrn.cb.SisAEL.entity.Laboratorio;
import com.ufrn.cb.SisAEL.service.FachadaService;

@RestController
@RequestMapping("laboratorios")
public class LaboratorioController {
	
	@Autowired
	FachadaService fachada;
	
	@PostMapping("cadastrar")
	public ResponseEntity<Laboratorio> cadastrar(@RequestBody Laboratorio lab){
		
		System.out.println("Cadastrado" + lab.getNome());
		
		return ResponseEntity.ok(fachada.cadastrarLaboratorio(lab));
		
		
		
	}
	
	

}
