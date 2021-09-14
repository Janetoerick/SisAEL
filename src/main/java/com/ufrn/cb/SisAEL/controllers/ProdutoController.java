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
import com.ufrn.cb.SisAEL.entity.Impl.Equipamento;
import com.ufrn.cb.SisAEL.entity.Impl.Laboratorio;
import com.ufrn.cb.SisAEL.entity.Impl.Sala;
import com.ufrn.cb.SisAEL.service.FachadaService;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public abstract class ProdutoController{
	
	@Autowired
	protected FachadaService fachada;
	
	@GetMapping
	public ResponseEntity<List<Produto>> listar(){
		
		return ResponseEntity.ok(fachada.listarProdutos());
	}
	
	@GetMapping("/{idEstoque}")
	public ResponseEntity<List<Produto>> listar(@PathVariable("idEstoque") long idEstoque){
		
		List<Produto> itens = fachada.listarProdutos(idEstoque);
		return ResponseEntity.ok(itens);
		
	}
	
	

}
