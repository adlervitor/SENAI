<!DOCTYPE html>
<html>
<head>
    <title>Menu de Operações</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <h1>Menu de Operações</h1>
    <form method="post" action="">
        <button type="submit" name="action" value="listar_pessoas">Listar todas as pessoas</button>
        <button type="submit" name="action" value="contar_pessoas">Contar total de pessoas</button>
    </form>

    <h2>Adicionar nova pessoa</h2>
    <form method="post" action="">
        <label for="nome">Nome:</label>
        <input type="text" name="nome" id="nome"><br>
        <label for="idade">Idade:</label>
        <input type="text" name="idade" id="idade"><br>
        <label for="sexo">Sexo:</label>
        <input type="text" name="sexo" id="sexo"><br>
        <input type="submit" name="action" value="Adicionar">
    </form> 

    <h2>Buscar pessoa por ID</h2>
    <form method="post" action="">
        <label for="id">ID da pessoa:</label>
        <input type="text" name="id" id="id">
        <input type="submit" name="action" value="Buscar">
    </form>

    <h2>Atualizar dados de uma pessoa por ID</h2>
    <form method="post" action="">
        <label for="id_update">ID da pessoa:</label>
        <input type="text" name="id" id="id_update"><br>
        <label for="nome">Novo nome:</label>
        <input type="text" name="nome" id="nome"><br>
        <label for="idade">Nova idade:</label>
        <input type="text" name="idade" id="idade"><br>
        <label for="sexo">Novo sexo:</label>
        <input type="text" name="sexo" id="sexo"><br>
        <input type="submit" name="action" value="Atualizar">
    </form>

    <?php
    $servername = "localhost";
    $username = "root";
    $password = "1234";
    $dbname = "senaidb";

    $conn = new mysqli($servername, $username, $password, $dbname);
    if ($conn->connect_error) {
        die("Conexão falhou: " . $conn->connect_error);
    }

    if ($_SERVER['REQUEST_METHOD'] === 'POST') {
        if (isset($_POST['action'])) {
            $action = $_POST['action'];
            if ($action === 'listar_pessoas') {
                $data = getAllPessoas($conn);
                formatarDadosPessoas($data);
            } elseif ($action === 'contar_pessoas') {
                $quantidade = getTotalPessoas($conn);
                echo "Total de registros na tabela pessoas: " . $quantidade;
            } elseif ($action === 'Buscar') {
                $id = $_POST['id'];
                $pessoa = getPessoaById($conn, $id);
                formatarDadosPessoas($pessoa);
            } elseif ($action === 'Atualizar') {
                if (isset($_POST['id'], $_POST['nome'], $_POST['idade'], $_POST['sexo'])) {
                    $id = $_POST['id'];
                    $nome = $_POST['nome'];
                    $idade = $_POST['idade'];
                    $sexo = $_POST['sexo'];
                    $resultado = updatePessoaById($conn, $id, $nome, $idade, $sexo);
                    echo $resultado;
                } else {
                    echo "Por favor, preencha todos os campos para atualizar a pessoa.";
                }
            } elseif ($action === 'Adicionar') {
                if (isset($_POST['nome'], $_POST['idade'], $_POST['sexo'])) {
                    $nome = $_POST['nome'];
                    $idade = $_POST['idade'];
                    $sexo = $_POST['sexo'];
                    
                    $resultado = adicionarPessoa($conn, $nome, $idade, $sexo);
                    echo $resultado;
                } else {
                    echo "Por favor, preencha todos os campos para adicionar uma pessoa.";
                }
            }
        }
    }

    $conn->close();

    function getAllPessoas($conn) {
        $sql = "SELECT * FROM pessoas";
        $result = $conn->query($sql);

        if ($result->num_rows > 0) {
            return $result->fetch_all(MYSQLI_ASSOC);
        } else {
            return "Nenhum resultado encontrado";
        }
    }

    function getTotalPessoas($conn) {
        $sql = "SELECT COUNT(*) as total FROM pessoas";
        $result = $conn->query($sql);

        if ($result->num_rows > 0) {
            $row = $result->fetch_assoc();
            return $row['total'];
        } else {
            return 0;
        }
    }

    function getPessoaById($conn, $id) {
        $sql = "SELECT * FROM pessoas WHERE id = $id";
        $result = $conn->query($sql);

        if ($result->num_rows > 0) {
            return $result->fetch_assoc();
        } else {
            return "Nenhum resultado encontrado para o ID fornecido";
        }
    }

    function updatePessoaById($conn, $id, $nome, $idade, $sexo) {
        $sql = "UPDATE pessoas SET nome = '$nome', idade = $idade, sexo = '$sexo' WHERE id = $id";
        $result = $conn->query($sql);

        if ($result === TRUE) {
            return "Registro atualizado com sucesso";
        } else {
            return "Erro ao atualizar registro: " . $conn->error;
        }
    }
    function formatarDadosPessoas($pessoas) {
        if (is_array($pessoas) && count($pessoas) > 0) {
            echo "<h2>Dados das Pessoas</h2>";
            echo "<table border='1'>";
            echo "<tr><th>ID</th><th>Nome</th><th>Idade</th><th>Sexo</th></tr>";
    
            if (array_key_exists('id', $pessoas)) {
                echo "<tr>";
                echo "<td>" . $pessoas['id'] . "</td>";
                echo "<td>" . $pessoas['nome'] . "</td>";
                echo "<td>" . $pessoas['idade'] . "</td>";
                echo "<td>" . $pessoas['sexo'] . "</td>";
                echo "</tr>";
            } else {
                foreach ($pessoas as $pessoa) {
                    echo "<tr>";
                    echo "<td>" . $pessoa['id'] . "</td>";
                    echo "<td>" . $pessoa['nome'] . "</td>";
                    echo "<td>" . $pessoa['idade'] . "</td>";
                    echo "<td>" . $pessoa['sexo'] . "</td>";
                    echo "</tr>";
                }
            }
            echo "</table>";
        } else {
            echo "<p>Nenhum resultado encontrado.</p>";
        }
    }

    function adicionarPessoa($conn, $nome, $idade, $sexo) {
        $sql = "INSERT INTO pessoas (nome, idade, sexo) VALUES ('$nome', $idade, '$sexo')";
        if ($conn->query($sql) === TRUE) {
            return "Nova pessoa adicionada com sucesso";
        } else {
            return "Erro ao adicionar pessoa: " . $conn->error;
        }
    } 
    ?>
</body>
</html>
