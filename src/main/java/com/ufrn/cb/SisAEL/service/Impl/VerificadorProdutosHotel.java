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
		for (Produto p : produtos) {
			Quarto q = (Quarto) p;
			if (q.getQtdPessoas() <= 0 || q.getQtdPessoas() >= 10 || q.getQtdCamas() <= 0 || q.getQtdCamas() >= 6) {
				throw new DadosInvalidosException("Dados de quantidade invalidos no produto " + q.getId());
			}
		}
		return true;
	}

}
