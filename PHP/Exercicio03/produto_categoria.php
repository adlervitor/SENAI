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

$nome_produto = "Produto A";
$preco_produto = 49.99;

$sql_produto = "INSERT INTO produtos (nome_produto, preco) VALUES ('$nome_produto', '$preco_produto')";

if ($conn->query($sql_produto) === TRUE) {
    $id_produto = $conn->insert_id;

    $nome_categoria = "Eletrônicos";

    $sql_check_category = "SELECT id_categoria FROM categorias WHERE nome_categoria = '$nome_categoria'";
    $result_check_category = $conn->query($sql_check_category);

    if ($result_check_category->num_rows > 0) {
        $row = $result_check_category->fetch_assoc();
        $id_categoria = $row["id_categoria"];
    } else {
        $sql_insert_category = "INSERT INTO categorias (nome_categoria) VALUES ('$nome_categoria')";
        if ($conn->query($sql_insert_category) === TRUE) {
            $id_categoria = $conn->insert_id;
        } else {
            echo "Erro ao adicionar nova categoria: " . $conn->error;
            exit();
        }
    }

    $sql_associate_category = "INSERT INTO produtos_categorias (id_produto, id_categoria) VALUES ('$id_produto', '$id_categoria')";

    if ($conn->query($sql_associate_category) === TRUE) {
        echo "Produto adicionado e associado à categoria com sucesso!";
    } else {
        echo "Erro ao associar produto à categoria: " . $conn->error;
    }
} else {
    echo "Erro ao adicionar produto: " . $conn->error;
}

$conn->close();
?>
