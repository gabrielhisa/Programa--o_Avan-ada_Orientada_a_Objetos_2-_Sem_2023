package com.estudante.estudante.model;


import javax.persistence.*;

@Entity
@Table(name="Notas")
public class Nota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long notaId;
    private double nota;
    private int alunoId;
    private int cursoId;
    private int professorId;

    public long getNotaId() {
        return notaId;
    }

    public void setNotaId(long notaId) {
        this.notaId = notaId;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public int getAlunoId() {
        return alunoId;
    }

    public void setAlunoId(int alunoId) {
        this.alunoId = alunoId;
    }

    public int getCursoId() {
        return cursoId;
    }

    public void setCursoId(int cursoId) {
        this.cursoId = cursoId;
    }

    public int getProfessorId() {
        return professorId;
    }

    public void setProfessorId(int professorId) {
        this.professorId = professorId;
    }
}
