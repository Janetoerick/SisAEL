package com.ufrn.cb.SisAEL.entity;

public interface Usuario {
	
	public Long getId();
	
	public void setId(Long id);
	
	public String getNome();
	
	public void setNome(String nomeUsuario);
	
	public String getNomeUsuario();
	
	public void setNomeUsuario(String nomeUsuario);
	
	public String getSenha();
	
	public void setSenha(String senha);
	
	public String getCargo();
	
	public void setCargo(String role);

}
