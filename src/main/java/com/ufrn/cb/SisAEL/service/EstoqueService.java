package com.ufrn.cb.SisAEL.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufrn.cb.SisAEL.dados.FachadaDados;
import com.ufrn.cb.SisAEL.entity.Estoque;

@Service
public class EstoqueService {
	
	@Autowired
	FachadaDados fachada;
	
	public Estoque cadastrar(Estoque estoque) {
		
		return fachada.salvarEstoque(estoque);
	}
	
	public Estoque atualizar(Estoque estoque) {
		
		fachada.atualizarEstoque(estoque);
		return estoque;
	}
	
	public List<Estoque> listar(){
		
		return fachada.listarEstoques();
	}
	
	public void deletar(long id) {
		
		fachada.deletarEstoque(id);
	}

}
