<?php
// Adler Vitor Santiago B.
$servername = "localhost";
$username = "root";
$password = "1234";
$dbname = "senaidb";

$conn = new mysqli($servername, $username, $password, $dbname);

if ($conn->connect_error) {
    die("Conexão falhou: " . $conn->connect_error);
}

// Inserir dados na tabela alunos
$sql_alunos = "INSERT INTO alunos (id_aluno, nome, turma) VALUES 
                (1, 'Lucas', 'A'),
                (2, 'Julia', 'B')";

if ($conn->multi_query($sql_alunos) === TRUE) {
    echo "Dados dos alunos inseridos com sucesso!<br>";

    // Inserir dados na tabela cursos
    $sql_cursos = "INSERT INTO cursos (id_curso, nome_curso, instrutor) VALUES 
                    (1, 'Matemática', 'Professor Carlos'),
                    (2, 'Ciências', 'Professora Ana')";

    if ($conn->multi_query($sql_cursos) === TRUE) {
        echo "Dados dos cursos inseridos com sucesso!";
    } else {
        echo "Erro ao inserir dados dos cursos: " . $conn->error;
    }
} else {
    echo "Erro ao inserir dados dos alunos: " . $conn->error;
}

$conn->close();
?>