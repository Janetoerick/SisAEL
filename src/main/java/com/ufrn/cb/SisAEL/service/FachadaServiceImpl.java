package com.ufrn.cb.SisAEL.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ufrn.cb.SisAEL.entity.Estoque;
import com.ufrn.cb.SisAEL.entity.Horario;
import com.ufrn.cb.SisAEL.entity.Produto;
import com.ufrn.cb.SisAEL.entity.Reserva;
import com.ufrn.cb.SisAEL.entity.Admin;
import com.ufrn.cb.SisAEL.entity.Cliente;


@Service
public class FachadaServiceImpl implements FachadaService{

	
	@Autowired
	EstoqueService estoqueService;
	
	@Autowired
	ProdutoService produtoService;
	
	@Autowired
	HorarioService horarioService;
	
	@Autowired
	ReservaService reservaService;
	
	@Autowired
	CalculoValorReserva calculoValorReserva;
	
	@Autowired
	ClienteService clienteService;
	
	@Autowired
	AdminService adminService;
	
	
	public Admin cadastrarTecnico(Admin tecnico) {
		
		return adminService.cadastrar(tecnico);
	}
	
	@Override
	public Estoque cadastrarEstoque(Estoque estoque) {
		return estoqueService.cadastrar(estoque);
	}
	
	@Override
	public Reserva cadastrarReserva(Reserva reserva) {
		
		
		return reservaService.cadastrar(reserva);
	}
	
	
	@Override
	public Cliente cadastrarCliente(Cliente cliente) {
		return clienteService.cadastrar(cliente);
	}

	@Override
	public List<Reserva> listarReservas() {
		
		return reservaService.listar();
	}

	@Override
	public List<Estoque> listarEstoques() {
		
		return estoqueService.listar();
	}
	
	@Override
	public Produto obterProduto(long id) {
		
		return produtoService.obter(id);
	}
	
	@Override
	public Produto cadastrarProduto(Produto item) {
		return produtoService.cadastrar(item);
	}

	@Override
	public List<Produto> listarProdutos(){
		
		return produtoService.listar();
	}
	
	@Override
	public Horario obterHorario(long id) {
		
		return horarioService.obter(id);
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
	public void deletarHorario(long id) {
		
		horarioService.deletarHorario(id);
		
	}

	@Override
	public Estoque atualizarEstoque(Estoque estoque) {
		
		return estoqueService.atualizar(estoque);
	}

	@Override
	public List<Produto> listarProdutos(long idEstoque){
		
		return produtoService.listar(idEstoque);
		
	}
	
	@Override
	public void deletarProduto(long idProduto) {
		
		produtoService.deletar(idProduto);
	}

	@Override
	public Cliente obterCliente(String nomeUsuario) {
		return clienteService.obter(nomeUsuario);
	}

	@Override
	public Admin obterAdmin(String nomeUsuario) {
		return adminService.obterPorNomeUsuario(nomeUsuario);
	}

	@Override
	public Reserva obterReserva(long id) {
		return reservaService.obterReserva(id);
	}


	@Override
	public void cancelarReserva(long id) {
		reservaService.cancelarReserva(id);
		
	}

	@Override
	public float calcularValorReserva(Reserva reserva) {
		return calculoValorReserva.calcular(reserva);
	}

	@Override
	public void atualizarCliente(Cliente cliente) {
		clienteService.atualizar(cliente);
		
	}

	@Override
	public void deletarCliente(long id) {
		clienteService.deletar(id);
		
	}

	@Override
	public List<Cliente> listarClientes() {
		return clienteService.listar();
	}

	@Override
	public Produto atualizarProduto(Produto produto) {
		return produtoService.atualizar(produto);
	}

	@Override
	public void deletarEstoque(long id) {
		estoqueService.deletar(id);
		
	}

	@Override
	public Admin cadastrarAdmin(Admin admin) {
		return adminService.cadastrar(admin);
	}

}
