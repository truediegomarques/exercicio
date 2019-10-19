package com.diego.exercicio.services.exceptions;

public class DProfessorNaoEcontradoException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3460543889583650725L;

	public DProfessorNaoEcontradoException(String mensagem) {
		super(mensagem);
	}

	public DProfessorNaoEcontradoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}

}
