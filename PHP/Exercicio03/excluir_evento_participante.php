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

$id_evento_a_excluir = 1; // Altere para o ID do evento que deseja excluir

$conn->autocommit(FALSE);

$sql_delete_participantes = "DELETE FROM participantes WHERE id_evento = $id_evento_a_excluir";
if ($conn->query($sql_delete_participantes) === TRUE) {
    $sql_delete_evento = "DELETE FROM eventos WHERE id_evento = $id_evento_a_excluir";
    if ($conn->query($sql_delete_evento) === TRUE) {
        $conn->commit();
        echo "Evento e participantes associados removidos com sucesso!";
    } else {
        $conn->rollback();
        echo "Erro ao excluir evento: " . $conn->error;
    }
} else {
    $conn->rollback();
    echo "Erro ao excluir participantes do evento: " . $conn->error;
}

$conn->close();
?>