package com.ufrn.cb.SisAEL.service;

import com.ufrn.cb.SisAEL.entity.Laboratorio;
import com.ufrn.cb.SisAEL.entity.Produto;
import com.ufrn.cb.SisAEL.exception.DadosIncompletosException;

public class LaboratorioValidatorStrategy implements ValidatorStrategy {

	@Override
	public boolean validar(Produto produto) {
		Laboratorio lab = (Laboratorio) produto;
		if(lab.getNome() == null 
				|| lab.getNome().length()==0) {
			throw new DadosIncompletosException("Erro ao cadastrar o laboratório");
		}
		return true;
	}

}
