package com.estudante.estudante.repository;

import com.estudante.estudante.model.Aluno;
import com.estudante.estudante.model.Nota;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotaRepository  extends JpaRepository<Nota, Long> {
}
