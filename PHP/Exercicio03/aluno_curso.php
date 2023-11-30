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

$nome_aluno = "Maria Oliveira";
$turma_aluno = "Turma A";

$sql_aluno = "INSERT INTO alunos (nome, turma) VALUES ('$nome_aluno', '$turma_aluno')";

if ($conn->query($sql_aluno) === TRUE) {
    $id_aluno = $conn->insert_id;

    $nome_curso = "Curso de Matemática";
    $instrutor_curso = "Prof. Silva";

    $sql_curso = "INSERT INTO cursos (nome_curso, instrutor) VALUES ('$nome_curso', '$instrutor_curso')";

    if ($conn->query($sql_curso) === TRUE) {
        $id_curso = $conn->insert_id;

        $sql_associate_course = "INSERT INTO alunos_cursos (id_aluno, id_curso) VALUES ('$id_aluno', '$id_curso')";

        if ($conn->query($sql_associate_course) === TRUE) {
            echo "Novo aluno registrado e matriculado no curso com sucesso!";
        } else {
            echo "Erro ao matricular aluno no curso: " . $conn->error;
        }
    } else {
        echo "Erro ao adicionar detalhes do curso: " . $conn->error;
    }
} else {
    echo "Erro ao registrar o aluno: " . $conn->error;
}

$conn->close();
?>
