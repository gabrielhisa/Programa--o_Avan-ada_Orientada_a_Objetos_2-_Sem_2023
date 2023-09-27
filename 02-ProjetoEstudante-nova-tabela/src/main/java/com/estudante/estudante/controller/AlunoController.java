package com.estudante.estudante.controller;


import com.estudante.estudante.model.Aluno;
import com.estudante.estudante.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/aluno")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AlunoController {

    @Autowired
    private AlunoRepository repository;

    // Como o professor mostrou, utilizando métodos do JpaRepo
    @GetMapping("/todos")
    public ResponseEntity<List<Aluno>> findAll(){
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aluno> GetById(@PathVariable long id){
        return repository.findById(id)
                .map(resp -> ResponseEntity.ok(resp))
                .orElse(ResponseEntity.notFound().build());
    }

    // Método POST
    @PostMapping("/alunos")
    public Aluno adicionarAluno(@RequestBody Aluno aluno){
        //aluno.setId(0);
        // Forçando salvar um item novo, ao invés de update
        Aluno alunoDb = repository.save(aluno);
        return alunoDb;
    }

    // Método PUT
    @PutMapping("/alunos")
    public Aluno autalizarAluno(@RequestBody Aluno aluno){
        Aluno alunoDb = repository.save(aluno);
        return alunoDb;
    }

    // Método DELETE
    @DeleteMapping("/alunos/{id}")
    public String deletarAluno(@PathVariable long id){
        Optional<Aluno> aluno = repository.findById(id);
        // Jogando exceção se null
        if (aluno == null){
            throw new RuntimeException("Id de aluno não encontrado: " + id);
        }
        repository.deleteById(id);
        return "Deletado aluno de id: " + id;
    }

}
