package com.diego.exercicio.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.diego.exercicio.domain.DExercicio;
import com.diego.exercicio.domain.DMateria;
import com.diego.exercicio.repository.DExercicioRepository;
import com.diego.exercicio.repository.DMateriaRepository;
import com.diego.exercicio.services.exceptions.DExercicioNaoEcontradoException;

@Service
public class DExerciciosService {

	@Autowired
	private DExercicioRepository dExercicioRepository;

	@Autowired
	private DMateriaRepository dMateriaRepository;

	public List<DExercicio> listar() {
		return dExercicioRepository.findAll();
	}

	public Optional<DExercicio> buscar(Long id) {
		Optional<DExercicio> dExercicio = dExercicioRepository.findById(id);

		if (dExercicio.isEmpty()) {
			throw new DExercicioNaoEcontradoException("O exercício não foi encontrado");
		}

		return dExercicio;

	}

	public DExercicio salvar(DExercicio dExercicio) {
		dExercicio.setId(null);
		return dExercicioRepository.save(dExercicio);
	}

	public void deletar(Long id) {
		try {
			dExercicioRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new DExercicioNaoEcontradoException("O exercicio não foi encontrado");
		}

	}

	public void atualizar(DExercicio dExercicio) {
		verificarExistencia(dExercicio);
		dExercicioRepository.save(dExercicio);

	}

	private void verificarExistencia(DExercicio dExercicio) {
		buscar(dExercicio.getId());
	}

	public DMateria salvarDMateria(Long dExercicioId, DMateria dMateria) {
		Optional<DExercicio> dExercicio = buscar(dExercicioId);
		dMateria.setdExercicio(dExercicio.get());

		return dMateriaRepository.save(dMateria);
	}

	public List<DMateria> listarMaterias(Long DExercicioId) {
		Optional<DExercicio> dExercicio = buscar(DExercicioId);

		return dExercicio.get().getMaterias();
	}

}
