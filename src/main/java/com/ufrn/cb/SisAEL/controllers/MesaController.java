package com.ufrn.cb.SisAEL.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ufrn.cb.SisAEL.entity.Mesa;
import com.ufrn.cb.SisAEL.entity.Produto;

@RestController
@RequestMapping("/mesas")
public class MesaController extends Controller {
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Mesa> cadastrar(@RequestBody Mesa mesa) {
		
		Mesa response = (Mesa) fachada
				.cadastrarProduto(mesa);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	

	@GetMapping
	public ResponseEntity<List<Produto>> listar(){
		
		List<Produto> produtos = fachada.listarProdutos();
		
		return ResponseEntity.status(HttpStatus.OK).body(produtos);
	}
	
	@PutMapping("/atualizar")
	public ResponseEntity<Mesa> atualizar(@RequestBody Mesa quarto){
		
		Mesa produto = (Mesa) fachada.atualizarProduto(quarto);
		
		return ResponseEntity.status(HttpStatus.OK).body(produto);
		
	}
	
	public ResponseEntity<Mesa> deletar(@PathVariable long id){
		
		fachada.deletarProduto(id);
		return ResponseEntity.status(HttpStatus.OK).body(null);
		
	}
	
	
	
	
	
	
	

}
