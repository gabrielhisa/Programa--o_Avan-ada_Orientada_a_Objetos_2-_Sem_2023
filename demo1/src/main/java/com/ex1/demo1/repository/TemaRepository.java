package com.ex1.demo1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ex1.demo1.model.Tema;

@Repository
public interface TemaRepository extends JpaRepository<Tema, Long>{

}
