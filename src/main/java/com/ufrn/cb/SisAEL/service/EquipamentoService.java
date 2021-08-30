package com.ufrn.cb.SisAEL.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ufrn.cb.SisAEL.dados.FachadaDados;
import com.ufrn.cb.SisAEL.entity.Estoque;
import com.ufrn.cb.SisAEL.entity.Produto;

@Service
public class EquipamentoService {
	
	@Autowired
	private FachadaDados fachada;
	
	public Estoque cadastrarEquipamento(Estoque equip) {
		//Uma futura lógica tem que ser colocada aqui
		
		return fachada.salvarEquipamento(equip);
	}
	
	public List<Estoque> listar(){
		
		return fachada.listarEquipamentos();
	}
	
	public Produto cadastrarItemEquipamento(Produto item) {
		Produto resp =  fachada.salvarItemEquipamento(item);
		Estoque equipamento = fachada
				.obterEquipamentoPorId(resp.getEquipamento().getId());
		//Atualiza o número de quantidade de itens do equipamento
		int quantidade = equipamento.getQuantidade() + 1;
		fachada.
				atualizarQuantidadeEquipamento(equipamento.getId(), quantidade);
		equipamento.setQuantidade(equipamento.getQuantidade()+1);
		resp.setEquipamento(equipamento);

		return resp;
	}
	
	public List<Produto> listarItensEquipamento(){
		
		return fachada.listarItensEquipamentos();
	}
	
	public Estoque atualizarEquipamento(Estoque equipamento) {
		
		long id = equipamento.getId();
		String nome = equipamento.getNome();
		fachada.atualizarNomeEquipamento(id,nome);
		return equipamento;
	}
	
	
	public List<Produto> listarItensEquipamentos(long idTipoEquipamento){
		
		List<Produto> lista = fachada.listarItens(idTipoEquipamento);

		return lista;
	}
}
