<!DOCTYPE html>
<html>
<head>
    <title>Gestão de Pessoas</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <h1>Gestão de Pessoas</h1>

    <h2>Inserir nova pessoa</h2>
    <form method="post" action="">
        <label for="nome">Nome:</label>
        <input type="text" name="nome" id="nome"><br>
        <label for="idade">Idade:</label>
        <input type="text" name="idade" id="idade"><br>
        <label for="rua">Rua:</label>
        <input type="text" name="rua" id="rua"><br>
        <label for="cidade">Cidade:</label>
        <input type="text" name="cidade" id="cidade"><br>
        <label for="numero">Número de Telefone:</label>
        <input type="text" name="numero" id="numero"><br>
        <label for="tipo">Tipo de Telefone:</label>
        <input type="text" name="tipo" id="tipo"><br>
        <label for="descricao">Descrição do Pedido:</label>
        <input type="text" name="descricao" id="descricao"><br>
        <label for="valor">Valor do Pedido:</label>
        <input type="text" name="valor" id="valor"><br>
        <input type="submit" name="action" value="Inserir">
    </form>

    <h2>Consultar Detalhes de Compras de uma Pessoa</h2>
    <form method="post" action="">
        <label for="idPessoaDetalhes">ID da Pessoa:</label>
        <input type="text" name="idPessoaDetalhes" id="idPessoaDetalhes">
        <input type="submit" name="action" value="Consultar Detalhes">
    </form>

    <h2>Atualizar Detalhes de uma Pessoa</h2>
    <form method="post" action="">
        <label for="idPessoaAtualizar">ID da Pessoa:</label>
        <input type="text" name="idPessoaAtualizar" id="idPessoaAtualizar"><br>
        <label for="novoNome">Novo Nome:</label>
        <input type="text" name="novoNome" id="novoNome"><br>
        <label for="novaIdade">Nova Idade:</label>
        <input type="text" name="novaIdade" id="novaIdade"><br>
        <label for="novoEnderecoRua">Nova Rua:</label>
        <input type="text" name="novoEnderecoRua" id="novoEnderecoRua"><br>
        <label for="novoEnderecoCidade">Nova Cidade:</label>
        <input type="text" name="novoEnderecoCidade" id="novoEnderecoCidade"><br>
        <label for="novoTelefoneNumero">Novo Número de Telefone:</label>
        <input type="text" name="novoTelefoneNumero" id="novoTelefoneNumero"><br>
        <label for="novoTelefoneTipo">Novo Tipo de Telefone:</label>
        <input type="text" name="novoTelefoneTipo" id="novoTelefoneTipo"><br>
        <input type="submit" name="action" value="Atualizar">
    </form>

    <h2>Excluir Pessoa e seus Dados Relacionados</h2>
    <form method="post" action="">
        <label for="idPessoaExcluir">ID da Pessoa a Excluir:</label>
        <input type="text" name="idPessoaExcluir" id="idPessoaExcluir">
        <input type="submit" name="action" value="Excluir">
    </form>

    <h2>Obter Pessoas de uma Cidade</h2>
    <form method="post" action="">
        <label for="cidade">Cidade:</label>
        <input type="text" name="cidade" id="cidade">
        <input type="submit" name="action" value="Obter Pessoas">
    </form>

    <h2>Atualizar Endereço de uma Pessoa</h2>
    <form method="post" action="">
        <label for="idPessoaAtualizarEndereco">ID da Pessoa:</label>
        <input type="text" name="idPessoaAtualizarEndereco" id="idPessoaAtualizarEndereco"><br>
        <label for="novaRua">Nova Rua:</label>
        <input type="text" name="novaRua" id="novaRua"><br>
        <label for="novaCidade">Nova Cidade:</label>
        <input type="text" name="novaCidade" id="novaCidade"><br>
        <input type="submit" name="action" value="Atualizar Endereço">
    </form>

    <h2>Excluir Telefone Específico</h2>
    <form method="post" action="">
        <label for="idTelefoneExcluir">ID do Telefone a Excluir:</label>
        <input type="text" name="idTelefoneExcluir" id="idTelefoneExcluir">
        <input type="submit" name="action" value="Excluir Telefone">
    </form>

    <h2>Obter Pedidos de Valor Maior</h2>
    <form method="post" action="">
        <label for="idPessoaPedidos">ID da Pessoa:</label>
        <input type="text" name="idPessoaPedidos" id="idPessoaPedidos"><br>
        <label for="valorMinimo">Valor Mínimo:</label>
        <input type="text" name="valorMinimo" id="valorMinimo"><br>
        <input type="submit" name="action" value="Obter Pedidos">
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

            if ($action === 'Inserir') {
                $nome = $_POST['nome'];
                $idade = $_POST['idade'];
                $rua = $_POST['rua'];
                $cidade = $_POST['cidade'];
                $numero = $_POST['numero'];
                $tipo = $_POST['tipo'];
                $descricao = $_POST['descricao'];
                $valor = $_POST['valor'];

                inserirPessoa($nome, $idade, $rua, $cidade, $numero, $tipo, $descricao, $valor, $conn);
                echo "<p>Pessoa inserida com sucesso!</p>";
            } elseif ($action === 'Inserir'){

            }


        }
    }
    ?>
</body>
</html>
