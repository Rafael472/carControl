package com.orangeTalents.carControl.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AnoNaoEncontradoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	AnoNaoEncontradoException(){
		super();
	}
	
	public AnoNaoEncontradoException(String mensagem){
		super(mensagem);
	}
}
