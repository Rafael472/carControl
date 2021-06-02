package com.orangeTalents.carControl.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UsuarioNaoEncontradoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	UsuarioNaoEncontradoException(){
		super();
	}
	
	public UsuarioNaoEncontradoException(String mensagem){
		super(mensagem);
	}
}
