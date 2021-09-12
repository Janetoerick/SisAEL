package com.ufrn.cb.SisAEL.service;

import com.ufrn.cb.SisAEL.entity.Produto;

public interface ValidatorStrategy {
	
	public boolean validar(Produto produto);

}
