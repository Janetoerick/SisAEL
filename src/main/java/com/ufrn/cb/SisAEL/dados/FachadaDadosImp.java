package com.ufrn.cb.SisAEL.dados;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ufrn.cb.SisAEL.entity.Estoque;
import com.ufrn.cb.SisAEL.entity.Horario;
import com.ufrn.cb.SisAEL.entity.Produto;
import com.ufrn.cb.SisAEL.entity.Laboratorio;
import com.ufrn.cb.SisAEL.entity.Pesquisador;
import com.ufrn.cb.SisAEL.entity.Reserva;
import com.ufrn.cb.SisAEL.entity.Sala;
import com.ufrn.cb.SisAEL.entity.Tecnico;
import com.ufrn.cb.SisAEL.repository.EquipRepository;
import com.ufrn.cb.SisAEL.repository.LabRepository;
import com.ufrn.cb.SisAEL.repository.PesquisadorRepository;
import com.ufrn.cb.SisAEL.repository.ReservaRepository;
import com.ufrn.cb.SisAEL.repository.SalaRepository;
import com.ufrn.cb.SisAEL.repository.TecnicoRepository;
import com.ufrn.cb.SisAEL.repository.HorariosDaReservaRepository;
import com.ufrn.cb.SisAEL.repository.ItemEquipamentoRepository;

@Service
public class FachadaDadosImp implements FachadaDados {

	@Autowired
	EquipRepository equipamentoRep;
	
	@Autowired
	LabRepository laboratorioRep;
	
	@Autowired
	SalaRepository salaRepository;
	
	@Autowired
	HorariosDaReservaRepository horarioRepository;
	
	@Autowired
	ItemEquipamentoRepository itemEquipRep;
	
	@Autowired
	ReservaRepository reservaRep;
	
	@Autowired
	PesquisadorRepository pesquisadorRep;
	
	@Autowired
	TecnicoRepository tecnicoRep;
	
	@Override
	public Estoque obterEquipamentoPorId(long id) {
		
		Optional<Estoque> o =  equipamentoRep.findById(id);
		return o.get();
	}
	
	@Override
	public  Optional<Reserva> obterReserva(long idLab, long idSala,
											LocalDate data, long idHorario) {
		
		return reservaRep.obter(idLab, idSala, data, idHorario);
		
	}
	
	
	@Override
	public Estoque salvarEquipamento(Estoque equipamento) {
		
		Estoque eq = equipamentoRep.save(equipamento);
		return eq;
	}
	
	@Override
	public List<Estoque> listarEquipamentos() {
		
		return equipamentoRep.findAll();
	}
	
	@Override
	public Produto salvarItemEquipamento(Produto item) {
		
		return itemEquipRep.save(item);
	}
	
	@Override
	public List<Produto> listarItensEquipamentos(){
		
		return itemEquipRep.findAll();
	}

	@Override
	public Laboratorio salvarLaboratorio(Laboratorio laboratorio) {
		
		Laboratorio lab = laboratorioRep.save(laboratorio);
		return lab;
	}
	
	@Override
	public Reserva salvarReserva(Reserva reserva) {
		
		Reserva r = reservaRep.save(reserva);
		return r;
	}
	
	@Override
	public List<Laboratorio> listarLaboratorios() {
		
		List<Laboratorio> labs = laboratorioRep.findAll();
		return labs;
 	}

	@Override
	public Sala salvarSala(Sala sala) {
		
		return salaRepository.save(sala);
	}

	@Override
	public Horario salvarHorario(Horario horario) {
		Horario repository = horarioRepository.save(horario);
		return repository;
	}
	
	

	@Override
	public Pesquisador salvarPesquisador(Pesquisador pesquisador) {
		return pesquisadorRep.save(pesquisador);
	}
	
	public Tecnico salvarTecnico(Tecnico tecnico) {
		
		return tecnicoRep.save(tecnico);
	}


	@Override
	public List<Horario> listarHorarios() {
		
		return horarioRepository.findAll();
	}

	@Override
	public void deletarHorarioDaReserva(long id) {
		
		horarioRepository.deleteById(id);
	}

	@Override
	public Estoque atualizarEquipamento(Estoque equipamento) {
		
		return equipamentoRep.save(equipamento);
	}


	@Override
	public void atualizarNomeEquipamento(long id, String nome) {
		
		equipamentoRep.atualizarNome(id, nome);
		
	}


	@Override
	public void atualizarQuantidadeEquipamento(long id, int quantidade) {
		equipamentoRep.atualizarQuantidade(id, quantidade);
		
	}


	@Override
	public List<Reserva> listarReservas() {
		
		return reservaRep.findAll();
	}


	@Override
	public List<Produto> listarItens(long idTipoEquipamento) {
		return itemEquipRep.listarPorTipoEquipamento(idTipoEquipamento);
	}


	@Override
	public Optional<Pesquisador> obterPesquisadorPorNome(String nomeUsuario) {
		return pesquisadorRep.obterPorNomeUsuario(nomeUsuario);
	}

	@Override
	public Optional<Tecnico> obterTecnicoPorNome(String nomeUsuario) {
		return tecnicoRep.obterPorNomeUsuario(nomeUsuario);
	}


	
	
	
	
	
	

	


}
