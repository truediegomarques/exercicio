package com.diego.exercicio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diego.exercicio.domain.DExercicio;

public interface DExercicioRepository extends JpaRepository<DExercicio, Long> {

}
