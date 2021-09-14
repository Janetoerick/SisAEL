package com.ufrn.cb.SisAEL.service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ufrn.cb.SisAEL.entity.Produto;
import com.ufrn.cb.SisAEL.exception.DadosInvalidosException;
import com.ufrn.cb.SisAEL.service.VerificadorProdutos;

@Service
public class VerificadorProdutosRestaurante extends VerificadorProdutos {

	@Override
	public boolean verificar(List<Produto> produtos) {
		for (Produto p : produtos) {
			if(fachada.obterProduto(p.getId()).isEmpty()) {
				throw new DadosInvalidosException("Id de Mesa invalido!");
			}
		}
		return true;
	}

}
