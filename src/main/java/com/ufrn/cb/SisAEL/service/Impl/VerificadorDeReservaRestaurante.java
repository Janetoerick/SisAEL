package com.ufrn.cb.SisAEL.service.Impl;

import java.util.List;
import org.springframework.stereotype.Service;

import com.ufrn.cb.SisAEL.entity.Produto;
import com.ufrn.cb.SisAEL.entity.Reserva;
import com.ufrn.cb.SisAEL.entity.Impl.HorarioRestaurante;
import com.ufrn.cb.SisAEL.exception.DadosInvalidosException;
import com.ufrn.cb.SisAEL.exception.ReservaException;
import com.ufrn.cb.SisAEL.service.VerificadorDeReserva;

@Service
public class VerificadorDeReservaRestaurante extends VerificadorDeReserva{

	@Override
	protected boolean verificarDisponibilidade(Reserva reserva) {
		
		List<Produto> produtos = reserva.getProdutos();
		
		for (Produto produto : produtos) {
			if(produto.isDisponivel()) {
				throw new ReservaException("Produto indisponível" + produto.getEstoque().getNome());
			}
		}
		
		List<Reserva> reservas = fachada.listarReservas();
		
		for (Reserva r : reservas) {
			HorarioRestaurante horario = (HorarioRestaurante) r.getHorario();
			for (int i = 0; i < reserva.getProdutos().size(); i++) {
				if(r.getProdutos().contains(reserva.getProdutos().get(i))) {
					HorarioRestaurante horario_t = (HorarioRestaurante) reserva.getHorario();
					if(horario.getData().isEqual(horario_t.getData())) {
						if(horario.getHora().equals(horario_t.getHora())) {
							throw new ReservaException("Mesa " + reserva.getProdutos().get(i).getId() + " indisponível no horario"); 
						}	
					}
				}
			}
		}
		
		return true;
	}

}
