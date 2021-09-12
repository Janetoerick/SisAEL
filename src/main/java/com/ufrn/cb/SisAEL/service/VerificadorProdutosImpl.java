package com.ufrn.cb.SisAEL.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ufrn.cb.SisAEL.entity.Equipamento;
import com.ufrn.cb.SisAEL.entity.Laboratorio;
import com.ufrn.cb.SisAEL.entity.Produto;
import com.ufrn.cb.SisAEL.entity.Sala;
import com.ufrn.cb.SisAEL.exception.DadosIncompletosException;
import com.ufrn.cb.SisAEL.exception.DadosInvalidosException;
import com.ufrn.cb.SisAEL.exception.EntidadeNaoEncontradaException;

@Service
public class VerificadorProdutosImpl extends VerificadorProdutos{
	
	public boolean verificar(List<Produto> produtos) {
		
		int numEquipamentos = 0;
		int numLaboratorios = 0;
		int numSalas = 0;
		
		if(produtos == null || produtos.size() !=3) {
			throw new DadosIncompletosException("A reserva tem que ter um "
					+ "equipamento, um laboratorio e uma sala");
		}
		
		for (Produto produto : produtos) {
			Produto p = fachada.obterProduto(produto.getId()).get();
			if(p == null) {
				throw new EntidadeNaoEncontradaException("Item de reserva não encontrado");
			}
			if(p instanceof Equipamento) {
				numEquipamentos++;
			}
			else if(p instanceof Laboratorio) {
				numLaboratorios++;
			}else if(p instanceof Sala) {
				numSalas++;
			}
		}
		
		if(numEquipamentos !=1) {
			throw new DadosInvalidosException("Muitos equipamentos na reserva");
		}
		if(numLaboratorios != 1) {
			throw new DadosInvalidosException("Muitos laboratórios na reserva");
		}
		if(numSalas !=1) {
			throw new DadosInvalidosException("Muitas salas na reserva");
		}
		
		
		
		
		return true;
	}

}
