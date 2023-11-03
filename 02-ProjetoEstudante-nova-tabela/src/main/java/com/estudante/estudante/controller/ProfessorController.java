package com.estudante.estudante.controller;


import com.estudante.estudante.model.Aluno;
import com.estudante.estudante.model.Professor;
import com.estudante.estudante.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/professor")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProfessorController {

    @Autowired
    private ProfessorRepository repository;

    @GetMapping("/todos")
    public ResponseEntity<List<Professor>> GetAll(){
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Professor> GetById(@PathVariable long id){
        return repository.findById(id)
                .map(resp -> ResponseEntity.ok(resp))
                .orElse(ResponseEntity.notFound().build());
    }

    // Funcionando 100%
    @PostMapping("/professores")
    void post(@RequestBody Professor professor){
        ResponseEntity.status(HttpStatus.CREATED).body(repository.save(professor));
    }

    // Funcionando 100%, ID precisa ser declarado no JSON para atualização
    @PutMapping("/professores")
    public Professor put(@RequestBody Professor prof){
        Professor tempProf = repository.save(prof);
        return tempProf;
    }

    // Funcionando 100%
    @DeleteMapping("/professores/{id}")
    public String delete(@PathVariable long id){
        Optional<Professor> prof = repository.findById(id);
        // Jogando exceção se null
        if (!(prof.isPresent())){
            throw new RuntimeException("Id de professor não encontrado: " + id);
        }
        repository.deleteById(id);
        return "Deletado professor de id: " + id;
    }
}
