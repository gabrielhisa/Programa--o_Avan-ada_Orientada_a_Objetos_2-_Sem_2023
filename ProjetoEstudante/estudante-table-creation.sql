-- Criando o banco de dados
CREATE DATABASE IF NOT EXISTS gerenciamento_estudante;
USE gerenciamento_estudante;


-- Criando estrutura para as tabelas e inserts para teste
-- Tabela de estudantes
DROP TABLE IF EXISTS estudante;
CREATE TABLE estudante (
  id INTEGER AUTO_INCREMENT PRIMARY KEY,
  curso_id INTEGER NOT NULL,
  nome VARCHAR(50) NOT NULL,
  cpf VARCHAR(15) NOT NULL,
  data_nascimento DATE NOT NULL,
  ra INTEGER(20) NOT NULL,
  data_matricula DATE NOT NULL,
  email VARCHAR(40) NOT NULL,
  fone VARCHAR(20) NULL,
  CONSTRAINT fk_cursos
  FOREIGN KEY (curso_id) 
  REFERENCES curso(id)
);
  
INSERT INTO estudante (nome, cpf, data_nascimento, ra, data_matricula, email, fone)
VALUES
('Joao Batista', '12345677', '1990-07-02', '123456789', '2020-01-01', 'joao_123@gmail.com', '12'),
('Carla Souza','1902265','1985-01-15','566562919','2020-01-01','carla_souza@gmail.com', 11917892314),
('Renato Oliveira','9019643115','1986-02-16','438291165','2020-01-01','renato_oliveira@gmail.com','11982810989'),
('Amanda Alves','564512974','1987-03-17','945264621','2020-01-01','amanda_alves@gmail.com','11997478166'),
('Jao Jao','77536318','1988-04-18','158537100','2020-01-01','jao_jao@gmail.com','11954125114'),
('Otavio Albuquerque','98000925','1989-05-19','853253913','2020-07-01','otavio_albuquerque@gmail.com','11991939504'),
('Epaminondas Jamanta','56312461','1990-06-20','994045311','2020-07-01','epaminondas_jamanta@gmail.com','11917658182'),
('Escaminosflau Diamantina','8431680','1991-07-21','379070245','2020-07-01','escaminosflau_diamantina@gmail.com','11996141857'),
('Elaine Alves','91342298','1992-08-22','263936227','2020-07-01','elaine_alves@gmail.com','11950279962'),
('Carol Jonisson','6021057910','1993-09-23','911191272','2020-07-01','carol_jonisson@gmail.com','11937042631');


-- Tabela de endereços
DROP TABLE IF EXISTS endereco;

CREATE TABLE endereco (
  id INTEGER AUTO_INCREMENT PRIMARY KEY,
  estudante_id INTEGER,
  logradouro VARCHAR(50) NOT NULL,
  numero VARCHAR(6) NOT NULL,
  complemento VARCHAR(40) NULL,
  cep INTEGER(9) NOT NULL,
  bairro VARCHAR(50) NOT NULL,
  cidade VARCHAR(50) NOT NULL,
  estado CHAR(2) NOT NULL,
  CONSTRAINT fk_estudante 
  FOREIGN KEY (estudante_id) 
  REFERENCES estudante(id)
);

INSERT INTO endereco (estudante_id, logradouro, numero, complemento, cep, bairro, cidade, estado)
VALUES
('4', 'Largo do Batata','1700', '12º andar','170036606','Pinheiros','São Paulo','SP'),
('3', 'Rua Calia','206', '','149631556','Saúde','São Paulo','SP'),
('2', 'Rua Longe','123', 'casa fundos','376535031','Barra Velha','Suzano','SP'),
('1', 'Av. César','80045', 'subterrâneo','681150842','Seilá','Osasco','SP');


-- Tabela de cursos
DROP TABLE IF EXISTS curso;
CREATE TABLE curso (
  id INTEGER AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(50) NOT NULL,
  carga_horaria int(5) NOT NULL
);
  
INSERT INTO curso (nome, carga_horaria)
VALUES
('Análise e Desenvolvimento de Software', '99999'),
('Eventos', '1600'),
('Gestão Comercial', '1800'),
('Gestão de Saúde Mental Inexistente', '200');


-- Tabela de professores
DROP TABLE IF EXISTS professor;

CREATE TABLE professor (
  id INTEGER AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(50) NOT NULL,
  curso VARCHAR(50) NOT NULL,
  cpf VARCHAR(15) NOT NULL,
  data_nascimento DATE NOT NULL,
  ra INTEGER(20) NOT NULL,
  email VARCHAR(40) NOT NULL,
  fone VARCHAR(20) NULL
);
  
INSERT INTO professor (nome, curso, cpf, data_nascimento, ra, email, fone)
VALUES
('Andreia Machion', 'Análise e Desenvolvimento de Software','12345678977','1950-01-01','123456789', 'andreia_machion@gmail.com','11912345678'),
('Andreia Machion2', 'ADS','57181253791','1950-01-01','489975373', 'andreia_machion2@gmail.com','11921265677'),
('Andreia Machion3', 'Análise e Desenvolvimento de Software','2595383908','1950-01-01','139239501', 'andreia_machion3@gmail.com','11991982943'),
('Caxuxão','Eventos', '33302507303','1950-01-01','941972917', 'caxuxão@gmail.com','11932068461'),
('Anderson Mendonça', 'Gestão Comercial','4435462987','1950-01-01','147372022', 'anderson_mendonça@gmail.com','11976440509');

/*
-- Tabela de turmas
DROP TABLE IF EXISTS turma;

CREATE TABLE turma (
  id INTEGER AUTO_INCREMENT PRIMARY KEY,
  período VARCHAR(20) NOT NULL,
  curso VARCHAR(50) NOT NULL,
  professor VARCHAR(50) NOT NULL,
  aluno VARCHAR(40) NOT NULL
);

INSERT INTO turma (período, curso, professor, aluno)
VALUES
('manhã', 'Análise e Desenvolvimento de Software', 'Andreia Machion', 'Joao Batista'),
('noite', 'Eventos', 'Caxuxão', 'Carla Souza');
*/

-- Relacionamentos entre tabelas
