package com.diego.exercicio.services.exceptions;

public class DProfessoExistenteException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3460543889583650725L;

	public DProfessoExistenteException(String mensagem) {
		super(mensagem);
	}

	public DProfessoExistenteException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}

}
