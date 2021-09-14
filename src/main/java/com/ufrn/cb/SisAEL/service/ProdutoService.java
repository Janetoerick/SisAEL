package com.ufrn.cb.SisAEL.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufrn.cb.SisAEL.dados.FachadaDados;
import com.ufrn.cb.SisAEL.entity.Estoque;
import com.ufrn.cb.SisAEL.entity.Produto;

@Service
public class ProdutoService {

	@Autowired
	FachadaDados fachada;
	
	@Autowired
	ProdutoValidator validator;
	
	public Produto cadastrar(Produto produto) {
		
		boolean produtoOk = validator.validar(produto);
		produto.setDisponivel(true);
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
	
	public void remover(long id) {
		fachada.deletarProduto(id);
	}
}
