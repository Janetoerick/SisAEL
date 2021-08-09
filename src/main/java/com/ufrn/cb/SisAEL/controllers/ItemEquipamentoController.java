package com.ufrn.cb.SisAEL.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ufrn.cb.SisAEL.entity.ItemEquipamento;
import com.ufrn.cb.SisAEL.service.FachadaService;
import java.util.List;

@RestController
@RequestMapping("itensequipamentos")
public class ItemEquipamentoController{
	
	@Autowired
	FachadaService fachada;
	
	@PostMapping("cadastrar")
	public ResponseEntity<ItemEquipamento> cadastrar(@RequestBody ItemEquipamento item){
		return ResponseEntity.ok(fachada.cadastrarItemEquipamento(item));
		
	}
	
	@GetMapping
	public ResponseEntity<List<ItemEquipamento>> listar(){
		
		return ResponseEntity.ok(fachada.listarItensEquipamento());
	}
	
	@GetMapping("{idTipoEquipamento}")
	public ResponseEntity<List<ItemEquipamento>> listar(@PathVariable("idTipoEquipamento") long idTipoEquipamento){
		
		List<ItemEquipamento> itens = fachada.listarItensEquipamentos(idTipoEquipamento);
		return ResponseEntity.ok(itens);
		
	}
	
	

}
