package com.ufrn.cb.SisAEL.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufrn.cb.SisAEL.entity.Equipamento;
import com.ufrn.cb.SisAEL.entity.Sala;
import com.ufrn.cb.SisAEL.exception.ErroDadoFornecidosInvalidos;
import com.ufrn.cb.SisAEL.exception.ErroNaoExisteRegistroNoBD;
import com.ufrn.cb.SisAEL.repository.EquipRepository;
import com.ufrn.cb.SisAEL.repository.SalaRepository;
import com.ufrn.cb.SisAEL.service.EquipService;

@Service
public class EquipServiceImpl implements EquipService {

	private EquipRepository repository;
	private SalaRepository repoSala;

	@Autowired
	public EquipServiceImpl(EquipRepository repository, SalaRepository repoSala) {
		super();
		this.repository = repository;
		this.repoSala = repoSala;
	}

	@Override
	public List<Equipamento> listarEquipSala(Long idSala) {
		return repository.findByidSala(idSala);
	}

	@Override
	public Equipamento salvar(Equipamento equip) {
		if (!verificaEquipamento(equip)) {
			return null;
		}
		return repository.save(equip);
	}

	@Override
	public Optional<Equipamento> atualizar(Equipamento equip) {
		verificaEquipamento(equip);
	
		if (!repository.findById(equip.getId()).isPresent()) {
			throw new ErroNaoExisteRegistroNoBD("Equipamento inexistente na base da dados");
		}
		
		return Optional.of(repository.save(equip));
	}

	@Override
	public boolean deletar(Equipamento equip) {
		Optional<Equipamento> eqp;
		eqp = repository.findById(equip.getId());
		if (eqp.isPresent()) {
			repository.delete(equip);
			return true;
		} else {
			throw new ErroNaoExisteRegistroNoBD("Equipamento inexistente na base da dados");
		}
	}

	@Override
	public List<Equipamento> listarPorNome(String nome) {
		return repository.findByNomeContains(nome);
	}

	@Override
	public List<Equipamento> listarPorIdSala(Long idSala) {
		return repository.findByidSala(idSala);
	}

	@Override
	public Optional<Equipamento> buscarPorId(Long idEquipamento) {
		return repository.findById(idEquipamento);
	}

	private boolean verificaEquipamento(Equipamento equip) {
		Optional<Sala> sala = repoSala.findById(equip.getIdSala());

		if (sala.isEmpty()) {
			throw new ErroNaoExisteRegistroNoBD("Sala fornecida para alocação do equipamento não existe");
		}

		if (equip.getNome().isEmpty() || equip.getNome().length() < 3) {
			throw new ErroDadoFornecidosInvalidos("nome do equipamento inválido");
		}

		if (equip.getTombamento() == null) {
			throw new ErroDadoFornecidosInvalidos("tombamento do equipamento inválido");
		}

		return true;
	}
}
