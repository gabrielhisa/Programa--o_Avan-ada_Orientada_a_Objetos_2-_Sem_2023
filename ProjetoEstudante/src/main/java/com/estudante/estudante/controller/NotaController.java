package com.estudante.estudante.controller;

import com.estudante.estudante.model.Nota;
import com.estudante.estudante.repository.NotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/nota")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class NotaController {

    @Autowired
    private NotaRepository repository;

    @GetMapping
    public ResponseEntity<List<Nota>> GetAll(){
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Nota> GetById(@PathVariable long id){
        return repository.findById(id)
                .map(resp -> ResponseEntity.ok(resp))
                .orElse(ResponseEntity.notFound().build());
    }

    /*
    private NotaRepository notaRepo;

    @Autowired
    public NotaController(NotaRepository repo) {
        notaRepo = repo;
    }

    @GetMapping("/todos")
    public List<Nota> findAll() {
        return notaRepo.findAll();
    }
     */
}
