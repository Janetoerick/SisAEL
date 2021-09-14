package com.ufrn.cb.SisAEL.service;

import org.springframework.stereotype.Service;

import com.ufrn.cb.SisAEL.entity.Equipamento;
import com.ufrn.cb.SisAEL.entity.Laboratorio;
import com.ufrn.cb.SisAEL.entity.Produto;

@Service
public class ProdutoValidatorImpl extends ProdutoValidator{

	private ProdutoValidatorContext context;
	
	public boolean validar(Produto produto) {
		
		context = new ProdutoValidatorContext();
		if(produto instanceof Equipamento) {
			context.setStrategy(new EquipamentoValidatorStrategy());
		}
		else if(produto instanceof Laboratorio) {
			context.setStrategy(new LaboratorioValidatorStrategy());
		}
		else {
			context.setStrategy(new SalaValidatorStrategy());
		}
		
		return context.validar(produto);
		
	}
}
