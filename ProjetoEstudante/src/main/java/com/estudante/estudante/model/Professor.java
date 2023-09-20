package com.estudante.estudante.model;


import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="professores")
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "professor_id")
    private long professorId;
    private String nome;
    private String curso;
    private String cpf;
    private Date dataNascimento;
    private int ra;
    private String email;
    private String fone;

    // -------------------------------------------------------------------------
    // Validar pq relação está errada
    @OneToMany(mappedBy = "curso_id")
    private List<Curso> cursos;
    // -------------------------------------------------------------------------

    public long getProfessorId() {
        return professorId;
    }

    public void setProfessorId(long professorId) {
        this.professorId = professorId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public int getRa() {
        return ra;
    }

    public void setRa(int ra) {
        this.ra = ra;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "professorId=" + professorId +
                ", nome='" + nome + '\'' +
                ", curso='" + curso + '\'' +
                ", cpf='" + cpf + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", ra=" + ra +
                ", email='" + email + '\'' +
                ", fone='" + fone + '\'' +
                ", cursos=" + cursos +
                '}';
    }
}
