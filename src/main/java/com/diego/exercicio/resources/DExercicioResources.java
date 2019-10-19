package com.diego.exercicio.resources;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.diego.exercicio.domain.DExercicio;
import com.diego.exercicio.domain.DMateria;
import com.diego.exercicio.services.DExerciciosService;

@RestController
@RequestMapping("/exercicio")
public class DExercicioResources {

	@Autowired
	private DExerciciosService dExerciciosService;

	@RequestMapping(method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<List<DExercicio>> listar() {
		return ResponseEntity.status(HttpStatus.OK).body(dExerciciosService.listar());

	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> salvar(@Valid @RequestBody DExercicio dExercicio) {
		dExerciciosService.salvar(dExercicio);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dExercicio.getId())
				.toUri();

		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> buscar(@PathVariable("id") Long id) {

		Optional<DExercicio> dExercicio = dExerciciosService.buscar(id);

		return ResponseEntity.status(HttpStatus.OK).body(dExercicio);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {
		dExerciciosService.deletar(id);

		return ResponseEntity.noContent().build();

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> atualizar(@RequestBody DExercicio dExercicio, @PathVariable("id") Long id) {
		dExercicio.setId(id);
		dExerciciosService.atualizar(dExercicio);

		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/{id}/materias", method = RequestMethod.POST)
	public ResponseEntity<Void> adicionarMateria(@PathVariable("id") Long dExercicioId,
			@RequestBody DMateria dMateria) {
		dExerciciosService.salvarDMateria(dExercicioId, dMateria);

		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().build().toUri();

		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/{id}/materias", method = RequestMethod.GET)
	public ResponseEntity<List<DMateria>> listarMaterias(@PathVariable("id") Long dExercicioId) {

		List<DMateria> dMaterias = dExerciciosService.listarMaterias(dExercicioId);

		return ResponseEntity.status(HttpStatus.OK).body(dMaterias);
	}

}
