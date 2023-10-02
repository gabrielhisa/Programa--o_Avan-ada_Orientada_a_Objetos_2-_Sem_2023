package com.estudante.estudante.repository;

import com.estudante.estudante.model.Aluno;
import com.estudante.estudante.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository  extends JpaRepository<Professor, Long> {
}
