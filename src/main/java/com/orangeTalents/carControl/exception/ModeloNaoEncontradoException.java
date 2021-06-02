package com.orangeTalents.carControl.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ModeloNaoEncontradoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	ModeloNaoEncontradoException(){
		super();
	}
	
	public ModeloNaoEncontradoException(String mensagem){
		super(mensagem);
	}
}
