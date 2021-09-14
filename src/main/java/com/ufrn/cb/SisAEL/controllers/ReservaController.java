package com.ufrn.cb.SisAEL.controllers;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.ufrn.cb.SisAEL.entity.Mesa;
import com.ufrn.cb.SisAEL.entity.HorarioRestaurante;
import com.ufrn.cb.SisAEL.entity.ClienteRestaurante;
import com.ufrn.cb.SisAEL.entity.Produto;
import com.ufrn.cb.SisAEL.entity.Reserva;

@RestController
@RequestMapping(value="/reservas")
public class ReservaController extends Controller{
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Reserva> cadastrar(@RequestParam Long idCliente, 
			@RequestParam String idMesa, long idHorario){
		
		Reserva reserva = new Reserva();
		
		ArrayList<Produto> mesas = new ArrayList<Produto>();
		Mesa quarto = new Mesa();
		quarto.setId(Integer.parseInt(idMesa));
		mesas.add(quarto);
		
		HorarioRestaurante  horarioRestaurante = (HorarioRestaurante )fachada
				.obterHorario(idHorario);
		
		//LocalDate dtReserva = LocalDate.parse(data);
		//LocalTime horaReserva = LocalTime.parse(hora);

		
		reserva.setProdutos(mesas);
		ClienteRestaurante cliente = new ClienteRestaurante();
		cliente.setId(idCliente);
		reserva.setCliente(cliente);
		reserva.setHorario(horarioRestaurante);
		
		
		
		Reserva dados = fachada.cadastrarReserva(reserva);
		return ResponseEntity.status(HttpStatus.CREATED).body(dados);
	}
	
	@GetMapping
	public ResponseEntity<List<Reserva>> listar(){
		
		List<Reserva> reservas = fachada.listarReservas();
		
		return ResponseEntity.ok(reservas);
	}
	
	@DeleteMapping("/deletar/{id}")
	public ResponseEntity<Reserva> cancelar(@PathVariable long id){
		
		fachada.cancelarReserva(id);
		return ResponseEntity.status(HttpStatus.OK).body(null);
		
	}
	

}
