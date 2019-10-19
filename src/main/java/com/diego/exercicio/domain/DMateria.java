package com.diego.exercicio.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
public class DMateria {

	@JsonInclude(Include.NON_NULL)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@JsonInclude(Include.NON_NULL)
	private String assunto;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DEXERCICIO_ID")
	@JsonIgnore
	private DExercicio dExercicio;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public DExercicio getdExercicio() {
		return dExercicio;
	}

	public void setdExercicio(DExercicio dExercicio) {
		this.dExercicio = dExercicio;
	}

}
