package com.ufrn.cb.SisAEL.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.ufrn.cb.SisAEL.entity.Produto;
import com.ufrn.cb.SisAEL.entity.Reserva;
import com.ufrn.cb.SisAEL.exception.DadosInvalidosException;
import com.ufrn.cb.SisAEL.exception.ReservaException;

@Service
public class VerificadorDeReservaImpl extends VerificadorDeReserva{

	@Override
	protected boolean verificarDisponibilidade(Reserva reserva) {
		
		List<Produto> produtos = reserva.getProdutos();
		if(produtos.size()!=3) {
			throw new DadosInvalidosException("A reserva tem que ter três itens");
		}
		
		for (Produto produto : produtos) {
			
			if(produto.isDisponivel()) {
				throw new ReservaException("Produto indisponível" + produto.getEstoque().getNome());
			}
		}
		
		List<Reserva> reservas = fachada.listarReservas();
		
		/*for (Reserva r : reservas) {
			HorarioLaboratorio horario = (HorarioLaboratorio) r.getHorario();
			if(horario.get)
		}*/
		
		return true;
	}

}
