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

// Inserir dados na tabela resultados_exames
$sql_resultados = "INSERT INTO resultados_exames (id_resultado, tipo_exame, resultado) VALUES 
                    (1, 'Exame de Sangue', 'Normal'),
                    (2, 'Raio-X', 'Fratura identificada')";

if ($conn->multi_query($sql_resultados) === TRUE) {
    echo "Dados dos resultados de exames inseridos com sucesso!<br>";

    // Inserir dados na tabela pacientes
    $sql_pacientes = "INSERT INTO pacientes (id_paciente, nome_paciente, data_nascimento) VALUES 
                    (1, 'Mariana', '1995-06-10'),
                    (2, 'Rafael', '1987-09-25')";

    if ($conn->multi_query($sql_pacientes) === TRUE) {
        echo "Dados dos pacientes inseridos com sucesso!";
    } else {
        echo "Erro ao inserir dados dos pacientes: " . $conn->error;
    }
} else {
    echo "Erro ao inserir dados dos resultados de exames: " . $conn->error;
}

$conn->close();
?>