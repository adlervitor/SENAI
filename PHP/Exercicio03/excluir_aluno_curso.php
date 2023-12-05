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

$id_aluno_a_excluir = 1; // Altere para o ID do aluno que deseja excluir

$conn->autocommit(FALSE);

$sql_delete_cursos = "DELETE FROM cursos WHERE id_curso IN 
                        (SELECT id_curso FROM alunos WHERE id_aluno = $id_aluno_a_excluir)";
if ($conn->query($sql_delete_cursos) === TRUE) {
    $sql_delete_aluno = "DELETE FROM alunos WHERE id_aluno = $id_aluno_a_excluir";
    if ($conn->query($sql_delete_aluno) === TRUE) {
        $conn->commit();
        echo "Aluno e suas associações com cursos removidos com sucesso!";
    } else {
        $conn->rollback();
        echo "Erro ao excluir aluno: " . $conn->error;
    }
} else {
    $conn->rollback();
    echo "Erro ao excluir associações do aluno com cursos: " . $conn->error;
}

$conn->close();
?>