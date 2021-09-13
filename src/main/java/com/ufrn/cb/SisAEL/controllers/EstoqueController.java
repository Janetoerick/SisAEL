package com.ufrn.cb.SisAEL.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ufrn.cb.SisAEL.entity.Estoque;
import com.ufrn.cb.SisAEL.service.FachadaService;

@RestController
@RequestMapping("/estoques")
public class EstoqueController {
	
	@Autowired
	FachadaService fachada;
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Estoque> cadastrar(@RequestBody Estoque estoque) {
		
		return ResponseEntity.ok(fachada.cadastrarEstoque(estoque));
	}
	
	@PutMapping("/atualizar")
	public ResponseEntity<Estoque> 
			atualizar(@RequestBody Estoque equipamento){
		
		return ResponseEntity.ok(fachada.atualizarEstoque(equipamento));
		
	}
	
	@GetMapping
	public ResponseEntity<List<Estoque>> listar(){
		System.out.println("here");
		List<Estoque> e = new ArrayList<>();
		e = fachada.listarEstoques();
		return ResponseEntity.ok(e);
	}
	
	@DeleteMapping("/deletar/{id}")
	public ResponseEntity<Estoque> deletar(@PathVariable(value="id") long id){
		
		fachada.deletarEstoque(id);
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}


}
