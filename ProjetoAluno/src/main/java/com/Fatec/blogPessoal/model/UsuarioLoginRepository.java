package com.Fatec.blogPessoal.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fatec.blogPessoal.model.UsuarioLogin;

@Repository
public interface UsuarioLoginRepository extends JpaRepository <UsuarioLogin, Long> {

}
