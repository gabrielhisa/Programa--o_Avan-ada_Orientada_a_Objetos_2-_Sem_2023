package com.estudante.estudante.controller;


import com.estudante.estudante.model.Aluno;
import com.estudante.estudante.model.Curso;
import com.estudante.estudante.repository.AlunoRepository;
import com.estudante.estudante.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/curso")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CursoController {

    @Autowired
    private CursoRepository repository;

    // Funcionando 100%
    @GetMapping("/todos")
    public ResponseEntity<List<Curso>> GetAll(){
        return ResponseEntity.ok(repository.findAll());
    }

    // Funcionando 100%
    @GetMapping("/{id}")
    public ResponseEntity<Curso> GetById(@PathVariable long id){
        return repository.findById(id)
                .map(resp -> ResponseEntity.ok(resp))
                .orElse(ResponseEntity.notFound().build());
    }

    // Funcionando 100%, basta não declarar o ID do curso no JSON e ele vai criar um novo
    @PostMapping("/cursos")
    void post(@RequestBody Curso curso){
        ResponseEntity.status(HttpStatus.CREATED).body(repository.save(curso));
    }

    // Funcionando 100%, ID precisa ser declarado no JSON para atualização
    @PutMapping("/cursos")
    public Curso put(@RequestBody Curso curso){
        Curso cursoTemp = repository.save(curso);
        return cursoTemp;
    }

    // Funcionando 100%, adicionei "ON DELETE CASCADE" no banco de dados
    @DeleteMapping("/cursos/{id}")
    public String deletarCurso(@PathVariable long id){
        Optional<Curso> curso = repository.findById(id);
        // Jogando exceção se null
        if (!(curso.isPresent())){
            throw new RuntimeException("Id do curso não encontrado: " + id);
        }
        repository.deleteById(id);
        return "Deletado curso de id: " + id;
    }
}
