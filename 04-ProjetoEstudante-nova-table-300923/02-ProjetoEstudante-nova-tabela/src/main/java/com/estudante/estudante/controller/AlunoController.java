package com.estudante.estudante.controller;


import com.estudante.estudante.model.Aluno;
import com.estudante.estudante.repository.AlunoRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<List<Aluno>> findAll(){
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aluno> GetById(@PathVariable long id){
        return repository.findById(id)
                .map(resp -> ResponseEntity.ok(resp))
                .orElse(ResponseEntity.notFound().build());
    }

    // Método POST funciona ok
    // Método do professor
    @PostMapping("/alunos")
    public ResponseEntity<Aluno> post (@RequestBody Aluno aluno){

        //return ResponseEntity.status(HttpStatus.CREATED).body(REPOSITORY.save(aluno));
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(aluno));

    }

    /**
    // Original
    @PostMapping("/alunos")
    public Aluno adicionarAluno(@RequestBody Aluno aluno){
        //aluno.setId(0);
        // Forçando salvar um item novo, ao invés de update
        Aluno alunoDb = repository.save(aluno);
        return alunoDb;
    }
    **/



    // Método PUT N FUNCIONA como fazer sacoisa funcionar?

    @PutMapping("/alunos")
    public ResponseEntity<Aluno> put(@RequestBody Aluno aluno){
        return ResponseEntity.status(HttpStatus.OK).body(repository.save(aluno));
    }


    /*
    public Aluno autalizarAluno(@RequestBody Aluno aluno){
        Aluno alunoDb = repository.save(aluno);
        return alunoDb;
    }

     */

    // Método DELETE funciona, soh preciso melhorar as mensagens confirmando se foi deletado ou n
    @DeleteMapping("/alunos/{id}")
    public void delete(@PathVariable long id){
        repository.deleteById(id);

        //throw new RuntimeException("Id de aluno não encontrado: " + id);



    }


    /*
    public String deletarAluno(@PathVariable long id){
        Optional<Aluno> aluno = repository.findById(id);
        // Jogando exceção se null
        if (aluno == null){
            throw new RuntimeException("Id de aluno não encontrado: " + id);
        }
        repository.deleteById(id);
        return "Deletado aluno de id: " + id;
    }

     */

}
