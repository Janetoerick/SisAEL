package com.ufrn.cb.SisAEL.controllers;

import java.time.LocalDate;
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
import com.ufrn.cb.SisAEL.entity.Quarto;
import com.ufrn.cb.SisAEL.entity.HorarioHotel;
import com.ufrn.cb.SisAEL.entity.ClienteHotel;
import com.ufrn.cb.SisAEL.entity.Produto;
import com.ufrn.cb.SisAEL.entity.Reserva;

@RestController
@RequestMapping(value="/reservas")
public class ReservaController extends Controller{
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Reserva> cadastrar(@RequestParam Long idCliente, 
			@RequestParam String idQuarto, String dataInicial, String dataFinal){
		
		Reserva reserva = new Reserva();
		
		ArrayList<Produto> quartos = new ArrayList<Produto>();
		Quarto quarto = new Quarto();
		quarto.setId(Integer.parseInt(idQuarto));
		quartos.add(quarto);
		
		LocalDate dtInicial = LocalDate.parse(dataInicial);
		LocalDate dtFinal = LocalDate.parse(dataFinal);
		
		HorarioHotel horario = new HorarioHotel();
		horario.setDataInicial(dtInicial);
		horario.setDataFinal(dtFinal);
		
		reserva.setProdutos(quartos);
		ClienteHotel pesquisador = new ClienteHotel();
		pesquisador.setId(idCliente);
		reserva.setCliente(pesquisador);
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
	public ResponseEntity<Reserva> cancelar(@PathVariable long id){
		
		fachada.cancelarReserva(id);
		return ResponseEntity.status(HttpStatus.OK).body(null);
		
	}
	

}
