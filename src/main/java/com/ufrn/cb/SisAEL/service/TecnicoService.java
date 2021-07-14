package com.ufrn.cb.SisAEL.service;

import java.util.List;

import com.ufrn.cb.SisAEL.entity.Tecnico;

public interface TecnicoService {
	Tecnico autenticar(String login, String senha);
	boolean verficaExistenciaLogin(String login);
	Tecnico salvar(Tecnico tec);
	List<Tecnico> obterTodos();
}
