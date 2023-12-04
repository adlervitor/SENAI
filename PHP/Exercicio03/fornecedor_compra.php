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

// Inserir dados na tabela fornecedores
$sql_fornecedores = "INSERT INTO fornecedores (id_fornecedor, nome, contato) VALUES 
                    (1, 'Empresa A', 'contato@empresaA.com'),
                    (2, 'Empresa B', 'contato@empresaB.com')";

if ($conn->multi_query($sql_fornecedores) === TRUE) {
    echo "Dados dos fornecedores inseridos com sucesso!<br>";

    // Inserir dados na tabela compras
    $sql_compras = "INSERT INTO compras (id_compra, id_fornecedor, produto_comprado, quantidade) VALUES 
                    (1, 1, 'Peças de computador', 100),
                    (2, 2, 'Material de escritório', 500)";

    if ($conn->multi_query($sql_compras) === TRUE) {
        echo "Dados das compras inseridos com sucesso!";
    } else {
        echo "Erro ao inserir dados das compras: " . $conn->error;
    }
} else {
    echo "Erro ao inserir dados dos fornecedores: " . $conn->error;
}

$conn->close();
?>