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

$nome_fornecedor = "Fornecedor XYZ";
$contato_fornecedor = "FornecedorXYZ@example.com";

$sql_fornecedor = "INSERT INTO fornecedores (nome, contato) VALUES ('$nome_fornecedor', '$contato_fornecedor')";

if ($conn->query($sql_fornecedor) === TRUE) {
    $id_fornecedor = $conn->insert_id;

    $produto_comprado = "Produto ABC";
    $quantidade_comprada = 50;

    $sql_compra = "INSERT INTO compras (id_fornecedor, produto_comprado, quantidade) VALUES ('$id_fornecedor', '$produto_comprado', '$quantidade_comprada')";

    if ($conn->query($sql_compra) === TRUE) {
        echo "Novo fornecedor registrado e compra registrada com sucesso!";
    } else {
        echo "Erro ao registrar a compra: " . $conn->error;
    }
} else {
    echo "Erro ao registrar o fornecedor: " . $conn->error;
}

$conn->close();
?>
