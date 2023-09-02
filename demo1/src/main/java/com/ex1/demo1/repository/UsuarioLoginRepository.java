package com.ex1.demo1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ex1.demo1.model.UsuarioLogin;

@Repository
public interface UsuarioLoginRepository extends JpaRepository<UsuarioLogin, Long> {

}
