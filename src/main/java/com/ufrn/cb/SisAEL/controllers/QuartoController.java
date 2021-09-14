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

import com.ufrn.cb.SisAEL.entity.Quarto;
import com.ufrn.cb.SisAEL.entity.Produto;

@RestController
@RequestMapping("/quartos")
public class QuartoController extends Controller {
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Quarto> cadastrar(@RequestBody Quarto equipamento) {
		
		Quarto response = (Quarto) fachada
				.cadastrarProduto(equipamento);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	

	@GetMapping
	public ResponseEntity<List<Quarto>> listar(){
		
		List<Produto> produtos = fachada.listarProdutos();
		ArrayList<Quarto> equipamentos = new ArrayList<Quarto>();
		for(Produto produto:produtos) {
			if(produto instanceof Quarto) {
				equipamentos.add((Quarto) produto);
			}
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(equipamentos);
	}
	
	@PutMapping("/atualizar")
	public ResponseEntity<Quarto> atualizar(@RequestBody Quarto quarto){
		
		Quarto produto = (Quarto) fachada.atualizarProduto(quarto);
		
		return ResponseEntity.status(HttpStatus.OK).body(produto);
		
	}
	
	public ResponseEntity<Quarto> deletar(@PathVariable long id){
		
		fachada.deletarProduto(id);
		return ResponseEntity.status(HttpStatus.OK).body(null);
		
	}
	
	
	
	
	
	
	

}
