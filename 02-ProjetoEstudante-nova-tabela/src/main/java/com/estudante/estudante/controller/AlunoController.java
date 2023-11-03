package com.estudante.estudante.controller;


import com.estudante.estudante.model.Aluno;
import com.estudante.estudante.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    // Funcionando 100%
    @GetMapping("/todos")
    public ResponseEntity<List<Aluno>> findAll(){
        return ResponseEntity.ok(repository.findAll());
    }

    // Funcionando 100%
    @GetMapping("/{id}")
    public ResponseEntity<Aluno> GetById(@PathVariable long id){
        return repository.findById(id)
                .map(resp -> ResponseEntity.ok(resp))
                .orElse(ResponseEntity.notFound().build());
    }

    // Funcionando 100%
    @PostMapping("/alunos")
    void post(@RequestBody Aluno aluno){
        ResponseEntity.status(HttpStatus.CREATED).body(repository.save(aluno));
    }

    // Funcionando 100%, ID precisa ser declarado no JSON para atualização
    @PutMapping("/alunos")
    public Aluno put(@RequestBody Aluno aluno){
        Aluno alunoDb = repository.save(aluno);
        return alunoDb;
    }

    // Funcionando 100%
    @DeleteMapping("/alunos/{id}")
    public String deletarAluno(@PathVariable long id){
        Optional<Aluno> aluno = repository.findById(id);
        // Jogando exceção se null
        if (!(aluno.isPresent())){
            throw new RuntimeException("Id de aluno não encontrado: " + id);
        }
        repository.deleteById(id);
        return "Deletado aluno de id: " + id;
    }

}
