package com.diego.exercicio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diego.exercicio.domain.DProfessor;

public interface DProfessorRepository extends JpaRepository<DProfessor, Long> {

}
