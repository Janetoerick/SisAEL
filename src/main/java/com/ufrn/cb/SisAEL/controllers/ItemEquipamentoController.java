package com.ufrn.cb.SisAEL.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ufrn.cb.SisAEL.entity.Produto;
import com.ufrn.cb.SisAEL.service.FachadaService;
import java.util.List;

@RestController
@RequestMapping("itensequipamentos")
public class ItemEquipamentoController{
	
	@Autowired
	FachadaService fachada;
	
	@PostMapping("cadastrar")
	public ResponseEntity<Produto> cadastrar(@RequestBody Produto item){
		return ResponseEntity.ok(fachada.cadastrarItemEquipamento(item));
		
	}
	
	@GetMapping
	public ResponseEntity<List<Produto>> listar(){
		
		return ResponseEntity.ok(fachada.listarItensEquipamento());
	}
	
	@GetMapping("{idTipoEquipamento}")
	public ResponseEntity<List<Produto>> listar(@PathVariable("idTipoEquipamento") long idTipoEquipamento){
		
		List<Produto> itens = fachada.listarItensEquipamentos(idTipoEquipamento);
		return ResponseEntity.ok(itens);
		
	}
	
	

}
