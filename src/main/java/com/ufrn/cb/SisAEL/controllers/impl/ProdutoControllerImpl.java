package com.ufrn.cb.SisAEL.controllers.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ufrn.cb.SisAEL.controllers.ProdutoController;
import com.ufrn.cb.SisAEL.entity.Produto;
import com.ufrn.cb.SisAEL.entity.Impl.Mesa;

@RestController
public class ProdutoControllerImpl extends ProdutoController{

	@PostMapping("/cadastrar")
	public ResponseEntity<Produto> cadastrarEquipamento(@RequestBody Mesa item){
		return ResponseEntity.ok(fachada.cadastrarProduto(item));
		
	}
	
}
