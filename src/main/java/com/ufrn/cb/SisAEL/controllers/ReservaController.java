package com.ufrn.cb.SisAEL.controllers;

import java.util.ArrayList;
import java.util.List;
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

@RestController
@RequestMapping(value="/reservas")
public class ReservaController extends Controller{
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Reserva> cadastrar(@RequestParam Long idCliente, 
			@RequestParam String idHorario, @RequestParam String idEquipamento,
			String idLaboratorio, String idSala){
		
		Reserva reserva = new Reserva();
		HorarioLaboratorio horarioLab = (HorarioLaboratorio) fachada.obterHorario(Long.parseLong(idHorario));
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
	public ResponseEntity<Reserva> cancelar(long id){
		
		fachada.cancelarReserva(id);
		return ResponseEntity.status(HttpStatus.OK).body(null);
		
	}
	

}
