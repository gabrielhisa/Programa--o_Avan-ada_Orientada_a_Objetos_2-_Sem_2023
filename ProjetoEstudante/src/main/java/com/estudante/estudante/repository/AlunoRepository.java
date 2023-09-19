package com.estudante.estudante.repository;

import com.estudante.estudante.model.Aluno;

import java.util.List;

public interface AlunoRepository {

    List<Aluno> findAll();
}
