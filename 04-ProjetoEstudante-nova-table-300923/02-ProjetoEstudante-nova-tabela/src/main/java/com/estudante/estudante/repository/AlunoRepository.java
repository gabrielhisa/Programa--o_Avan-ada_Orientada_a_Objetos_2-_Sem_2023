package com.estudante.estudante.repository;

import com.estudante.estudante.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

    //public List<Aluno> findAllByTituloContainingIgnoreCase (String titulo);

}