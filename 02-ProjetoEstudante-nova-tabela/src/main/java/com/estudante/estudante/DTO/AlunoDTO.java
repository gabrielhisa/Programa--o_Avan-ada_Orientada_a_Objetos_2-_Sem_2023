package com.estudante.estudante.DTO;

import com.estudante.estudante.model.Aluno;
import com.estudante.estudante.model.Nota;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

public class AlunoDTO {

    private long alunoId;
    private String nome;

    // Constructors, if needed

    public long getAlunoId() {
        return alunoId;
    }

    public void setAlunoId(long alunoId) {
        this.alunoId = alunoId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public static AlunoDTO mapToDTO(Aluno aluno) {
        AlunoDTO dto = new AlunoDTO();
        dto.setAlunoId(aluno.getAlunoId());
        dto.setNome(aluno.getNome());
        // Map other fields as needed
        return dto;
    }
}
