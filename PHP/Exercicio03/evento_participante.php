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

// Inserir dados na tabela eventos
$sql_eventos = "INSERT INTO eventos (id_evento, nome_evento, data) VALUES 
                (1, 'Conferência de Tecnologia', '2023-12-15'),
                (2, 'Workshop de Marketing Digital', '2023-11-20')";

if ($conn->multi_query($sql_eventos) === TRUE) {
    echo "Dados dos eventos inseridos com sucesso!<br>";

    // Inserir dados na tabela participantes
    $sql_participantes = "INSERT INTO participantes (id_participante, id_evento, nome_participante) VALUES 
                        (1, 1, 'Gabriel'),
                        (2, 2, 'Sofia')";

    if ($conn->multi_query($sql_participantes) === TRUE) {
        echo "Dados dos participantes inseridos com sucesso!";
    } else {
        echo "Erro ao inserir dados dos participantes: " . $conn->error;
    }
} else {
    echo "Erro ao inserir dados dos eventos: " . $conn->error;
}

$conn->close();
?>