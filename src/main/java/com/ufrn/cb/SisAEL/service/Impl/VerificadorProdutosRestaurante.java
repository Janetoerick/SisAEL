package com.ufrn.cb.SisAEL.service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ufrn.cb.SisAEL.entity.Produto;
import com.ufrn.cb.SisAEL.exception.DadosInvalidosException;
import com.ufrn.cb.SisAEL.service.VerificadorProdutos;

@Service
public class VerificadorProdutosLab extends VerificadorProdutos {

	@Override
	public boolean verificar(List<Produto> produtos) {
		for (Produto p : produtos) {
			if(fachada.obterProduto(p.getId()).isEmpty()) {
				throw new DadosInvalidosException("Id de produto invalido!");
			}
		}
		return true;
	}

}
