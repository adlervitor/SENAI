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

// Inserindo dados na tabela clientes
$sql_clientes = "INSERT INTO clientes (id_cliente, nome, email) VALUES 
                (1, 'Ana', 'ana@example.com'),
                (2, 'Pedro', 'pedro@example.com')";

if ($conn->multi_query($sql_clientes) === TRUE) {
    echo "Dados dos clientes inseridos com sucesso!<br>";

    // Inserindo dados na tabela vendas
    $sql_venda_1 = "INSERT INTO vendas (id_venda, id_cliente, produto_vendido, valor) VALUES (1, 1, 'Celular', 1200.00)";
    $sql_venda_2 = "INSERT INTO vendas (id_venda, id_cliente, produto_vendido, valor) VALUES (2, 2, 'Fones', 150.00)";

    if ($conn->query($sql_venda_1) === TRUE && $conn->query($sql_venda_2) === TRUE) {
        echo "Dados das vendas inseridos com sucesso!";
    } else {
        echo "Erro ao inserir dados das vendas: " . $conn->error;
    }
} else {
    echo "Erro ao inserir dados dos clientes: " . $conn->error;
}

$conn->close();
?>