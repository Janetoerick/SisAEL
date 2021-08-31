package com.ufrn.cb.SisAEL.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufrn.cb.SisAEL.dados.FachadaDados;
import com.ufrn.cb.SisAEL.entity.Reserva;
import com.ufrn.cb.SisAEL.exception.DadosInvalidosException;

@Service
public abstract class VerificadorDeReserva{
	
	@Autowired
	protected FachadaDados fachada;
	
	@Autowired
	VerificadorHorario verificadorHorario;
	
	public final boolean verificar(Reserva reserva) {
		
		if(reserva.getCliente()== null || reserva.getProdutos()==null ||
			reserva.getProdutos().size()<1) {
			throw new DadosInvalidosException("Dados da reserva inválido");
		}
		boolean horarioOK = verificarHorario(reserva);
		if(!horarioOK) {
			throw new DadosInvalidosException("Horário Inválido");
		}
		return verificarDisponibilidade(reserva);
		
		
	}
	
	private boolean verificarHorario(Reserva reserva) {
		
		return verificadorHorario.ehValido(reserva.getHorario());
	}
	
	protected abstract boolean verificarDisponibilidade(Reserva reserva);

}
