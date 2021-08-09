package com.ufrn.cb.SisAEL.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ufrn.cb.SisAEL.entity.Equipamento;
import com.ufrn.cb.SisAEL.entity.HorarioDaReserva;
import com.ufrn.cb.SisAEL.entity.ItemEquipamento;
import com.ufrn.cb.SisAEL.entity.Laboratorio;
import com.ufrn.cb.SisAEL.entity.Pesquisador;
import com.ufrn.cb.SisAEL.entity.Reserva;


@Service
public class FachadaServiceImpl implements FachadaService{

	@Autowired
	EquipamentoService equipService;
	
	@Autowired
	LaboratorioService labService;
	
	@Autowired
	HorariosService horarioService;
	
	@Autowired
	ReservaService reservaService;
	
	@Autowired
	PesquisadorService pesquisadorService;
	
	@Override
	public Equipamento cadastrarEquipamento(Equipamento equipamento) {
		return equipService.cadastrarEquipamento(equipamento);
	}
	
	@Override
	public Reserva cadastrarReserva(Reserva reserva) {
		
		
		return reservaService.cadastrar(reserva);
	}
	
	
	
	
	@Override
	public Pesquisador cadastrarPesquisador(Pesquisador pesquisador) {
		return pesquisadorService.cadastrar(pesquisador);
	}

	@Override
	public List<Reserva> listarReservas() {
		
		return reservaService.listar();
	}

	@Override
	public List<Equipamento> listarEquipamentos() {
		
		return equipService.listar();
	}
	
	@Override
	public ItemEquipamento cadastrarItemEquipamento(ItemEquipamento item) {
		// TODO Auto-generated method stub
		return equipService.cadastrarItemEquipamento(item);
	}

	@Override
	public Laboratorio cadastrarLaboratorio(Laboratorio laboratorio) {
		
		return labService.cadastrar(laboratorio);
	}
	
	@Override
	public List<ItemEquipamento> listarItensEquipamento(){
		
		return equipService.listarItensEquipamento();
	}
	
	@Override
	public List<Laboratorio> listarLaboratorios() {
		
		return labService.listar();
	}

	@Override
	public HorarioDaReserva cadastrarHorario(HorarioDaReserva horario) {
		
		return horarioService.cadastrar(horario);
	}

	@Override
	public List<HorarioDaReserva> listarHorarios() {
		
		return horarioService.listarHorarios();
	}

	@Override
	public void deletarHorarioDaReserva(long id) {
		
		horarioService.deletarHorario(id);
		
	}

	@Override
	public Equipamento atualizarEquipamento(Equipamento equipamento) {
		
		return equipService.atualizarEquipamento(equipamento);
	}

	@Override
	public List<ItemEquipamento> listarItensEquipamentos(long idTipoEquipamento) {
		
		return equipService.listarItensEquipamentos(idTipoEquipamento);
		
	}

	@Override
	public Pesquisador obterPesquisadorPorNome(String nomeUsuario) {
		return pesquisadorService.obterPesquisadorPorNomeUsuario(nomeUsuario);
	}

	
	
	


	
	

	

	

	
	

}
