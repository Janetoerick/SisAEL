package com.ufrn.cb.SisAEL.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="clientes")
@Inheritance(strategy = InheritanceType.JOINED)
public class Cliente implements Usuario{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String nome;
	
	@Column(nullable = false, unique = true)
	private String nomeUsuario;
	
	@Column(nullable = false)
	private String senha;
	
	
	private String cargo;

	@Override
	public Long getId() {
		return this.id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
		
	}

	@Override
	public String getNome() {
		return this.nome;
	}

	@Override
	public void setNome(String nome) {
		this.nome = nome;	
	}

	@Override
	public String getNomeUsuario() {
		return this.nomeUsuario;
	}

	@Override
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
		
	}

	@Override
	public String getSenha() {
		return this.senha;
	}

	@Override
	public void setSenha(String senha) {
		this.senha = senha;
		
	}

	@Override
	public String getCargo() {
		
		return this.cargo;
	}

	@Override
	public void setCargo(String cargo) {
		this.cargo = cargo;
		
	}
	
	

}
