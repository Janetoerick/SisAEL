package com.ufrn.cb.SisAEL.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufrn.cb.SisAEL.dados.FachadaDados;
import com.ufrn.cb.SisAEL.entity.Equipamento;
import com.ufrn.cb.SisAEL.entity.ItemEquipamento;

@Service
public class EquipamentoService {
	
	@Autowired
	private FachadaDados fachada;
	
	public Equipamento cadastrarEquipamento(Equipamento equip) {
		//Uma futura lógica tem que ser colocada aqui
		
		return fachada.salvarEquipamento(equip);
	}
	
	public List<Equipamento> listar(){
		
		return fachada.listarEquipamentos();
	}
	
	public ItemEquipamento cadastrarItemEquipamento(ItemEquipamento item) {
		ItemEquipamento resp =  fachada.salvarItemEquipamento(item);
		Equipamento equipamento = fachada
				.obterEquipamentoPorId(resp.getEquipamento().getId());
		//Atualiza o número de quantidade de itens do equipamento
		int quantidade = equipamento.getQuantidade() + 1;
		fachada.
				atualizarQuantidadeEquipamento(equipamento.getId(), quantidade);
		equipamento.setQuantidade(equipamento.getQuantidade()+1);
		resp.setEquipamento(equipamento);

		return resp;
	}
	
	public List<ItemEquipamento> listarItensEquipamento(){
		
		return fachada.listarItensEquipamentos();
	}
	
	public Equipamento atualizarEquipamento(Equipamento equipamento) {
		
		long id = equipamento.getId();
		String nome = equipamento.getNome();
		fachada.atualizarNomeEquipamento(id,nome);
		return equipamento;
	}
	
	
	public List<ItemEquipamento> listarItensEquipamentos(long idTipoEquipamento){
		
		List<ItemEquipamento> lista = fachada.listarItens(idTipoEquipamento);

		return lista;
	}
}
