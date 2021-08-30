package com.ufrn.cb.SisAEL.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ufrn.cb.SisAEL.entity.Estoque;
import com.ufrn.cb.SisAEL.entity.Horario;
import com.ufrn.cb.SisAEL.entity.Produto;
import com.ufrn.cb.SisAEL.entity.Laboratorio;
import com.ufrn.cb.SisAEL.entity.Pesquisador;
import com.ufrn.cb.SisAEL.entity.Reserva;
import com.ufrn.cb.SisAEL.entity.Tecnico;


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
	
	@Autowired
	TecnicoService tecnicoService;
	
	public Tecnico cadastrarTecnico(Tecnico tecnico) {
		
		return tecnicoService.cadastrar(tecnico);
	}
	
	@Override
	public Estoque cadastrarEquipamento(Estoque equipamento) {
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
	public List<Estoque> listarEquipamentos() {
		
		return equipService.listar();
	}
	
	@Override
	public Produto cadastrarItemEquipamento(Produto item) {
		// TODO Auto-generated method stub
		return equipService.cadastrarItemEquipamento(item);
	}

	@Override
	public Laboratorio cadastrarLaboratorio(Laboratorio laboratorio) {
		
		return labService.cadastrar(laboratorio);
	}
	
	@Override
	public List<Produto> listarItensEquipamento(){
		
		return equipService.listarItensEquipamento();
	}
	
	@Override
	public List<Laboratorio> listarLaboratorios() {
		
		return labService.listar();
	}

	@Override
	public Horario cadastrarHorario(Horario horario) {
		
		return horarioService.cadastrar(horario);
	}

	@Override
	public List<Horario> listarHorarios() {
		
		return horarioService.listarHorarios();
	}

	@Override
	public void deletarHorarioDaReserva(long id) {
		
		horarioService.deletarHorario(id);
		
	}

	@Override
	public Estoque atualizarEquipamento(Estoque equipamento) {
		
		return equipService.atualizarEquipamento(equipamento);
	}

	@Override
	public List<Produto> listarItensEquipamentos(long idTipoEquipamento){
		
		return equipService.listarItensEquipamentos(idTipoEquipamento);
		
	}

	@Override
	public Pesquisador obterPesquisadorPorNome(String nomeUsuario) {
		return pesquisadorService.obterPesquisadorPorNomeUsuario(nomeUsuario);
	}

	@Override
	public Tecnico obterTecnicoPorNomeUsuario(String nomeUsuario) {
		return tecnicoService.obterPorNomeUsuario(nomeUsuario);
	}

}
