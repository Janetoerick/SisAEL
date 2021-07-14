package com.ufrn.cb.SisAEL.service;

import java.util.List;
import java.util.Optional;

import com.ufrn.cb.SisAEL.entity.Sala;

public interface SalaService {
	Sala salvar(Sala sala, Long idLab);
	Optional<Sala> atualizar(Sala sala);
	boolean deletar(Sala sala);
	List<Sala> obtertodos();
	Optional<Sala> obterPorId(Long id);
}
