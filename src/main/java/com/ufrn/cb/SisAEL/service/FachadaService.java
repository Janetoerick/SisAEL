package com.ufrn.cb.SisAEL.service;

import java.util.List;
import com.ufrn.cb.SisAEL.entity.Estoque;
import com.ufrn.cb.SisAEL.entity.Horario;
import com.ufrn.cb.SisAEL.entity.Produto;
import com.ufrn.cb.SisAEL.entity.Reserva;
import com.ufrn.cb.SisAEL.entity.Admin;
import com.ufrn.cb.SisAEL.entity.Cliente;

public interface FachadaService {
	
	public Reserva obterReserva(long id);
	
	public Reserva cadastrarReserva(Reserva reserva);
	
	public List<Reserva> listarReservas();
	
	public void cancelarReserva(long id);
	
	public float calcularValorReserva(Reserva reserva);
	
	public Cliente obterCliente(String nomeUsuario);

	public Cliente cadastrarCliente(Cliente cliente);
	
	public void atualizarCliente(Cliente cliente);
	
	public void deletarCliente(long id);
	
	public List<Cliente> listarClientes();
	
	public Produto obterProduto(long id);
	
	public Produto cadastrarProduto(Produto produto);
	
	public Produto atualizarProduto(Produto produto);
	
	public List<Produto> listarProdutos();
	
	public List<Produto> listarProdutos(long idEstoque);
	
	public void deletarProduto(long idProduto);
	
	public Estoque cadastrarEstoque(Estoque estoque);
	
	public Estoque atualizarEstoque(Estoque estoque);
	
	public List<Estoque> listarEstoques();
	
	public void deletarEstoque(long id);
	
	public Admin obterAdmin(String nomeUsuario);
	
	public Admin cadastrarAdmin(Admin admin);
	
	public Horario obterHorario(long id);
	
	public Horario cadastrarHorario(Horario horario);
	
	public List<Horario> listarHorarios();
	
	public void deletarHorario(long id);
	
	
	
	
	
	
	
	

}
