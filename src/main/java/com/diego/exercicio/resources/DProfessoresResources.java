package com.diego.exercicio.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.diego.exercicio.domain.DProfessor;
import com.diego.exercicio.services.DProfessoresServices;

@RestController
@RequestMapping("/professores")
public class DProfessoresResources {

	@Autowired
	private DProfessoresServices dProfessoresServices;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<DProfessor>> listar() {

		List<DProfessor> dProfessores = dProfessoresServices.listar();

		return ResponseEntity.status(HttpStatus.OK).body(dProfessores);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> salvar(@RequestBody DProfessor dProfessor) {
		dProfessor = dProfessoresServices.salvar(dProfessor);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dProfessor.getId())
				.toUri();

		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<DProfessor> buscar(@PathVariable("id") Long id) {
		DProfessor dProfessor = dProfessoresServices.buscar(id);
		return ResponseEntity.status(HttpStatus.OK).body(dProfessor);

	}

}
