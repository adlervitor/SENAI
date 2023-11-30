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

$nome_cliente = "João";
$email_cliente = "joao@example.com";

$sql_cliente = "INSERT INTO clientes (nome, email) VALUES ('$nome_cliente', '$email_cliente')";

if ($conn->query($sql_cliente) === TRUE) {
    $id_cliente = $conn->insert_id;

    $produto_vendido = "Produto XYZ";
    $valor_venda = 99.99;

    $sql_venda = "INSERT INTO vendas (id_cliente, produto_vendido, valor) VALUES ('$id_cliente', '$produto_vendido', '$valor_venda')";

    if ($conn->query($sql_venda) === TRUE) {
        echo "Novo cliente registrado e venda registrada com sucesso!";
    } else {
        echo "Erro ao registrar a venda: " . $conn->error;
    }
} else {
    echo "Erro ao registrar o cliente: " . $conn->error;
}

$conn->close();
?>