package com.ufrn.cb.SisAEL.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ufrn.cb.SisAEL.entity.Produto;
import com.ufrn.cb.SisAEL.entity.Reserva;
import com.ufrn.cb.SisAEL.entity.impl.HorarioHotel;
import com.ufrn.cb.SisAEL.entity.impl.Quarto;
import com.ufrn.cb.SisAEL.exception.DadosIncompletosException;
import com.ufrn.cb.SisAEL.exception.ReservaException;
import com.ufrn.cb.SisAEL.service.VerificadorDeReserva;

@Service
public class VerificadorDeReservaHotel extends VerificadorDeReserva {

	@Override
	protected boolean verificarDisponibilidade(Reserva reserva) {

		long id = reserva.getProdutos().get(0).getId();

		Optional<Produto> opt = fachada.obterProduto(id);
		if (opt.isEmpty()) {
			throw new DadosIncompletosException("Não foi encontrado o quarto");
		}

		Quarto quarto = (Quarto) opt.get();
		if (!quarto.isDisponivel()) {
			throw new ReservaException("Quarto indisponível");
		}

		List<Reserva> reservas = fachada.listarReservas();

		for (Reserva r : reservas) {
			HorarioHotel horario = (HorarioHotel) r.getHorario();
			for (int i = 0; i < reserva.getProdutos().size(); i++) {
				if (r.getProdutos().contains(reserva.getProdutos().get(i))) {
					HorarioHotel horario_t = (HorarioHotel) reserva.getHorario();
					if (!horario.getDataInicial().isAfter(horario_t.getDataFinal())
							&& !horario.getDataFinal().isBefore(horario_t.getDataFinal())
							|| !horario.getDataInicial().isAfter(horario_t.getDataInicial())
									&& !horario.getDataFinal().isBefore(horario_t.getDataInicial())
							|| !horario.getDataInicial().isBefore(horario_t.getDataInicial())
									&& !horario.getDataFinal().isAfter(horario_t.getDataFinal())) {
						throw new ReservaException(
								"Produto " + reserva.getProdutos().get(i).getId() + " indisponível no horario");

					}
				}
			}
		}
		return true;
	}

}
