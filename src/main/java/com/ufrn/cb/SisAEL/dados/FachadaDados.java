package com.ufrn.cb.SisAEL.dados;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ufrn.cb.SisAEL.entity.Admin;
import com.ufrn.cb.SisAEL.entity.Cliente;
import com.ufrn.cb.SisAEL.entity.Estoque;
import com.ufrn.cb.SisAEL.entity.Horario;
import com.ufrn.cb.SisAEL.entity.Produto;
import com.ufrn.cb.SisAEL.entity.Reserva;

@Service
public interface FachadaDados {
	
	public Optional<Reserva> obterReserva(long id);
	
	public Reserva salvarReserva(Reserva reserva);
	
	public List<Reserva> listarReservas();
	
	public void atualizarReserva(Reserva reserva);
	
	public void deletarReserva(long id);
	
	public Optional<Produto> obterProduto(long id);
	
	public Produto salvarProduto(Produto produto);
	
	public void atualizarProduto(Produto produto);
	
	public List<Produto> listarProdutos();
	
	public List<Produto> listarProdutos(long idEstoque);
	
	public void deletarProduto(long id);
	
	public Optional<Estoque> obterEstoque(long id);
	
	public Estoque salvarEstoque(Estoque estoque);
	
	public void atualizarEstoque(Estoque estoque);
	
	public List<Estoque> listarEstoques();
	
	public void deletarEstoque(long id);
	
	public Optional<Cliente> obterCliente(String nomeUsuario);
	
	public Cliente salvarCliente(Cliente cliente);
	
	public void atualizarCliente(Cliente cliente);
	
	public void deletarCliente(long id);
	
	public List<Cliente> listarClientes();
	
	public Horario salvarHorario(Horario horario);
	
	public Horario obterHorario(long id);
	
	public List<Horario> listarHorarios();
	
	public void deletarHorario(long id);
	
	public Admin salvarAdmin(Admin admin);
	
	public Optional<Admin> obterAdmin(String nomeUsuario);
	

}
