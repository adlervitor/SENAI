<?php
//Adler Vitor Santiago B.
$servername = "localhost";
$username = "root";
$password = "1234";
$dbname = "senaidb";

$conn = new mysqli($servername, $username, $password, $dbname);

if ($conn->connect_error) {
    die("Conexão falhou: " . $conn->connect_error);
}

$nome_evento = "Evento ABC";
$data_evento = "2023-12-31";

$sql_evento = "INSERT INTO eventos (nome_evento, data) VALUES ('$nome_evento', '$data_evento')";

if ($conn->query($sql_evento) === TRUE) {
    $id_evento = $conn->insert_id;

    $nome_participante = "João Silva";

    $sql_participante = "INSERT INTO participantes (id_evento, nome_participante) VALUES ('$id_evento', '$nome_participante')";

    if ($conn->query($sql_participante) === TRUE) {
        echo "Novo evento registrado e participante do evento adicionado com sucesso!";
    } else {
        echo "Erro ao adicionar participante ao evento: " . $conn->error;
    }
} else {
    echo "Erro ao registrar o evento: " . $conn->error;
}

$conn->close();
?>
