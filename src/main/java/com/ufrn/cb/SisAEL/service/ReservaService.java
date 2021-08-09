package com.ufrn.cb.SisAEL.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufrn.cb.SisAEL.dados.FachadaDados;
import com.ufrn.cb.SisAEL.entity.Reserva;
import com.ufrn.cb.SisAEL.exception.ReservaException;

@Service
public class ReservaService {
	
	@Autowired
	FachadaDados fachada;
	
	public Reserva cadastrar(Reserva reserva) {
		
		Optional<Reserva> o = fachada.obterReserva(reserva.getLaboratorio()
				.getId(), reserva.getSala().getId(), reserva.getData(), reserva
				.getHorarioDaReserva().getId());
		
		if(!o.isEmpty()) {
			
			throw new ReservaException("A reserva não foi possível."
					+ " Tente em outro horário ou local");
		}
		Reserva dados = fachada.salvarReserva(reserva);
		return dados;
		
	}
	
	public List<Reserva> listar(){
		
		return fachada.listarReservas();
		
	}

}
