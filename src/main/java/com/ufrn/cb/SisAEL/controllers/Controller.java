package com.ufrn.cb.SisAEL.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import com.ufrn.cb.SisAEL.service.FachadaService;

public abstract class Controller {
	
	@Autowired
	protected FachadaService fachada;

}
