package com.orangeTalents.carControl.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class MarcaNaoEncontradaException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public MarcaNaoEncontradaException(){
		super();
	}
	
	public MarcaNaoEncontradaException(String mensagem){
		super(mensagem);
	}

}
