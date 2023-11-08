-- DROP DATABASE Estudante;
CREATE DATABASE IF NOT EXISTS Estudante;
USE Estudante;


CREATE TABLE Professores (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL
);

CREATE TABLE Alunos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL
);

CREATE TABLE Cursos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    professor_id INT,
    FOREIGN KEY (professor_id) REFERENCES Professores(id) ON DELETE CASCADE
);

CREATE TABLE Notas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    valor FLOAT NOT NULL,
    aluno_id INT,
    curso_id INT,
    FOREIGN KEY (aluno_id) REFERENCES Alunos(id) ON DELETE CASCADE,
    FOREIGN KEY (curso_id) REFERENCES Cursos(id) ON DELETE CASCADE
);

-- Inserts
INSERT INTO Professores (nome) VALUES
    ('Prof. Smith'),
    ('Prof. Johnson'),
    ('Prof. Brown'),
    ('Prof. Davis'),
    ('Prof. Anderson'),
    ('Prof. Wilson'),
    ('Prof. Martinez'),
    ('Prof. Jackson'),
    ('Prof. White'),
    ('Prof. Harris');

INSERT INTO Alunos (nome) VALUES
    ('Alice Johnson'),
    ('Bob Davis'),
    ('Carol Smith'),
    ('David Wilson'),
    ('Eva Harris'),
    ('Frank Anderson'),
    ('Grace Martinez'),
    ('Henry Brown'),
    ('Ivy Jackson'),
    ('Jack White');

INSERT INTO Cursos (nome, professor_id) VALUES
    ('Mathematics', 1),
    ('History', 2),
    ('Physics', 3),
    ('Chemistry', 4),
    ('Biology', 5),
    ('Literature', 6),
    ('Computer Science', 7),
    ('Art', 8),
    ('Music', 9),
    ('Physical Education', 10);

INSERT INTO Notas (valor, aluno_id, curso_id) VALUES
    (8.5, 1, 1),
    (7.8, 2, 2),
    (9.2, 3, 3),
    (6.4, 4, 4),
    (8.9, 5, 5),
    (7.2, 6, 6),
    (9.8, 7, 7),
    (8.0, 8, 8),
    (7.5, 9, 9),
    (6.9, 10, 10);