package com.ufrn.cb.SisAEL.controllers.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ufrn.cb.SisAEL.controllers.ProdutoController;
import com.ufrn.cb.SisAEL.entity.Produto;
import com.ufrn.cb.SisAEL.entity.Impl.Equipamento;
import com.ufrn.cb.SisAEL.entity.Impl.Laboratorio;
import com.ufrn.cb.SisAEL.entity.Impl.Sala;

@RestController
public class ProdutoControllerImpl extends ProdutoController{

	@PostMapping("/cadastrar/Equipamento")
	public ResponseEntity<Produto> cadastrar(@RequestBody Equipamento item){
		return ResponseEntity.ok(fachada.cadastrarProduto(item));
		
	}
	
	@PostMapping("/cadastrar/Sala")
	public ResponseEntity<Produto> cadastrar(@RequestBody Sala item){
		return ResponseEntity.ok(fachada.cadastrarProduto(item));
		
	}
	
	@PostMapping("/cadastrar/Equipamento")
	public ResponseEntity<Produto> cadastrar(@RequestBody Laboratorio item){
		return ResponseEntity.ok(fachada.cadastrarProduto(item));
		
	}
	
}
