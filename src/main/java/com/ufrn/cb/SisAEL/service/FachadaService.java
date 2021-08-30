package com.ufrn.cb.SisAEL.service;

import java.util.List;
import com.ufrn.cb.SisAEL.entity.Estoque;
import com.ufrn.cb.SisAEL.entity.Horario;
import com.ufrn.cb.SisAEL.entity.Produto;
import com.ufrn.cb.SisAEL.entity.Laboratorio;
import com.ufrn.cb.SisAEL.entity.Pesquisador;
import com.ufrn.cb.SisAEL.entity.Reserva;
import com.ufrn.cb.SisAEL.entity.Tecnico;

public interface FachadaService {
	
	public Tecnico cadastrarTecnico(Tecnico tecnico);
	
	public Estoque cadastrarEquipamento(Estoque equipamento);
	
	public Reserva cadastrarReserva(Reserva reserva);
	
	public Pesquisador cadastrarPesquisador(Pesquisador pesquisador);
	
	public List<Estoque> listarEquipamentos();
	
	public Produto cadastrarItemEquipamento(Produto item);
	
	public Laboratorio cadastrarLaboratorio(Laboratorio laboratorio);
	
	public List<Laboratorio> listarLaboratorios();
	
	public List<Produto> listarItensEquipamento();
	
	public List<Reserva> listarReservas();
	
	public Horario cadastrarHorario(Horario horario);
	
	public List<Horario> listarHorarios();
	
	public void deletarHorarioDaReserva(long id);
	
	public Estoque atualizarEquipamento(Estoque equipamento);
	
	public List<Produto> listarItensEquipamentos(long idTipoEquipamento);
	
	public Pesquisador obterPesquisadorPorNome(String nome);
	
	public Tecnico obterTecnicoPorNomeUsuario(String nomeUsuario);
	
	

}
