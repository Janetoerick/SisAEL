package com.ufrn.cb.SisAEL.service.Impl;

import org.springframework.stereotype.Service;

import com.ufrn.cb.SisAEL.entity.Produto;
import com.ufrn.cb.SisAEL.entity.Impl.Equipamento;
import com.ufrn.cb.SisAEL.entity.Impl.Laboratorio;
import com.ufrn.cb.SisAEL.entity.Impl.Sala;
import com.ufrn.cb.SisAEL.exception.DadosInvalidosException;
import com.ufrn.cb.SisAEL.service.ProdutoValidator;

@Service
public class ProdutoValidatorImpl extends ProdutoValidator{

	public boolean validar(Produto produto) {
		
		if(produto instanceof Equipamento) {
			Equipamento e = (Equipamento) produto;
			if(e.getTombamento() <= 0) {
				throw new DadosInvalidosException("Valor do campo tombamento invalido!");
			}
		} else if (produto instanceof Sala) {
			Sala s = (Sala) produto;
			if(s.getNome() == "") {
				throw new DadosInvalidosException("Valor do campo nome invalido!");
			}
		} else if (produto instanceof Laboratorio) {
			Laboratorio l = (Laboratorio) produto;
			if(l.getNome() == "" || l.getSalas() == null) {
				throw new DadosInvalidosException("Campo invalido!");
			}
		}
		
		return true;
	}
}
