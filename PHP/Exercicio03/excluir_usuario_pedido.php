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

$id_usuario_a_excluir = 3;

$conn->autocommit(FALSE);

$sql_delete_pedidos = "DELETE FROM pedidos WHERE id_usuario = $id_usuario_a_excluir";
if ($conn->query($sql_delete_pedidos) === TRUE) {
    $sql_delete_usuario = "DELETE FROM usuarios WHERE id_usuario = $id_usuario_a_excluir";
    if ($conn->query($sql_delete_usuario) === TRUE) {
        $conn->commit();
        echo "Usuário e pedidos associados removidos com sucesso!";
    } else {
        $conn->rollback();
        echo "Erro ao excluir usuário: " . $conn->error;
    }
} else {
    $conn->rollback();
    echo "Erro ao excluir pedidos: " . $conn->error;
}

$conn->close();
?>