package com.Fatec.blogPessoal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fatec.blogPessoal.model.Tema;

@Repository
public interface TemaRepository extends JpaRepository <Tema, Long> { 

}
