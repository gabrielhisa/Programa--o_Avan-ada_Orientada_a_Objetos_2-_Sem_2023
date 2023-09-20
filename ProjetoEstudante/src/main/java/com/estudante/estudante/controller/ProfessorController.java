package com.estudante.estudante.controller;


import com.estudante.estudante.model.Professor;
import com.estudante.estudante.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professor")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProfessorController {

    @Autowired
    private ProfessorRepository repository;

    @GetMapping
    public ResponseEntity<List<Professor>> GetAll(){
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Professor> GetById(@PathVariable long id){
        return repository.findById(id)
                .map(resp -> ResponseEntity.ok(resp))
                .orElse(ResponseEntity.notFound().build());
    }

    /**
    private ProfessorRepository professorRepo;

    @Autowired
    public ProfessorController(ProfessorRepository repo) {
        professorRepo = repo;
    }

    @GetMapping("/todos")
    public List<Professor> findAll() {
        return professorRepo.findAll();
    }
     **/
}
