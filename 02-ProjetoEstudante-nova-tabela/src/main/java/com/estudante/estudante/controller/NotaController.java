package com.estudante.estudante.controller;

import com.estudante.estudante.model.Aluno;
import com.estudante.estudante.model.Curso;
import com.estudante.estudante.model.Nota;
import com.estudante.estudante.repository.NotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/nota")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class NotaController {

    @Autowired
    private NotaRepository repository;

    // Funcionando 100%
    @GetMapping("/todos")
    public ResponseEntity<List<Nota>> GetAll(){
        return ResponseEntity.ok(repository.findAll());
    }

    // Funcionando 100%
    @GetMapping("/{id}")
    public ResponseEntity<Nota> GetById(@PathVariable long id){
        return repository.findById(id)
                .map(resp -> ResponseEntity.ok(resp))
                .orElse(ResponseEntity.notFound().build());
    }

    // Funcionando 100%, basta não declarar o ID do curso no JSON e ele vai criar um novo
    @PostMapping("/notas")
    void post(@RequestBody Nota nota){
        ResponseEntity.status(HttpStatus.CREATED).body(repository.save(nota));
    }

    // Funcionando 100%, ID precisa ser declarado no JSON para atualização
    @PutMapping("/notas")
    public Nota put(@RequestBody Nota nota){
        Nota notaTemp = repository.save(nota);
        return notaTemp;
    }

    // Funcionando 100%
    @DeleteMapping("/notas/{id}")
    public String deletarNota(@PathVariable long id){
        Optional<Nota> nota = repository.findById(id);
        // Jogando exceção se null
        if (!(nota.isPresent())){
            throw new RuntimeException("Id da nota não encontrada: " + id);
        }
        repository.deleteById(id);
        return "Deletada nota de id: " + id;
    }
}
