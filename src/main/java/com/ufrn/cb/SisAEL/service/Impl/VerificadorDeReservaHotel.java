package com.ufrn.cb.SisAEL.service.Impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ufrn.cb.SisAEL.entity.Produto;
import com.ufrn.cb.SisAEL.entity.Reserva;
import com.ufrn.cb.SisAEL.entity.impl.Quarto;
import com.ufrn.cb.SisAEL.exception.DadosIncompletosException;
import com.ufrn.cb.SisAEL.exception.ReservaException;
import com.ufrn.cb.SisAEL.service.VerificadorDeReserva;

@Service
public class VerificadorDeReservaHotel extends VerificadorDeReserva{

	@Override
	protected boolean verificarDisponibilidade(Reserva reserva) {
		
		long id = reserva.getProdutos().get(0).getId();
		
		Optional<Produto> opt = fachada.obterProduto(id);
		if(opt.isEmpty()) {
			throw new DadosIncompletosException("Não foi encontrado o quarto");
		}
		
		Quarto quarto =  (Quarto) opt.get();
		if(!quarto.isDisponivel()) {
			throw new ReservaException("Quarto indisponível");
		}

		return true;
	}

}
