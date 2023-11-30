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

$titulo_livro = "Livro ABC";
$ano_publicacao = 2022;

$sql_livro = "INSERT INTO livros (titulo, ano_publicacao) VALUES ('$titulo_livro', '$ano_publicacao')";

if ($conn->query($sql_livro) === TRUE) {
    $id_livro = $conn->insert_id;

    $nome_autor = "Autor XYZ";

    $sql_autor = "INSERT INTO autores (nome_autor) VALUES ('$nome_autor')";

    if ($conn->query($sql_autor) === TRUE) {
        $id_autor = $conn->insert_id;

        $sql_associate_author = "INSERT INTO livros_autores (id_livro, id_autor) VALUES ('$id_livro', '$id_autor')";

        if ($conn->query($sql_associate_author) === TRUE) {
            echo "Novo livro registrado e autor associado ao livro com sucesso!";
        } else {
            echo "Erro ao associar autor ao livro: " . $conn->error;
        }
    } else {
        echo "Erro ao adicionar detalhes do autor: " . $conn->error;
    }
} else {
    echo "Erro ao registrar o livro: " . $conn->error;
}

$conn->close();
?>
