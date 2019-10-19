package com.diego.exercicio.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.diego.exercicio.domain.DetalhesErro;
import com.diego.exercicio.services.exceptions.DExercicioNaoEcontradoException;
import com.diego.exercicio.services.exceptions.DProfessoExistenteException;
import com.diego.exercicio.services.exceptions.DProfessorNaoEcontradoException;

@ControllerAdvice
public class ResourceExcpetionHandler {

	@ExceptionHandler(DExercicioNaoEcontradoException.class)
	public ResponseEntity<DetalhesErro> handleDExercicioNaoEcontradoException(DExercicioNaoEcontradoException e,
			HttpServletRequest request) {

		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(404l);
		erro.setTitulo("O exercicio não foi encontrado");
		erro.setMensagemDesenvolvedor("http://erros.exercicio.diego.com");
		erro.setTimestamp(System.currentTimeMillis());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);

	}

	@ExceptionHandler(DProfessoExistenteException.class)
	public ResponseEntity<DetalhesErro> handleDProfessoExistenteException(DProfessoExistenteException e,
			HttpServletRequest request) {

		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(409l);
		erro.setTitulo("Professor já existente");
		erro.setMensagemDesenvolvedor("http://erros.exercicio.diego.com/409");
		erro.setTimestamp(System.currentTimeMillis());

		return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);

	}

	@ExceptionHandler(DProfessorNaoEcontradoException.class)
	public ResponseEntity<DetalhesErro> handleDProfessorNaoEcontradoException(DProfessorNaoEcontradoException e,
			HttpServletRequest request) {

		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(404l);
		erro.setTitulo("DProfessor não encontrado");
		erro.setMensagemDesenvolvedor("http://erros.exercicio.diego.com/404");
		erro.setTimestamp(System.currentTimeMillis());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);

	}

	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<DetalhesErro> handleDataIntegrityViolationException(DataIntegrityViolationException e,
			HttpServletRequest request) {

		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(400l);
		erro.setTitulo("Requisição Inválida");
		erro.setMensagemDesenvolvedor("http://erros.exercicio.diego.com/400");
		erro.setTimestamp(System.currentTimeMillis());

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);

	}
	
	//DataIntegrityViolationException
}
