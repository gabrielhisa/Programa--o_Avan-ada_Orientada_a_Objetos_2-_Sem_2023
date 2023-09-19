package com.estudante.estudante.repository;

import com.estudante.estudante.model.Aluno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Service
public class AlunoRepositoryImplementacao implements AlunoRepository{


    // Criando o EntityManager, para gerenciar as queries
    private EntityManager entityManager;


    // Injetando o entity manager usando injeção de construtor
    @Autowired
    public AlunoRepositoryImplementacao(EntityManager entityManager){
        this.entityManager = entityManager;
    }


    // Criando o método findAll para Aluno
    @Override
    public List<Aluno> findAll() {

        // Criando a query
        //TypedQuery<Aluno> query = entityManager.createQuery("FROM aluno ORDER BY nome", Aluno.class);
        TypedQuery<Aluno> query = entityManager.createQuery("SELECT a FROM aluno", Aluno.class);

        // Retornando a query em lista
        return query.getResultList();
    }
}
