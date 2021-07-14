package com.ufrn.cb.SisAEL.service;

import java.util.List;
import java.util.Optional;

import com.ufrn.cb.SisAEL.entity.Equipamento;

public interface EquipService {
	List<Equipamento> listarEquipSala(Long idSala);
	Equipamento salvar(Equipamento equip);
	Optional<Equipamento> atualizar(Equipamento equip);
	boolean deletar(Equipamento equip);
	List<Equipamento> listarPorNome(String nome);
	List<Equipamento> listarPorIdSala(Long idSala);
	Optional<Equipamento> buscarPorId(Long idEquipamento);

}
