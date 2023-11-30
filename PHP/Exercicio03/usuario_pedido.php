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

$nome_usuario = "João";
$email_usuario = "joao@example.com";

$sql_usuario = "INSERT INTO usuarios (nome, email) VALUES ('$nome_usuario', '$email_usuario')";

if ($conn->query($sql_usuario) === TRUE) {
    $id_usuario = $conn->insert_id;

    $produto = "Produto A";
    $quantidade = 2;

    $sql_pedido = "INSERT INTO pedidos (id_usuario, produto, quantidade) VALUES ('$id_usuario', '$produto', '$quantidade')";

    if ($conn->query($sql_pedido) === TRUE) {
        echo "Novo usuário e pedido registrados com sucesso!";
    } else {
        echo "Erro ao registrar o pedido: " . $conn->error;
    }
} else {
    echo "Erro ao registrar o usuário: " . $conn->error;
}

$conn->close();
?>
