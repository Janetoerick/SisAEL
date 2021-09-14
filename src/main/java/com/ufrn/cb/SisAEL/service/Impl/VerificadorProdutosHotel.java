package com.ufrn.cb.SisAEL.service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ufrn.cb.SisAEL.entity.Produto;
import com.ufrn.cb.SisAEL.entity.impl.Quarto;
import com.ufrn.cb.SisAEL.exception.DadosInvalidosException;
import com.ufrn.cb.SisAEL.service.VerificadorProdutos;

@Service
public class VerificadorProdutosHotel extends VerificadorProdutos {

	@Override
	public boolean verificar(List<Produto> produtos) {
		
		List<Produto> quartos = fachada.listarProdutos();
		for (Produto p : produtos) {
			Quarto q = (Quarto) p;
			if (!quartos.contains(q)) {
				throw new DadosInvalidosException("Produto " + q.getId() + " nao encontrado!!");
			}
		}
		return true;
	}

}
