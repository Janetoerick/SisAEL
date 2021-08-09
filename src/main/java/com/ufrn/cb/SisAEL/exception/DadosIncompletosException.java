package com.ufrn.cb.SisAEL.exception;

public class DadosIncompletosException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public DadosIncompletosException(String mensagem) {
		super(mensagem);
	}

}
