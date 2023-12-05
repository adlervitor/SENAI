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

$id_produto_a_excluir = 3; // Altere para o ID do produto que deseja excluir

$conn->autocommit(FALSE);

$sql_delete_produtos_categorias = "DELETE FROM produtos_categorias WHERE id_produto = $id_produto_a_excluir";
if ($conn->query($sql_delete_produtos_categorias) === TRUE) {
    $sql_delete_produto = "DELETE FROM produtos WHERE id_produto = $id_produto_a_excluir";
    if ($conn->query($sql_delete_produto) === TRUE) {
        $conn->commit();
        echo "Produto e associações com categorias removidos com sucesso!";
    } else {
        $conn->rollback();
        echo "Erro ao excluir produto: " . $conn->error;
    }
} else {
    $conn->rollback();
    echo "Erro ao excluir associações do produto com categorias: " . $conn->error;
}

$conn->close();
?>