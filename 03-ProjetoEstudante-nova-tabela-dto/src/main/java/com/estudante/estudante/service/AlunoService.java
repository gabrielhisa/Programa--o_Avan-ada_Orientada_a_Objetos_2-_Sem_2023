package com.estudante.estudante.service;

import com.estudante.estudante.DTO.AlunoDTO;
import com.estudante.estudante.model.Aluno;

public class AlunoService {

    public static AlunoDTO mapToDTO(Aluno aluno) {
        AlunoDTO dto = new AlunoDTO();
        dto.setAlunoId(aluno.getAlunoId());
        dto.setNome(aluno.getNome());
        // Map other fields as needed
        return dto;
    }

}
