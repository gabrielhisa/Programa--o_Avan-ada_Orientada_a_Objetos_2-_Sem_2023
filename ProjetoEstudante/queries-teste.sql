-- Queries de teste
SELECT * FROM Alunos; 

-- Visualização de notas dos alunos
SELECT
    Alunos.nome AS NomeAluno,
    Cursos.nome AS NomeCurso,
    Notas.nota AS Nota
FROM
    Alunos
JOIN
    Notas ON Alunos.aluno_id = Notas.aluno_id
JOIN
    Cursos ON Notas.curso_id = Cursos.curso_id;
    
-- Professores, cursos e quantidade de alunos
SELECT
    P.nome AS NomeProfessor,
    C.nome AS NomeCurso,
    COUNT(A.aluno_id) AS QuantidadeAlunos
FROM
    Professores AS P
JOIN
    Cursos AS C ON P.professor_id = C.professor_id
LEFT JOIN
    Alunos AS A ON C.curso_id = A.curso_id
GROUP BY
    P.nome, C.nome;

