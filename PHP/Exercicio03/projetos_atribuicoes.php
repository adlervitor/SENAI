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

// Inserir dados na tabela projetos
$sql_projetos = "INSERT INTO projetos (id_projeto, nome_projeto, descricao) VALUES 
                (1, 'Sistema de Controle', 'Desenvolvimento de um sistema interno'),
                (2, 'Portal Corporativo', 'Desenvolvimento de um portal para clientes')";

if ($conn->multi_query($sql_projetos) === TRUE) {
    echo "Dados dos projetos inseridos com sucesso!<br>";

    // Inserir dados na tabela atribuicoes
    $sql_atribuicoes = "INSERT INTO atribuicoes (id_atribuicao, id_projeto, id_funcionario) VALUES 
                        (1, 1, 1),
                        (2, 2, 2)";

    if ($conn->multi_query($sql_atribuicoes) === TRUE) {
        echo "Dados das atribuições inseridos com sucesso!";
    } else {
        echo "Erro ao inserir dados das atribuições: " . $conn->error;
    }
} else {
    echo "Erro ao inserir dados dos projetos: " . $conn->error;
}

$conn->close();
?>