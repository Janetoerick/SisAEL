package com.ufrn.cb.SisAEL.exception;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TratadorDeExcessao{
	
	@ExceptionHandler(value=ColisaoDeHorarioException.class)
	public ResponseEntity<ErroPadrao> 
		colisaoDeHorarioException(ColisaoDeHorarioException e, 
				HttpServletRequest request){
		ErroPadrao erro = new ErroPadrao();
		erro.setTimestamp(Instant.now());
		erro.setError("COLISAO DE HORARIO");
		erro.setMessage(e.getMessage());
		erro.setStatus(HttpStatus.CONFLICT.value());
		erro.setPath(request.getRequestURI());
		return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
		
		
		
	}
	
	@ExceptionHandler(value=DadosInvalidosException.class)
	public ResponseEntity<ErroPadrao> 
	dadosInvalidosException(DadosInvalidosException e, 
			HttpServletRequest request){
		ErroPadrao erro = new ErroPadrao();
		erro.setTimestamp(Instant.now());
		erro.setError("DADOS INVALIDOS");
		erro.setMessage(e.getMessage());
		erro.setStatus(HttpStatus.CONFLICT.value());
		erro.setPath(request.getRequestURI());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
		
		
	}
	
	@ExceptionHandler(value=ReservaException.class)
	public ResponseEntity<ErroPadrao> reservaException(ReservaException e, HttpServletRequest request){
		
		ErroPadrao erro = new ErroPadrao();
		erro.setTimestamp(Instant.now());
		erro.setError("IMPOSSIVEL RESERVAR");
		erro.setMessage(e.getMessage());
		erro.setStatus(HttpStatus.CONFLICT.value());
		erro.setPath(request.getRequestURI());
		return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
		
	}

}
