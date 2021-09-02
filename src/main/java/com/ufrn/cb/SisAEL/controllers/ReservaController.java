package com.ufrn.cb.SisAEL.controllers;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ufrn.cb.SisAEL.entity.Equipamento;
import com.ufrn.cb.SisAEL.entity.HorarioLaboratorio;
import com.ufrn.cb.SisAEL.entity.Laboratorio;
import com.ufrn.cb.SisAEL.entity.Pesquisador;
import com.ufrn.cb.SisAEL.entity.Produto;
import com.ufrn.cb.SisAEL.entity.Reserva;
import com.ufrn.cb.SisAEL.entity.Sala;
import com.ufrn.cb.SisAEL.service.FachadaService;

@RestController
@RequestMapping(value="/reservas")
public class ReservaController {
	
	@Autowired
	FachadaService fachada;
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Reserva> cadastrar(@RequestParam Long idCliente, 
			@RequestParam String data, @RequestParam String horaInicial, 
			String horaFinal, @RequestParam String idEquipamento,
			String idLaboratorio, String idSala){
		
		Reserva reserva = new Reserva();
		HorarioLaboratorio horarioLab = new HorarioLaboratorio();
		horarioLab.setHoraInicial(LocalTime.parse(horaInicial));
		horarioLab.setHoraFinal(LocalTime.parse(horaFinal));
		List<Produto> produtos = new ArrayList<Produto>();
		
		Equipamento equipamento = new Equipamento();
		equipamento.setId(Integer.parseInt(idEquipamento));
		produtos.add(equipamento);
		
		Laboratorio laboratorio = new Laboratorio();
		laboratorio.setId(Long.parseLong(idLaboratorio));
		produtos.add(laboratorio);
		
		Sala sala = new Sala();
		sala.setId(Long.parseLong(idSala));
		produtos.add(sala);
		
		reserva.setProdutos(produtos);
		Pesquisador pesquisador = new Pesquisador();
		pesquisador.setId(idCliente);
		reserva.setCliente(pesquisador);
		reserva.setHorario(horarioLab);
		
		
		
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
