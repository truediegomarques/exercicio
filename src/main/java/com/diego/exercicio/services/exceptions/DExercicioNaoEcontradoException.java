package com.diego.exercicio.services.exceptions;

public class DExercicioNaoEcontradoException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3460543889583650725L;

	public DExercicioNaoEcontradoException(String mensagem) {
		super(mensagem);
	}

	public DExercicioNaoEcontradoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}

}
