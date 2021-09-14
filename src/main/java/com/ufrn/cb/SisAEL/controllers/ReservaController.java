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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ufrn.cb.SisAEL.entity.Cliente;
import com.ufrn.cb.SisAEL.entity.Horario;
import com.ufrn.cb.SisAEL.entity.Produto;
import com.ufrn.cb.SisAEL.entity.Reserva;
import com.ufrn.cb.SisAEL.service.FachadaService;

@RestController
@RequestMapping("/reservas")
public class ReservaController {
	
	@Autowired
	protected FachadaService fachada;
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Reserva> cadastrar(@RequestParam(value="idCliente") String idCliente, 
			@RequestParam(value="idHorario") String idHorario, @RequestParam(value="idProduto") String[] idProduto){
		
		Cliente cliente = fachada.obterCliente(Long.parseLong(idCliente));
		
		Horario horario = fachada.obterHorario(Long.parseLong(idHorario));
		
		List<Produto> mesas = new ArrayList<>();
		for(String s: idProduto) {
			Produto produto = fachada.obterProduto(Long.parseLong(s));
			mesas.add(produto); 
		}
		
		
		Reserva reserva = new Reserva();
		reserva.setCliente(cliente);
		reserva.setHorario(horario);
		reserva.setProdutos(mesas);
		
		Reserva dados = fachada.cadastrarReserva(reserva);
		return ResponseEntity.status(HttpStatus.CREATED).body(dados);
	}
	
	@GetMapping
	public ResponseEntity<List<Reserva>> listar(){
		
		List<Reserva> reservas = fachada.listarReservas();
		
		return ResponseEntity.ok(reservas);
	}
	
	@DeleteMapping("/deletar/{id}")
	public ResponseEntity<Reserva> cancelarReserva(@PathVariable(name="id") long id){
		
		fachada.cancelarReserva(id);
		return ResponseEntity.status(HttpStatus.OK).body(null);
		
	}
	
	@GetMapping(value="/calcular")
	public float consultarValor(@RequestBody Reserva reserva) {

		return fachada.calcularValorReserva(reserva);
	}
	

}
