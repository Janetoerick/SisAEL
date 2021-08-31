package com.ufrn.cb.SisAEL.dados;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufrn.cb.SisAEL.entity.Admin;
import com.ufrn.cb.SisAEL.entity.Cliente;
import com.ufrn.cb.SisAEL.entity.Estoque;
import com.ufrn.cb.SisAEL.entity.Horario;
import com.ufrn.cb.SisAEL.entity.Produto;
import com.ufrn.cb.SisAEL.entity.Reserva;
import com.ufrn.cb.SisAEL.repository.AdminRepository;
import com.ufrn.cb.SisAEL.repository.ClienteRepository;
import com.ufrn.cb.SisAEL.repository.EstoqueRepository;
import com.ufrn.cb.SisAEL.repository.HorarioRepository;
import com.ufrn.cb.SisAEL.repository.ProdutoRepository;
import com.ufrn.cb.SisAEL.repository.ReservaRepository;

@Service
public class FachadaDadosImp implements FachadaDados {

	@Autowired
	ClienteRepository clienteRep;
	
	@Autowired
	AdminRepository adminRep;
	
	@Autowired
	EstoqueRepository estoqueRep;
	
	@Autowired
	HorarioRepository horarioRep;
	
	@Autowired
	ProdutoRepository produtoRep;
	
	@Autowired
	ReservaRepository reservaRep;
	

	@Override
	public Optional<Reserva> obterReserva(long id) {
		return reservaRep.findById(id);
	}
	
	@Override
	public Reserva salvarReserva(Reserva reserva) {
		Reserva r = reservaRep.save(reserva);
		return r;
	}

	@Override
	public List<Reserva> listarReservas() {
		return reservaRep.findAll();
	}

	@Override
	public void atualizarReserva(Reserva reserva) {
		reservaRep.save(reserva);
	}
	
	public void deletarReserva(long id) {
		
		reservaRep.deleteById(id);
	}

	@Override
	public Optional<Produto> obterProduto(long id) {
		return produtoRep.findById(id);
	}

	@Override
	public Produto salvarProduto(Produto produto) {
		Produto p = produtoRep.save(produto);
		return p;
	}
	
	public void atualizarProduto(Produto produto) {
		
		produtoRep.save(produto);
	}

	@Override
	public List<Produto> listarProdutos() {
		return produtoRep.findAll();
	}

	@Override
	public List<Produto> listarProdutos(long idReserva) {
		return reservaRep.findByProduto(idReserva);
	}

	@Override
	public Optional<Estoque> obterEstoque(long id) {
		return estoqueRep.findById(id);
	}

	@Override
	public Estoque salvarEstoque(Estoque estoque) {
		return estoqueRep.save(estoque);
	}

	@Override
	public void atualizarEstoque(Estoque estoque) {
		estoqueRep.save(estoque);
		
	}

	@Override
	public List<Estoque> listarEstoques() {
		return estoqueRep.findAll();
	}

	@Override
	public void deletarEstoque(long id) {
		estoqueRep.deleteById(id);
	}

	@Override
	public Optional<Cliente> obterCliente(String nomeUsuario) {
		
		return clienteRep.obterPorNomeUsuario(nomeUsuario);
	}

	@Override
	public Cliente salvarCliente(Cliente cliente) {
		Cliente c = clienteRep.save(cliente);
		return c;
	}

	@Override
	public void atualizarCliente(Cliente cliente) {
		clienteRep.save(cliente);
	}

	@Override
	public void deletarCliente(long id) {
		clienteRep.deleteById(id);
	}

	@Override
	public List<Cliente> listarClientes() {
		
		return clienteRep.findAll();
	}

	@Override
	public Horario salvarHorario(Horario horario) {
		
		return horarioRep.save(horario);
	}

	@Override
	public List<Horario> listarHorarios() {
		
		return horarioRep.findAll();
	}

	@Override
	public void deletarHorario(long id) {
		// TODO Auto-generated method stub
		horarioRep.deleteById(id);
	}

	@Override
	public Admin salvarAdmin(Admin admin) {
		
		return adminRep.save(admin);
	}

	@Override
	public Optional<Admin> obterAdmin(String nomeUsuario) {
		
		return adminRep.obterPorNomeUsuario(nomeUsuario);
	}

	


	
	
	
	
	
	

	


}
