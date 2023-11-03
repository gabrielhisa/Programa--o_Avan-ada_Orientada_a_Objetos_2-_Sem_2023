package com.estudante.estudante.controller;

import com.estudante.estudante.model.Aluno;
import com.estudante.estudante.repository.AlunoRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
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
    public ResponseEntity<List<Aluno>> findAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aluno> GetById(@PathVariable long id) {
        return repository.findById(id)
                .map(resp -> ResponseEntity.ok(resp))
                .orElse(ResponseEntity.notFound().build());
    }





    // Método POST funciona ok
    // Método do professor
    @PostMapping("/alunos")
    public ResponseEntity<Aluno> post(@RequestBody Aluno aluno) {
        aluno.setAlunoId(0);
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(aluno));
    }

    // Método PUT N FUNCIONA como fazer sacoisa funcionar?
    /*

    public ResponseEntity<Aluno> put(@RequestBody Aluno aluno) {
        return ResponseEntity.status(HttpStatus.OK).body(repository.save(aluno));
    }
    */


    @PutMapping("/alunos")
    public Aluno autalizarAluno(@RequestBody Aluno aluno){
        Aluno alunoDb = repository.save(aluno);
        return alunoDb;
    }







    // Método DELETE, com mensagem de retorno de confirmação/ID não encontrado
    @DeleteMapping("/alunos/{id}")
    public String delete(@PathVariable long id) {
        Optional<Aluno> temp = Optional.of(new Aluno());
        temp = repository.findById(id);

        if (temp.isPresent()) {
            repository.deleteById(id);
            return "ID deletado: " + id;
        } else {
            return "Aluno não encontrado, ID: " + id;
        }
    }

}
