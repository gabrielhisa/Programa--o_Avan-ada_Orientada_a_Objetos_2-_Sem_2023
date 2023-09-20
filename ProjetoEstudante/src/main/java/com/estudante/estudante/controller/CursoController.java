package com.estudante.estudante.controller;


import com.estudante.estudante.model.Aluno;
import com.estudante.estudante.model.Curso;
import com.estudante.estudante.repository.AlunoRepository;
import com.estudante.estudante.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/curso")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CursoController {

    @Autowired
    private CursoRepository repository;

    @GetMapping
    public ResponseEntity<List<Curso>> GetAll(){
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Curso> GetById(@PathVariable long id){
        return repository.findById(id)
                .map(resp -> ResponseEntity.ok(resp))
                .orElse(ResponseEntity.notFound().build());
    }

    /**
    private CursoRepository cursoRepo;

    @Autowired
    public CursoController(CursoRepository repo) {
        cursoRepo = repo;
    }

    @GetMapping("/todos")
    public List<Curso> findAll() {
        return cursoRepo.findAll();
    }
     **/
}
