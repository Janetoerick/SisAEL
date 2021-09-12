package com.ufrn.cb.SisAEL.service;

import com.ufrn.cb.SisAEL.entity.Produto;
import com.ufrn.cb.SisAEL.exception.DadosIncompletosException;

public class EquipamentoValidatorStrategy implements ValidatorStrategy{

	@Override
	public boolean validar(Produto produto) {
		
		if(produto.getEstoque() == null) {
			throw new DadosIncompletosException("Estoque do equipamento nulo");
		}
		
		return true;
	}

}
