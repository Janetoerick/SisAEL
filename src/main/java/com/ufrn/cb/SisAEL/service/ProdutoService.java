package com.ufrn.cb.SisAEL.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufrn.cb.SisAEL.dados.FachadaDados;
import com.ufrn.cb.SisAEL.entity.Produto;

@Service
public class ProdutoService {

	@Autowired
	FachadaDados fachada;
	
	public Produto cadastrar(Produto produto) {
		return fachada.salvarProduto(produto);
	}
	
	public Produto atualizar(Produto produto) {
		fachada.atualizarProduto(produto);
		return produto;
	}
	
	public List<Produto> listar(){
		
		return fachada.listarProdutos();
	}
	
	public List<Produto> listar(long idEstoque){
		
		return fachada.listarProdutos(idEstoque);
	}
}
