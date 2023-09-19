package com.estudante.estudante.model;


import javax.persistence.*;

@Entity
@Table(name="Cursos")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cursoId;
    private String nome;
    private int cargaHoraria;
    private long professorId;
    private long alunoId;

    public long getCursoId() {
        return cursoId;
    }

    public void setCursoId(long cursoId) {
        this.cursoId = cursoId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public long getProfessorId() {
        return professorId;
    }

    public void setProfessorId(long professorId) {
        this.professorId = professorId;
    }

    public long getAlunoId() {
        return alunoId;
    }

    public void setAlunoId(long alunoId) {
        this.alunoId = alunoId;
    }
}
