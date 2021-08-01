package com.ufrn.cb.SisAEL.dados;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ufrn.cb.SisAEL.entity.Equipamento;
import com.ufrn.cb.SisAEL.entity.HorarioDaReserva;
import com.ufrn.cb.SisAEL.entity.ItemEquipamento;
import com.ufrn.cb.SisAEL.entity.Laboratorio;
import com.ufrn.cb.SisAEL.entity.Pesquisador;
import com.ufrn.cb.SisAEL.entity.Reserva;
import com.ufrn.cb.SisAEL.entity.Sala;
import com.ufrn.cb.SisAEL.repository.EquipRepository;
import com.ufrn.cb.SisAEL.repository.LabRepository;
import com.ufrn.cb.SisAEL.repository.PesquisadorRepository;
import com.ufrn.cb.SisAEL.repository.ReservaRepository;
import com.ufrn.cb.SisAEL.repository.SalaRepository;
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
	
	@Override
	public Equipamento obterEquipamentoPorId(long id) {
		
		Optional<Equipamento> o =  equipamentoRep.findById(id);
		return o.get();
	}
	
	
	@Override
	public Equipamento salvarEquipamento(Equipamento equipamento) {
		
		Equipamento eq = equipamentoRep.save(equipamento);
		return eq;
	}
	
	@Override
	public List<Equipamento> listarEquipamentos() {
		
		return equipamentoRep.findAll();
	}
	
	@Override
	public ItemEquipamento salvarItemEquipamento(ItemEquipamento item) {
		
		return itemEquipRep.save(item);
	}
	
	@Override
	public List<ItemEquipamento> listarItensEquipamentos(){
		
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
	public HorarioDaReserva salvarHorario(HorarioDaReserva horario) {
		HorarioDaReserva repository = horarioRepository.save(horario);
		return repository;
	}
	
	

	@Override
	public Pesquisador salvarPesquisador(Pesquisador pesquisador) {
		// TODO Auto-generated method stub
		return pesquisadorRep.save(pesquisador);
	}


	@Override
	public List<HorarioDaReserva> listarHorarios() {
		
		return horarioRepository.findAll();
	}

	@Override
	public void deletarHorarioDaReserva(long id) {
		
		horarioRepository.deleteById(id);
	}

	@Override
	public Equipamento atualizarEquipamento(Equipamento equipamento) {
		
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
	public List<ItemEquipamento> listarItens(long idTipoEquipamento) {
		return itemEquipRep.listarPorTipoEquipamento(idTipoEquipamento);
	}


	
	
	
	
	

	


}
