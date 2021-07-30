package com.ufrn.cb.SisAEL.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ufrn.cb.SisAEL.entity.Equipamento;
import com.ufrn.cb.SisAEL.service.FachadaService;

@RestController
@RequestMapping("equipamentos")
public class EquipamentoController {
	
	@Autowired
	FachadaService fachada;
	
	@PostMapping("cadastrar")
	public ResponseEntity<Equipamento> cadastrar(@RequestBody Equipamento equipamento) {
		
		
		return ResponseEntity.ok(fachada.cadastrarEquipamento(equipamento));
	}
	
	@GetMapping("listar")
	public ResponseEntity<List<Equipamento>> listar(){
		
		return ResponseEntity.ok(fachada.listarEquipamentos());
	}
	
	@PutMapping("atualizar")
	public ResponseEntity<Equipamento> 
			atualizarEquipamento(@RequestBody Equipamento equipamento){
		
		return ResponseEntity.ok(fachada.atualizarEquipamento(equipamento));
		
	}

}
