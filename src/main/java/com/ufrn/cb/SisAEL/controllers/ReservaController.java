package com.ufrn.cb.SisAEL.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.ufrn.cb.SisAEL.entity.Cliente;
import com.ufrn.cb.SisAEL.entity.Horario;
import com.ufrn.cb.SisAEL.entity.Produto;
import com.ufrn.cb.SisAEL.entity.Reserva;
import com.ufrn.cb.SisAEL.entity.impl.HorarioHotel;
import com.ufrn.cb.SisAEL.entity.impl.Quarto;
import com.ufrn.cb.SisAEL.service.FachadaService;

@RestController
@RequestMapping(value="/reservas")
public class ReservaController {
	
	@Autowired
	FachadaService fachada;
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Reserva> cadastrar(@RequestParam Long idCliente, @RequestParam String dataInicial, @RequestParam String dataFinal, @RequestParam String idQuarto){
		
		Reserva reserva = new Reserva();
		HorarioHotel horarioHotel = new HorarioHotel();
		horarioHotel.setDataInicial(LocalDate.parse(dataInicial));
		horarioHotel.setDataFinal(LocalDate.parse(dataFinal));
		List<Produto> quartos = new ArrayList<Produto>();
		Quarto quarto = new Quarto();
		quarto.setId(Integer.parseInt(idQuarto));
		quartos.add(quarto);
		reserva.setProdutos(quartos);
		Cliente cliente = new Cliente();
		cliente.setId(idCliente);
		reserva.setCliente(cliente);
		
		reserva.setHorario(horarioHotel);
		
		
		
		Reserva dados = fachada.cadastrarReserva(reserva);
		return ResponseEntity.status(HttpStatus.CREATED).body(dados);
	}
	
	@GetMapping
	public ResponseEntity<List<Reserva>> listar(){
		
		List<Reserva> reservas = fachada.listarReservas();
		
		return ResponseEntity.ok(reservas);
	}
	
	@DeleteMapping("/deletar/{id}")
	public ResponseEntity<Reserva> cancelarReserva(long id){
		
		fachada.cancelarReserva(id);
		return ResponseEntity.status(HttpStatus.OK).body(null);
		
	}
	
	@GetMapping(value="/calcular")
	public float consultarValor(@RequestBody Reserva reserva) {
		System.out.println(reserva.getHorario());

		//HorarioHotel h = (HorarioHotel) reserva.getHorario();
		//HorarioHotel h = (HorarioHotel) reserva.getHorario();
		//h.setDataInicial(data);
		//h.setDataFinal(data);
		//reserva.setHorario(h);
		//float valor = fachada.calcularValorReserva(reserva);
		//System.out.println("reserva: "+ reserva );
		return 1;
	}
	

}
