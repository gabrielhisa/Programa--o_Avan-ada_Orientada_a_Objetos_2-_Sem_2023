package com.ex1.demo1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ex1.demo1.model.Postagem;

// Exercício em sala tem o nome de com.fatec.blogPessoal
/*
 * Fazer o mesmo pra tema, usuario e usuariologin
 */

@Repository
public interface PostagemRepository extends JpaRepository<Postagem, Long>{
	

}
