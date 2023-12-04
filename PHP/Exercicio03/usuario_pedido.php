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

// Inserir dados na tabela usuarios
$sql_usuarios = "INSERT INTO usuarios (id_usuario, nome, email) VALUES 
                    (3, 'Eduardo', 'eduardo@example.com'),
                    (4, 'Laura', 'laura@example.com')";

if ($conn->multi_query($sql_usuarios) === TRUE) {
    echo "Dados dos usuários inseridos com sucesso!<br>";

    // Inserir dados na tabela pedidos
    $sql_pedidos = "INSERT INTO pedidos (id_pedido, id_usuario, produto, quantidade) VALUES 
                    (3, 3, 'Livro de Ficção', 3),
                    (4, 4, 'Fones de Ouvido', 1)";

    if ($conn->multi_query($sql_pedidos) === TRUE) {
        echo "Dados dos pedidos inseridos com sucesso!";
    } else {
        echo "Erro ao inserir dados dos pedidos: " . $conn->error;
    }
} else {
    echo "Erro ao inserir dados dos usuários: " . $conn->error;
}

$conn->close();
?>