package com.diego.exercicio.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class DExercicio {

	@JsonInclude(Include.NON_NULL)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	@JsonInclude(Include.NON_NULL)
	@NotEmpty(message = "O campo nome não pode ser vazio")
	@Size(max = 150, message = "O nome não pode ter mais de 150 caracteres")
	@JsonProperty("descricao")
	private String nome;
	@JsonInclude(Include.NON_NULL)
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date data;

	@JsonInclude(Include.NON_EMPTY)
	@OneToMany(mappedBy = "dExercicio")
	private List<DMateria> materias;

	@JsonInclude(Include.NON_NULL)
	@ManyToOne
	@JoinColumn(name = "DPROFESSOR_ID")
	private DProfessor dProfessor;
	

	public DExercicio() {
	}

	public DExercicio(Long id, String nome) {
		this.Id = id;
		this.nome = nome;

	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public List<DMateria> getMaterias() {
		return materias;
	}

	public void setMaterias(List<DMateria> materias) {
		this.materias = materias;
	}

	public DProfessor getdProfessor() {
		return dProfessor;
	}

	public void setdProfessor(DProfessor dProfessor) {
		this.dProfessor = dProfessor;
	}

}
