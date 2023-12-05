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

$id_funcionario_a_excluir = 1; // Altere para o ID do funcionário que deseja excluir

$conn->autocommit(FALSE);

$sql_delete_departamentos = "DELETE FROM departamentos WHERE id_departamento IN 
                            (SELECT id_departamento FROM funcionarios WHERE id_funcionario = $id_funcionario_a_excluir)";
if ($conn->query($sql_delete_departamentos) === TRUE) {
    $sql_delete_funcionario = "DELETE FROM funcionarios WHERE id_funcionario = $id_funcionario_a_excluir";
    if ($conn->query($sql_delete_funcionario) === TRUE) {
        $conn->commit();
        echo "Funcionário e suas associações com departamentos removidos com sucesso!";
    } else {
        $conn->rollback();
        echo "Erro ao excluir funcionário: " . $conn->error;
    }
} else {
    $conn->rollback();
    echo "Erro ao excluir associações do funcionário com departamentos: " . $conn->error;
}

$conn->close();
?>