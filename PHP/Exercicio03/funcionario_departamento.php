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

$nome_funcionario = "Maria Silva";
$cargo_funcionario = "Analista";

$sql_funcionario = "INSERT INTO funcionarios (nome, cargo) VALUES ('$nome_funcionario', '$cargo_funcionario')";

if ($conn->query($sql_funcionario) === TRUE) {
    $id_funcionario = $conn->insert_id;

    $nome_departamento = "TI";

    $sql_check_department = "SELECT id_departamento FROM departamentos WHERE nome_departamento = '$nome_departamento'";
    $result_check_department = $conn->query($sql_check_department);

    if ($result_check_department->num_rows > 0) {
        $row = $result_check_department->fetch_assoc();
        $id_departamento = $row["id_departamento"];
    } else {
        $sql_insert_department = "INSERT INTO departamentos (nome_departamento) VALUES ('$nome_departamento')";
        if ($conn->query($sql_insert_department) === TRUE) {
            $id_departamento = $conn->insert_id;
        } else {
            echo "Erro ao adicionar novo departamento: " . $conn->error;
            exit();
        }
    }

    $sql_associate_department = "INSERT INTO funcionarios_departamentos (id_funcionario, id_departamento) VALUES ('$id_funcionario', '$id_departamento')";

    if ($conn->query($sql_associate_department) === TRUE) {
        echo "Novo funcionário registrado e associado ao departamento com sucesso!";
    } else {
        echo "Erro ao associar funcionário ao departamento: " . $conn->error;
    }
} else {
    echo "Erro ao registrar o funcionário: " . $conn->error;
}

$conn->close();
?>
