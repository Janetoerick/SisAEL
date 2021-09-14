package com.ufrn.cb.SisAEL.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufrn.cb.SisAEL.dados.FachadaDados;
import com.ufrn.cb.SisAEL.entity.Estoque;
import com.ufrn.cb.SisAEL.entity.Produto;
import com.ufrn.cb.SisAEL.exception.DadosInvalidosException;

@Service
public class ProdutoService {

	@Autowired
	FachadaDados fachada;
	
	@Autowired
	ProdutoValidator validator;
	
	
	public Produto obter(long id) {
		
		Produto produto = fachada.obterProduto(id).get();
		return produto;
	}
	
	public Produto cadastrar(Produto produto) {
		
		boolean produtoOk = validator.validar(produto);
		if(!produtoOk) {
			throw new DadosInvalidosException("Erro ao validar o produto");
		}
		produto.setDisponivel(true);
		if(produto.getEstoque()!=null) {
			Estoque estoque = fachada
					.obterEstoque(produto.getEstoque().getId()).get();
			estoque
			.setQuantidade(estoque.getQuantidade() + 1);
			produto.setEstoque(estoque);
		}
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
	
	public void deletar(long id) {
		Produto produto = fachada.obterProduto(id).get();
		if(produto.getEstoque()!=null) {
			Estoque estoque = fachada
					.obterEstoque(produto.getEstoque().getId()).get();
			estoque.setQuantidade(estoque.getQuantidade()-1);
			fachada.atualizarEstoque(estoque);
		}
		fachada.deletarProduto(id);
	}
}
