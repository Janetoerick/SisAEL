package com.ufrn.cb.SisAEL.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.ufrn.cb.SisAEL.entity.HorarioRestaurante;
import com.ufrn.cb.SisAEL.entity.Produto;
import com.ufrn.cb.SisAEL.entity.Reserva;
import com.ufrn.cb.SisAEL.exception.ReservaException;

@Service
public class VerificadorReservaImpl extends VerificadorReserva{

	@Override
	protected boolean verificarDisponibilidade(Reserva reserva) {
		
		List<Produto> produtos = reserva.getProdutos();

		for (Produto produto : produtos) {
			Produto p = fachada.obterProduto(produto.getId()).get();
			if(!p.isDisponivel()) {
				throw new ReservaException("Produto indisponível");
			}
		}
		List<Reserva> reservas = fachada.listarReservas();
		
		for (Reserva r : reservas) {
			HorarioRestaurante horario = (HorarioRestaurante) r.getHorario();
			if (horario.equals(reserva.getHorario())) {
				throw new ReservaException("A Reserva para esta "
						+ "data e horário está indisponível");
			}
		}
		return true;
	}

}
