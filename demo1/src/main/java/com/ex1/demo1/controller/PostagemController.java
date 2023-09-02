package com.ex1.demo1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity; // O que exatamente isso faz?
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ex1.demo1.repository.PostagemRepository;
import com.ex1.demo1.model.Postagem;

@RestController // Uso de API REST pra controle de CRUD, pra trabalho com protocolo HTTP
@RequestMapping("/postagens") // Define endpoint
@CrossOrigin(origins = "*", allowedHeaders = "*") // Permissões, quem tem acesso (linkado com segurança depois), aqui define que todos tem acesso

public class PostagemController {
	
	@Autowired
	private PostagemRepository repository; // Injeção de dependência, deixando a instanciação da interface para o framework

	@GetMapping // Chama a função no endpoint, nome da função n importa
	public ResponseEntity<List<Postagem>> GetAll(){
		return ResponseEntity.ok(repository.findAll()); // Método para buscar todas as informações (todos os produtos em uma loja), nesse caso as postagens
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Postagem> GetById(@PathVariable long id){
		return repository.findById(id)
						 .map(resp -> ResponseEntity.ok(resp)) // O que o ResponseEntity retorna?
						 .orElse(ResponseEntity.notFound().build());
	}
	
	// Replicar pra usuario e tema, usuariologin n precisa
	
	
}
