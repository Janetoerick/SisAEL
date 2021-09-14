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
import com.ufrn.cb.SisAEL.entity.Impl.ClienteRestaurante;
import com.ufrn.cb.SisAEL.entity.Impl.HorarioRestaurante;
import com.ufrn.cb.SisAEL.entity.Impl.Mesa;
import com.ufrn.cb.SisAEL.service.FachadaService;

@RestController
@RequestMapping(value="/reservas")
public class ReservaController {
	
	@Autowired
	protected FachadaService fachada;
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Reserva> cadastrar(@RequestParam Long idCliente, 
			@RequestParam String idHorario, @RequestParam String idMesa){
		
		Reserva reserva = new Reserva();
		Horario horario = new Horario();
		horario.setId(Long.parseLong(idHorario));
		List<Produto> produtos = new ArrayList<Produto>();
		
		Produto p = new Produto();
		p.setId(Integer.parseInt(idMesa));
		produtos.add(p);
		
		reserva.setProdutos(produtos);
		Cliente cliente = new Cliente();
		cliente.setId(idCliente);
		reserva.setCliente(cliente);
		reserva.setHorario(horario);
		
		
		
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
