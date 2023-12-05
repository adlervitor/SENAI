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

$id_livro_a_excluir = 1; // Altere para o ID do livro que deseja excluir

$conn->autocommit(FALSE);

$sql_delete_autores_livro = "DELETE FROM autores WHERE id_autor IN 
                            (SELECT id_autor FROM livros_autores WHERE id_livro = $id_livro_a_excluir)";
if ($conn->query($sql_delete_autores_livro) === TRUE) {
    $sql_delete_livro = "DELETE FROM livros WHERE id_livro = $id_livro_a_excluir";
    if ($conn->query($sql_delete_livro) === TRUE) {
        $conn->commit();
        echo "Livro e associações com autores removidos com sucesso!";
    } else {
        $conn->rollback();
        echo "Erro ao excluir livro: " . $conn->error;
    }
} else {
    $conn->rollback();
    echo "Erro ao excluir associações do livro com autores: " . $conn->error;
}

$conn->close();
?>