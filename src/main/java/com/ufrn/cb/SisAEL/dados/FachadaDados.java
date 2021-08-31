package com.ufrn.cb.SisAEL.dados;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ufrn.cb.SisAEL.entity.Cliente;
import com.ufrn.cb.SisAEL.entity.Estoque;
import com.ufrn.cb.SisAEL.entity.Horario;
import com.ufrn.cb.SisAEL.entity.Produto;
import com.ufrn.cb.SisAEL.entity.Laboratorio;
import com.ufrn.cb.SisAEL.entity.Pesquisador;
import com.ufrn.cb.SisAEL.entity.Reserva;
import com.ufrn.cb.SisAEL.entity.Sala;
import com.ufrn.cb.SisAEL.entity.Tecnico;

@Service
public interface FachadaDados {
	
	public Estoque obterEquipamentoPorId(long id);
	
	public  Optional<Reserva> obterReserva(long idLab, long idSala,LocalDate data,long idHorario);
	
	public Cliente salvarCliente(Cliente cliente);
	
	public Produto salvarItemEquipamento(Produto item);
	
	public Reserva salvarReserva(Reserva reserva);
	
	public List<Estoque> listarEquipamentos();
	
	public List<Produto> listarItensEquipamentos();
	
	public Produto salvarLaboratorio(Produto produto);
	
	public List<Produto> listarLaboratorios();
	
	public Horario salvarHorario(Horario horario);
	
	public List<Horario> listarHorarios();
	
	public List<Reserva> listarReservas();
	
	public void deletarHorarioDaReserva(long id);
	
	public Estoque atualizarEquipamento(Estoque equipamento);
	
	public void atualizarNomeEquipamento(long id, String nome);
	
	public void atualizarQuantidadeEquipamento(long id, int quantidade);
	
	public List<Produto> listarItens(long idTipoEquipamento);
	
	public Optional<Pesquisador> obterPesquisadorPorNome(String nomeUsuario);
	
	public Optional<Tecnico> obterTecnicoPorNome(String nomeUsuario);
	
	
	
	

}
