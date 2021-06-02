package com.orangeTalents.carControl.exception;


public class BadRequestException extends NegocioException{

	private static final long serialVersionUID = 1L;

	public BadRequestException(String message) {
		super(message);
	}

}
