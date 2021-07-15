package com.ufrn.cb.SisAEL.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufrn.cb.SisAEL.entity.Laboratorio;
import com.ufrn.cb.SisAEL.entity.Sala;
import com.ufrn.cb.SisAEL.exception.ErroDadoFornecidosInvalidos;
import com.ufrn.cb.SisAEL.exception.ErroNaoExisteRegistroNoBD;
import com.ufrn.cb.SisAEL.repository.EquipRepository;
import com.ufrn.cb.SisAEL.repository.LabRepository;
import com.ufrn.cb.SisAEL.repository.SalaRepository;
import com.ufrn.cb.SisAEL.service.SalaService;

@Service
public class SalaServiceImpl implements SalaService {
	
	SalaRepository repository;
	LabRepository labs;
	EquipRepository equips;
	
	@Autowired
	public SalaServiceImpl(SalaRepository repository, LabRepository labs, EquipRepository equips) {
		super();
		this.repository = repository;
		this.labs = labs;
		this.equips = equips;
	}

	@Override
	public Sala salvar(Sala sala, Long idLab) {	
	
		Optional<Laboratorio> lab = labs.findById(idLab);
		if(sala.getNome().isEmpty() || sala.getNome().length()<3){
			throw new ErroDadoFornecidosInvalidos("nome da sala inválido");
		}
		
		if(lab.isPresent()) {
			sala.setLab(idLab);
			return repository.save(sala);
		}	
		
		throw new ErroNaoExisteRegistroNoBD("laboratorio não existente, impossivel adicionar sala a esse lab.");
	}

	@Override
	public Optional<Sala> atualizar(Sala sala) {
		Optional<Sala> salaUp = repository.findById(sala.getId());
		Optional<Laboratorio> lab = labs.findById(sala.getLab());
		
		
		if(sala.getNome().isEmpty() || sala.getNome().length()<3){
			throw new ErroDadoFornecidosInvalidos("nome da sala inválido");
		}
				
		if(lab.isEmpty()){
			throw new ErroDadoFornecidosInvalidos("O laboratório fornecido nao existe");
		}
							
		if(salaUp.isPresent()) {
			Sala retorno = repository.save(sala);
			return Optional.of(retorno);
		}
		
		throw new ErroNaoExisteRegistroNoBD("Sala inexistente na base da dados");
	}

	@Override
	public boolean deletar(Sala sala) {
		Optional<Sala> salaOpt;
		salaOpt = repository.findById(sala.getId());
		if(salaOpt.isPresent()) {
			repository.delete(sala);
			return true;
		}else {
			throw new ErroNaoExisteRegistroNoBD("Sala inexistente na base da dados");
		}
	}

	@Override
	public List<Sala> obtertodos() {
		return repository.findAll();
	}

	@Override
	public Optional<Sala> obterPorId(Long id) {
		Optional<Sala> salaOpt;
		salaOpt = repository.findById(id);
		if(salaOpt.isPresent()) {
			return salaOpt;
		}else {
			throw new ErroNaoExisteRegistroNoBD("Sala inexistente na base da dados");
		}
	}

	@Override
	public List<Sala> obterPorLab(Long lab) {
		return repository.findByidLab(lab);
	}
	
}
