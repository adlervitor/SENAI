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

$tipo_exame = "Exame de Sangue";
$resultado = "Resultado do exame de sangue...";

$sql_exame = "INSERT INTO resultados_exames (tipo_exame, resultado) VALUES ('$tipo_exame', '$resultado')";

if ($conn->query($sql_exame) === TRUE) {
    $id_resultado = $conn->insert_id;

    $nome_paciente = "Maria Silva";
    $data_nascimento = "1990-05-15";

    $sql_paciente = "INSERT INTO pacientes (nome_paciente, data_nascimento) VALUES ('$nome_paciente', '$data_nascimento')";

    if ($conn->query($sql_paciente) === TRUE) {
        $id_paciente = $conn->insert_id;

        $sql_associate_patient = "INSERT INTO resultados_pacientes (id_resultado, id_paciente) VALUES ('$id_resultado', '$id_paciente')";

        if ($conn->query($sql_associate_patient) === TRUE) {
            echo "Novo resultado de exame registrado e paciente associado ao resultado com sucesso!";
        } else {
            echo "Erro ao associar paciente ao resultado de exame: " . $conn->error;
        }
    } else {
        echo "Erro ao registrar o paciente: " . $conn->error;
    }
} else {
    echo "Erro ao registrar o resultado de exame: " . $conn->error;
}

$conn->close();
?>
