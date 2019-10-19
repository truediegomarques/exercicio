package com.diego.exercicio.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diego.exercicio.domain.DProfessor;
import com.diego.exercicio.repository.DProfessorRepository;
import com.diego.exercicio.services.exceptions.DProfessoExistenteException;
import com.diego.exercicio.services.exceptions.DProfessorNaoEcontradoException;

@Service
public class DProfessoresServices {

	@Autowired
	private DProfessorRepository dProfessorRepository;

	public List<DProfessor> listar() {
		return dProfessorRepository.findAll();
	}

	public DProfessor salvar(DProfessor dProfessor) {
		if (dProfessor.getId() != null) {
			Optional<DProfessor> dP = dProfessorRepository.findById(dProfessor.getId());

			if (!dP.isEmpty()) {
				throw new DProfessoExistenteException("O professor já existe");
			}
		}

		return dProfessorRepository.save(dProfessor);

	}

	public DProfessor buscar(Long id) {
		Optional<DProfessor> dProfessor = dProfessorRepository.findById(id);

		if (dProfessor.isEmpty()) {
			throw new DProfessorNaoEcontradoException("DProfessor não encontrado");
		}
		return dProfessor.get();

	}

}
