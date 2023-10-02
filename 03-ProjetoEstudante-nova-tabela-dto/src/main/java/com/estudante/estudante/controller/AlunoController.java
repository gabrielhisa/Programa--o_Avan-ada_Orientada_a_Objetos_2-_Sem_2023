package com.estudante.estudante.controller;


import com.estudante.estudante.DTO.AlunoDTO;
import com.estudante.estudante.model.Aluno;
import com.estudante.estudante.repository.AlunoRepository;
import com.estudante.estudante.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/aluno")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AlunoController {

    @Autowired
    private AlunoRepository repository;

    //----------------------------------------------------------------------------------------------------
    // Teste DTO
    @GetMapping("/todos")
    public ResponseEntity<List<AlunoDTO>> findAll(){
        List<Aluno> alunos = repository.findAll();
        List<AlunoDTO> alunoDTOs = alunos.stream()
                .map(AlunoService::mapToDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(alunoDTOs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlunoDTO> GetById(@PathVariable long id){
        Optional<Aluno> aluno = repository.findById(id);
        if (aluno.isPresent()) {
            AlunoDTO alunoDTO = AlunoService.mapToDTO(aluno.get());
            return ResponseEntity.ok(alunoDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/alunos")
    public ResponseEntity<AlunoDTO> post(@RequestBody Aluno aluno){
        Aluno savedAluno = repository.save(aluno);
        AlunoDTO alunoDTO = AlunoService.mapToDTO(savedAluno);
        return ResponseEntity.status(HttpStatus.CREATED).body(alunoDTO);
    }

    @PutMapping("/alunos/{id}")
    public ResponseEntity<AlunoDTO> put(@PathVariable long id, @RequestBody Aluno aluno){

        ????????????????????????

        /*
        Aluno savedAluno = repository.
        AlunoDTO alunoDTO = AlunoService.mapToDTO(savedAluno);
        return ResponseEntity.status(HttpStatus.OK).body(alunoDTO);

         */

    }

    //----------------------------------------------------------------------------------------------------
    /*

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

    @PostMapping("/alunos")
    public ResponseEntity<Aluno> post(@RequestBody Aluno aluno){
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(aluno));
    }


    // Método PUT
    @PutMapping("/alunos")
    public Aluno autalizarAluno(@RequestBody Aluno aluno){
        Aluno alunoDb = repository.save(aluno);
        return alunoDb;
    }

    // Método DELETE
    @DeleteMapping("/alunos/{id}")
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
