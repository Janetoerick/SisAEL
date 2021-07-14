package com.ufrn.cb.SisAEL.service;

import java.util.List;
import java.util.Optional;

import com.ufrn.cb.SisAEL.entity.Laboratorio;

public interface LabService {
	Laboratorio salvar(Laboratorio lab);
	Optional<Laboratorio> atualizar(Laboratorio lab);
	List<Laboratorio> obterTodos();
	Laboratorio obterPorId(Long id);
	boolean deletar(Laboratorio lab);
}
