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
	
	@Autowired
	VerificadorProdutos verificadorProdutos;
	
	@Autowired
	VerificadorDeReserva verificadorReserva;
	
	@Autowired
	CalculoValorReserva calculoValorReserva;
	
	public Reserva obterReserva(long id) {
		
		return fachada.obterReserva(id).get();
	}
	
	public Reserva cadastrar(Reserva reserva) {
		
		boolean produtosOk = verificadorProdutos
				.verificar(reserva.getProdutos());
		if(!produtosOk) {
			throw new ReservaException("Produto(s) da reserva inválido(s)");
		}
		
		boolean reservaOk = verificadorReserva.verificar(reserva);
		if(!reservaOk) {
			throw new ReservaException("Não foi possível fazer a reserva.");
		}
		float valorReserva= calculoValorReserva.calcular(reserva);
		reserva.setValor(valorReserva);
		Reserva dados = fachada.salvarReserva(reserva);
		return dados;
		
	}
	
	public List<Reserva> listar(){
		
		return fachada.listarReservas();
		
	}
	
	public void cancelarReserva(long id) {
		
		fachada.deletarReserva(id);;
	}

}
