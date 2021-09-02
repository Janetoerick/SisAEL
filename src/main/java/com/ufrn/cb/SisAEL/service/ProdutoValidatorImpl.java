package com.ufrn.cb.SisAEL.service;

import org.springframework.stereotype.Service;

import com.ufrn.cb.SisAEL.entity.Laboratorio;
import com.ufrn.cb.SisAEL.entity.Produto;

@Service
public class LaboratorioValidator extends ProdutoValidator{

	@Override
	public boolean validar(Produto produto) {
		Laboratorio lab = (Laboratorio) produto;
		return lab.getNome() != null && lab.getEstoque() != null;
	}

}
