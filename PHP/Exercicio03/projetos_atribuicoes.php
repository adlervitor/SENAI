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

$nome_projeto = "Projeto XYZ";
$descricao_projeto = "Descrição do Projeto XYZ";

$sql_projeto = "INSERT INTO projetos (nome_projeto, descricao) VALUES ('$nome_projeto', '$descricao_projeto')";

if ($conn->query($sql_projeto) === TRUE) {
    $id_projeto = $conn->insert_id; 

    $id_funcionario = 1;
    $sql_associate_assignment = "INSERT INTO atribuicoes (id_projeto, id_funcionario) VALUES ('$id_projeto', '$id_funcionario')";

    if ($conn->query($sql_associate_assignment) === TRUE) {
        echo "Novo projeto registrado e funcionário associado ao projeto com sucesso!";
    } else {
        echo "Erro ao associar funcionário ao projeto: " . $conn->error;
    }
} else {
    echo "Erro ao registrar o projeto: " . $conn->error;
}

$conn->close();
?>
