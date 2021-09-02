package com.ufrn.cb.SisAEL.service;

import org.springframework.stereotype.Service;

import com.ufrn.cb.SisAEL.entity.Equipamento;
import com.ufrn.cb.SisAEL.entity.Laboratorio;
import com.ufrn.cb.SisAEL.entity.Produto;
import com.ufrn.cb.SisAEL.entity.Sala;

@Service
public class ProdutoValidatorImpl extends ProdutoValidator{

	public boolean validar(Produto produto) {
		
		if(produto instanceof Equipamento) {
			Equipamento e = (Equipamento) produto;
			return e.getTombamento() > 0;
		} else if (produto instanceof Sala) {
			Sala s = (Sala) produto;
			return s.getNome() != null;
		} else if (produto instanceof Laboratorio) {
			Laboratorio l = (Laboratorio) produto;
			return l.getNome() != null && l.getSalas() != null;
		}
		
		return false;
	}
}
