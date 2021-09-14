package com.ufrn.cb.SisAEL.controllers.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ufrn.cb.SisAEL.controllers.ReservaController;
import com.ufrn.cb.SisAEL.entity.Cliente;
import com.ufrn.cb.SisAEL.entity.Horario;
import com.ufrn.cb.SisAEL.entity.Produto;
import com.ufrn.cb.SisAEL.entity.Reserva;
import com.ufrn.cb.SisAEL.entity.Impl.ClienteRestaurante;
import com.ufrn.cb.SisAEL.entity.Impl.HorarioRestaurante;
import com.ufrn.cb.SisAEL.entity.Impl.Mesa;

public class ReservaControllerImpl extends ReservaController{

	@PostMapping("/cadastrar")
	public ResponseEntity<Reserva> cadastrar(@RequestParam Long idCliente, 
			@RequestParam String idHorario, @RequestParam String idMesa){
		
		Reserva reserva = new Reserva();
		HorarioRestaurante horario = new HorarioRestaurante();
		horario.setId(Long.parseLong(idHorario));
		List<Produto> produtos = new ArrayList<Produto>();
		
		Mesa p = new Mesa();
		p.setId(Integer.parseInt(idMesa));
		produtos.add(p);
		
		reserva.setProdutos(produtos);
		ClienteRestaurante cliente = new ClienteRestaurante();
		cliente.setId(idCliente);
		reserva.setCliente(cliente);
		reserva.setHorario(horario);
		
		
		
		Reserva dados = fachada.cadastrarReserva(reserva);
		return ResponseEntity.status(HttpStatus.CREATED).body(dados);
	}
	
//	@PostMapping("/cadastrar")
//	public ResponseEntity<Reserva> cadastrar(@RequestBody HorarioRestaurante horario, 
//			@RequestBody ClienteRestaurante cliente, @RequestBody List<Mesa> mesa){
//		Reserva reserva = new Reserva();
//		reserva.setCliente(cliente);
//		reserva.setHorario(horario);
//		
//		List<Produto> produtos = new ArrayList<>();
//		for(Produto p: mesa) {
//			produtos.add(p);
//		}
//		reserva.setProdutos(produtos);
//		
//		Reserva dados = fachada.cadastrarReserva(reserva);
//		return ResponseEntity.status(HttpStatus.CREATED).body(dados);
//	}
}
