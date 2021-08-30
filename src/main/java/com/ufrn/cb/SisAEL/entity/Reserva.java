package com.ufrn.cb.SisAEL.entity;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="reservas")
public class Reserva {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private double valor;
	
	@ManyToMany
	@JoinColumn(name="id_equipamento")
	private List<Produto> produtos;
	
	@ManyToOne
	@JoinColumn(name = "id_reservante")
	private Cliente cliente;
	
	@ManyToOne
	private Horario horario;
		

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}



	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente reservante) {
		this.cliente = reservante;
	}

	public Horario getHorario() {
		return horario;
	}

	public void setHorario(Horario horario) {
		this.horario = horario;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	


	
	
	
	
	
	
	
	


	
	
	
	
	
	
}
