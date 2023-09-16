package com.Fatec.blogPessoal.controller;

import com.Fatec.blogPessoal.model.Postagem;
import com.Fatec.blogPessoal.model.Usuario;
import com.Fatec.blogPessoal.repository.UsuarioRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioController {

	@Autowired
	private UsuarioRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Usuario>> GetAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Ususario> GetById(@PathVariable long id){
		return repository.findById(id)
						 .map(resp -> ResponseEntity.ok(resp))
						 .orElse(ResponseEntity.notFound().build());
	}
	
	
	
}
