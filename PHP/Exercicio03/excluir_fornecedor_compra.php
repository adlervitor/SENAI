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

$id_fornecedor_a_excluir = 1; // Altere para o ID do fornecedor que deseja excluir

$conn->autocommit(FALSE);

$sql_delete_compras = "DELETE FROM compras WHERE id_fornecedor = $id_fornecedor_a_excluir";
if ($conn->query($sql_delete_compras) === TRUE) {
    $sql_delete_fornecedor = "DELETE FROM fornecedores WHERE id_fornecedor = $id_fornecedor_a_excluir";
    if ($conn->query($sql_delete_fornecedor) === TRUE) {
        $conn->commit();
        echo "Fornecedor e registros de compras associados removidos com sucesso!";
    } else {
        $conn->rollback();
        echo "Erro ao excluir fornecedor: " . $conn->error;
    }
} else {
    $conn->rollback();
    echo "Erro ao excluir registros de compras do fornecedor: " . $conn->error;
}

$conn->close();
?>