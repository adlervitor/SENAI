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

// Inserir dados na tabela livros
$sql_livros = "INSERT INTO livros (id_livro, titulo, ano_publicacao) VALUES 
                (1, 'Aprendendo Python', 2020),
                (2, 'Introdução à Inteligência Artificial', 2019)";

if ($conn->multi_query($sql_livros) === TRUE) {
    echo "Dados dos livros inseridos com sucesso!<br>";

    // Inserir dados na tabela autores
    $sql_autores = "INSERT INTO autores (id_autor, nome_autor) VALUES 
                    (1, 'Carlos Silva'),
                    (2, 'Ana Souza')";

    if ($conn->multi_query($sql_autores) === TRUE) {
        echo "Dados dos autores inseridos com sucesso!";
    } else {
        echo "Erro ao inserir dados dos autores: " . $conn->error;
    }
} else {
    echo "Erro ao inserir dados dos livros: " . $conn->error;
}

$conn->close();
?>