package com.ufrn.cb.SisAEL.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufrn.cb.SisAEL.dados.FachadaDados;
import com.ufrn.cb.SisAEL.entity.Reserva;
import com.ufrn.cb.SisAEL.exception.DadosInvalidosException;

@Service
public abstract class VerificadorReserva{
	
	@Autowired
	protected FachadaDados fachada;
	
	@Autowired
	VerificadorHorario verificadorHorario;
	
	protected final boolean verificar(Reserva reserva) {
		boolean horarioOK = verificarHorario(reserva);
		if(!horarioOK) {
			throw new DadosInvalidosException("Horário Inválido");
		}
		
		return verificarDisponibilidade(reserva);
	
	}
	
	private boolean verificarHorario(Reserva reserva) {
		
		boolean horarioValido = verificadorHorario.ehValido(reserva.getHorario());
		return horarioValido;
	}
	
	protected abstract boolean verificarDisponibilidade(Reserva reserva);

}
