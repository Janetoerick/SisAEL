package com.ufrn.cb.SisAEL.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ufrn.cb.SisAEL.entity.Equipamento;
import com.ufrn.cb.SisAEL.entity.Laboratorio;
import com.ufrn.cb.SisAEL.entity.Produto;
import com.ufrn.cb.SisAEL.entity.Sala;
import com.ufrn.cb.SisAEL.service.FachadaService;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController{
	
	@Autowired
	FachadaService fachada;
	
	@PostMapping("equipamentos/cadastrar")
	public ResponseEntity<Produto> cadastrar(@RequestBody Equipamento item){
		return ResponseEntity.ok(fachada.cadastrarProduto(item));
		
	}
	
	@PostMapping("laboratorios/cadastrar")
	public ResponseEntity<Produto> cadastrar(@RequestBody Laboratorio item){
		return ResponseEntity.ok(fachada.cadastrarProduto(item));
		
	}
	
	@PostMapping("salas/cadastrar")
	public ResponseEntity<Produto> cadastrar(@RequestBody Sala item){
		return ResponseEntity.ok(fachada.cadastrarProduto(item));
		
	}
	
	@GetMapping
	public ResponseEntity<List<Produto>> listar(){
		
		return ResponseEntity.ok(fachada.listarProdutos());
	}
	
	@GetMapping("/{idEstoque}")
	public ResponseEntity<List<Produto>> listar(@PathVariable("idEstoque") long idTipoEquipamento){
		
		List<Produto> itens = fachada.listarProdutos(idTipoEquipamento);
		return ResponseEntity.ok(itens);
		
	}
	
	

}