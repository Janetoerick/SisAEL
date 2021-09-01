package com.ufrn.cb.SisAEL.service;

import org.springframework.stereotype.Service;

import com.ufrn.cb.SisAEL.entity.Reserva;

@Service
public class VerificadorDeReservaImpl extends VerificadorDeReserva{

	@Override
	protected boolean verificarDisponibilidade(Reserva reserva) {
		// TODO Auto-generated method stub
		return true;
	}

}
