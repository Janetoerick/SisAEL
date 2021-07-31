package com.ufrn.cb.SisAEL.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufrn.cb.SisAEL.dados.FachadaDados;
import com.ufrn.cb.SisAEL.entity.Reserva;

@Service
public class ReservaService {
	
	@Autowired
	FachadaDados fachada;
	
	public Reserva cadastrar(Reserva reserva) {
		
		Reserva dados = fachada.salvarReserva(reserva);
		return dados;
		
	}
	
	public List<Reserva> listar(){
		
		return fachada.listarReservas();
		
	}

}
