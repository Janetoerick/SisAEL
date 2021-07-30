package com.ufrn.cb.SisAEL.exception;

public class ErroNaoExisteRegistroNoBD extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ErroNaoExisteRegistroNoBD(String msg) {
		super(msg);
	}
}
