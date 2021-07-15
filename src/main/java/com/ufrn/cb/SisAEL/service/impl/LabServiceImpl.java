package com.ufrn.cb.SisAEL.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufrn.cb.SisAEL.entity.Laboratorio;
import com.ufrn.cb.SisAEL.exception.ErroDadoFornecidosInvalidos;
import com.ufrn.cb.SisAEL.exception.ErroNaoExisteRegistroNoBD;
import com.ufrn.cb.SisAEL.repository.LabRepository;
import com.ufrn.cb.SisAEL.service.LabService;

//@Service
public class LabServiceImpl implements LabService{
	
	private LabRepository repository;
		
	//@Autowired
	public LabServiceImpl(LabRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public Laboratorio salvar(Laboratorio lab) {
		
		if(lab.getNome().isEmpty() || lab.getNome().length()<3) {
			throw new ErroDadoFornecidosInvalidos(lab.getNome()+" - não é um nome válido.");
		}
		
		return repository.save(lab);
		
	}

	@Override
	public Optional<Laboratorio> atualizar(Laboratorio lab) {
		
		Optional<Laboratorio> laboratorio = repository.findById(lab.getId());
				
		if(laboratorio.isPresent()) {
			Laboratorio retorno = repository.save(lab);
			
			return Optional.of(retorno);
		}
		
		throw new ErroNaoExisteRegistroNoBD("Laboratório não existe na base da dados");
	}


	@Override
	public List<Laboratorio> obterTodos() {
		return repository.findAll();
	}


	@Override
	public boolean deletar(Laboratorio lab) {
		Optional<Laboratorio> laboratorio;
		laboratorio = repository.findById(lab.getId());
		if(laboratorio.isPresent()) {
			repository.delete(lab);
			return true;
		}else {
			throw new ErroNaoExisteRegistroNoBD("Laboratório não existe na base da dados");
		}
	}


	@Override
	public Laboratorio obterPorId(Long id) {
		Optional<Laboratorio> lab = repository.findById(id);
		Laboratorio lab_ = new Laboratorio();
		
		if(lab.isPresent()){
		
			lab.ifPresent((l) -> {
				    lab_.setId(l.getId());
				    lab_.setNome(l.getNome());
				
			});
			return lab_;
		}
		
		throw new ErroNaoExisteRegistroNoBD("Laboratório informado não presente na base de dados");
	}


}
