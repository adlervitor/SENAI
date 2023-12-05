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

$id_resultado_a_excluir = 1; // Altere para o ID do resultado de exame que deseja excluir

$conn->autocommit(FALSE);

$sql_delete_pacientes = "DELETE FROM pacientes WHERE id_paciente IN 
                            (SELECT id_paciente FROM resultados_exames WHERE id_resultado = $id_resultado_a_excluir)";
if ($conn->query($sql_delete_pacientes) === TRUE) {
    $sql_delete_resultado = "DELETE FROM resultados_exames WHERE id_resultado = $id_resultado_a_excluir";
    if ($conn->query($sql_delete_resultado) === TRUE) {
        $conn->commit();
        echo "Resultado de exame e dados do paciente associados removidos com sucesso!";
    } else {
        $conn->rollback();
        echo "Erro ao excluir resultado de exame: " . $conn->error;
    }
} else {
    $conn->rollback();
    echo "Erro ao excluir dados do paciente associados ao resultado de exame: " . $conn->error;
}

$conn->close();
?>