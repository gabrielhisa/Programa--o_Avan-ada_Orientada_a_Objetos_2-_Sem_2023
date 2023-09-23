package com.estudante.estudante.model;


import javax.persistence.*;

@Entity
@Table(name="notas")
public class Nota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nota_id")
    private Long notaId;
    private Double nota;

    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;

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

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    @Override
    public String toString() {
        return "Nota{" +
                "notaId=" + notaId +
                ", nota=" + nota +
                ", aluno=" + aluno +
                ", curso=" + curso +
                ", professor=" + professor +
                '}';
    }
}
