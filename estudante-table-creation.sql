-- Criando o banco de dados
CREATE DATABASE IF NOT EXISTS gerenciamento_estudante;
USE gerenciamento_estudante;


-- Criando estrutura para as tabelas e inserts para teste
-- Tabela de Alunos
CREATE TABLE Alunos (
    aluno_id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL,
    cpf VARCHAR(15) NOT NULL,
    ra INTEGER(20) NOT NULL,
    data_matricula DATE NOT NULL,
    email VARCHAR(40) NOT NULL,
    fone VARCHAR(20) NULL,
    endereco VARCHAR(50) NOT NULL,
    curso_id INTEGER NOT NULL
);

-- Tabela de Cursos
CREATE TABLE Cursos (
    curso_id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL,
    carga_horaria INT(5) NOT NULL,
    professor_id INT,
    aluno_id INT
);

-- Tabela de Professores
CREATE TABLE Professores (
    professor_id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL,
    curso VARCHAR(50) NOT NULL,
    cpf VARCHAR(15) NOT NULL,
    data_nascimento DATE NOT NULL,
    ra INTEGER(20) NOT NULL,
    email VARCHAR(40) NOT NULL,
    fone VARCHAR(20) NULL,
    curso_id INT
);

-- Tabela de Notas
CREATE TABLE Notas (
    nota_id INT PRIMARY KEY AUTO_INCREMENT,
    nota DECIMAL(4, 2),
    aluno_id INT,
    curso_id INT,
    professor_id INT
);

-- Adicionando CONSTRAINTS às tabelas
ALTER TABLE Alunos
ADD CONSTRAINT fk_cursos
FOREIGN KEY (curso_id)
REFERENCES Cursos(curso_id);

ALTER TABLE Cursos
ADD CONSTRAINT fk_professor
FOREIGN KEY (professor_id)
REFERENCES Professores(professor_id);

ALTER TABLE Cursos
ADD CONSTRAINT fk_aluno
FOREIGN KEY (aluno_id)
REFERENCES Alunos(aluno_id);

ALTER TABLE Professores
ADD CONSTRAINT fk_curso
FOREIGN KEY (curso_id)
REFERENCES Cursos(curso_id);

ALTER TABLE Notas
ADD CONSTRAINT fk_aluno2
FOREIGN KEY (aluno_id)
REFERENCES Alunos(aluno_id);

ALTER TABLE Notas
ADD CONSTRAINT fk_curso2
FOREIGN KEY (curso_id)
REFERENCES Cursos(curso_id);

ALTER TABLE Notas
ADD CONSTRAINT fk_professor2
FOREIGN KEY (professor_id)
REFERENCES Professores(professor_id);


-- Inserindo dados para testes nas tabelas
-- Inserts para a tabela "Cursos"
INSERT INTO Cursos (nome, carga_horaria, professor_id, aluno_id)
VALUES
    ('Análise e Desenvolvimento de Sistemas', 4000, NULL, NULL),
    ('Eventos', 4200, NULL, NULL),
    ('Gestão Comercial', 3600, NULL, NULL),
    ('Gestão Empresarial', 3800, NULL, NULL);

-- Inserts para a tabela "Alunos"
INSERT INTO Alunos (nome, cpf, ra, data_matricula, email, fone, endereco, curso_id)
VALUES
    ('Ana Silva', '123.456.789-01', 1001, '2023-01-15', 'ana@gmail.com', '(11) 1234-5678', 'Rua A, 123', 1),
    ('José Santos', '234.567.890-12', 1002, '2023-02-20', 'jose@gmail.com', '(21) 9876-5432', 'Rua B, 456', 2),
    ('Maria Oliveira', '345.678.901-23', 1003, '2023-03-25', 'maria@gmail.com', '(31) 8765-4321', 'Rua C, 789', 3),
    ('Carlos Pereira', '456.789.012-34', 1004, '2023-04-30', 'carlos@gmail.com', '(41) 7654-3210', 'Rua D, 101', 1),
    ('Mariana Almeida', '567.890.123-45', 1005, '2023-05-10', 'mariana@gmail.com', '(51) 6543-2109', 'Rua E, 202', 2),
    ('Fernando Souza', '678.901.234-56', 1006, '2023-06-15', 'fernando@gmail.com', '(61) 5432-1098', 'Rua F, 303', 3),
    ('Carolina Lima', '789.012.345-67', 1007, '2023-07-20', 'carolina@gmail.com', '(71) 4321-0987', 'Rua G, 404', 1),
    ('Rafaela Fernandes', '890.123.456-78', 1008, '2023-08-25', 'rafaela@gmail.com', '(81) 3210-9876', 'Rua H, 505', 2),
    ('Pedro Costa', '901.234.567-89', 1009, '2023-09-30', 'pedro@gmail.com', '(91) 2109-8765', 'Rua I, 606', 3),
    ('Lucas Oliveira', '012.345.678-90', 1010, '2023-10-05', 'lucas@gmail.com', '(01) 1098-7654', 'Rua J, 707', 1);

-- Inserts para a tabela "Professores"
INSERT INTO Professores (nome, curso, cpf, data_nascimento, ra, email, fone, curso_id)
VALUES
    ('Prof. Silva', 'Análise e Desenvolvimento de Sistemas', '123.456.789-01', '1980-05-15', 1001, 'prof.silva@gmail.com', '(11) 1234-5678', 1),
    ('Prof. Santos', 'Eventos', '234.567.890-12', '1975-08-20', 1002, 'prof.santos@gmail.com', '(21) 9876-5432', 2),
    ('Prof. Oliveira', 'Gestão Comercial', '345.678.901-23', '1982-03-10', 1003, 'prof.oliveira@gmail.com', '(31) 8765-4321', 3),
    ('Prof. Costa', 'Gestão Empresarial', '456.789.012-34', '1978-12-05', 1004, 'prof.costa@gmail.com', '(41) 7654-3210', NULL);

-- Inserts para a tabela "Notas"
INSERT INTO Notas (nota, aluno_id, curso_id, professor_id)
VALUES
    (8.5, 1, 1, 1),
    (7.8, 2, 2, 2),
    (9.2, 3, 3, 3),
    (6.4, 4, 1, 1),
    (8.9, 5, 2, 2),
    (7.2, 6, 3, 3),
    (9.8, 7, 1, 1),
    (8.0, 8, 2, 2),
    (7.5, 9, 3, 3),
    (6.9, 10, 1, 1);

-- Atualizando os registros da tabela "Cursos" para associar alunos e professores
UPDATE Cursos SET aluno_id = 1, professor_id = 1 WHERE nome = 'Análise e Desenvolvimento de Sistemas';
UPDATE Cursos SET aluno_id = 2, professor_id = 2 WHERE nome = 'Eventos';
UPDATE Cursos SET aluno_id = 3, professor_id = 3 WHERE nome = 'Gestão Comercial';
UPDATE Cursos SET aluno_id = 4, professor_id = 4 WHERE nome = 'Gestão Empresarial';



