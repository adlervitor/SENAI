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

$id_cliente_a_excluir = 1; // Altere para o ID do cliente que deseja excluir

$conn->autocommit(FALSE);

$sql_delete_vendas = "DELETE FROM vendas WHERE id_cliente = $id_cliente_a_excluir";
if ($conn->query($sql_delete_vendas) === TRUE) {
    $sql_delete_cliente = "DELETE FROM clientes WHERE id_cliente = $id_cliente_a_excluir";
    if ($conn->query($sql_delete_cliente) === TRUE) {
        $conn->commit();
        echo "Cliente e vendas associadas removidos com sucesso!";
    } else {
        $conn->rollback();
        echo "Erro ao excluir cliente: " . $conn->error;
    }
} else {
    $conn->rollback();
    echo "Erro ao excluir vendas do cliente: " . $conn->error;
}

$conn->close();
?>