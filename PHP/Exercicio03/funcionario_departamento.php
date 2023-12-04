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

// Inserir dados na tabela funcionarios
$sql_funcionarios = "INSERT INTO funcionarios (id_funcionario, nome, cargo) VALUES 
                    (1, 'Luiz', 'Analista'),
                    (2, 'Carla', 'Gerente')";

if ($conn->multi_query($sql_funcionarios) === TRUE) {
    echo "Dados dos funcionários inseridos com sucesso!<br>";

    // Inserir dados na tabela departamentos
    $sql_departamentos = "INSERT INTO departamentos (id_departamento, nome_departamento) VALUES 
                        (1, 'TI'),
                        (2, 'Recursos Humanos')";

    if ($conn->multi_query($sql_departamentos) === TRUE) {
        echo "Dados dos departamentos inseridos com sucesso!";
    } else {
        echo "Erro ao inserir dados dos departamentos: " . $conn->error;
    }
} else {
    echo "Erro ao inserir dados dos funcionários: " . $conn->error;
}

$conn->close();
?>