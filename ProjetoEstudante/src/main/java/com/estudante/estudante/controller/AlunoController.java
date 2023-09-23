package com.estudante.estudante.controller;


import com.estudante.estudante.model.Aluno;
import com.estudante.estudante.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aluno")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AlunoController {

    @Autowired
    private AlunoRepository repository;

    /*
    @Autowired
    public AlunoController(AlunoRepository esseAluno){
        repository = esseAluno;
    }
     */

    // Como o professor mostrou, utilizando métodos do JpaRepo
    @GetMapping("/todos")
    public ResponseEntity<List<Aluno>> findAll(){
        return ResponseEntity.ok(repository.findAll());
    }

    /*
    // Testando método findAll
    @GetMapping("/todos")
    public List<Aluno> findAll(){
        return repository.findAll();
    }
    */

    @GetMapping("/{id}")
    public ResponseEntity<Aluno> GetById(@PathVariable long id){
        return repository.findById(id)
                .map(resp -> ResponseEntity.ok(resp))
                .orElse(ResponseEntity.notFound().build());
    }

}
