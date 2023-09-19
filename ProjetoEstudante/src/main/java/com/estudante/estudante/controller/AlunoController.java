package com.estudante.estudante.controller;


import com.estudante.estudante.model.Aluno;
import com.estudante.estudante.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/aluno")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AlunoController {

    //@Autowired
    private AlunoRepository alunoRepo;

    @Autowired
    public AlunoController(AlunoRepository repo){
        alunoRepo = repo;
    }

    @GetMapping("/todos")
    public List<Aluno> findAll(){
        return alunoRepo.findAll();
    }
}
