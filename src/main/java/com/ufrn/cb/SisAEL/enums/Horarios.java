package com.ufrn.cb.SisAEL.enums;

public enum Horarios {
	h1(1,"07h às 08h"),
	h2(2,"08h às 09h"),
	h3(3,"10h às 11h"),
	h4(4,"11h às 12h"),
	h5(5,"13h às 14h"),
	h6(6,"14h às 15h"),
	h7(7,"15h às 16h"),
	h8(8,"16h às 17h"),
	h9(9,"17h às 18h"),
	h10(10,"18h às 19h"),
	h11(11,"19h às 20h"),
	h12(12,"20h às 21h"),
	h13(13,"21h às 22h");
	
	private final int chave;
	private final String descricao;
	private Horarios(int chave, String descricao) {
		this.chave = chave;
		this.descricao = descricao;
	}
	public int getChave() {
		return chave;
	}
	public String getDescricao() {
		return descricao;
	}
	
	
	
}
