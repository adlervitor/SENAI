create database senaidb;
use senaidb;

CREATE TABLE usuarios (
    id_usuario INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL
);

CREATE TABLE pedidos (
    id_pedido INT AUTO_INCREMENT PRIMARY KEY,
    id_usuario INT NOT NULL,
    produto VARCHAR(50) NOT NULL,
    quantidade INT NOT NULL,
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario)
);

CREATE TABLE produtos (
    id_produto INT AUTO_INCREMENT PRIMARY KEY,
    nome_produto VARCHAR(100) NOT NULL,
    preco DECIMAL(10, 2) NOT NULL
);

CREATE TABLE categorias (
    id_categoria INT AUTO_INCREMENT PRIMARY KEY,
    nome_categoria VARCHAR(50) NOT NULL
);

CREATE TABLE produtos_categorias (
    id_produto_categoria INT AUTO_INCREMENT PRIMARY KEY,
    id_produto INT,
    id_categoria INT,
    FOREIGN KEY (id_produto) REFERENCES produtos(id_produto),
    FOREIGN KEY (id_categoria) REFERENCES categorias(id_categoria)
);

CREATE TABLE funcionarios (
    id_funcionario INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cargo VARCHAR(100) NOT NULL
);

CREATE TABLE departamentos (
    id_departamento INT AUTO_INCREMENT PRIMARY KEY,
    nome_departamento VARCHAR(100) NOT NULL
);

CREATE TABLE projetos (
    id_projeto INT AUTO_INCREMENT PRIMARY KEY,
    nome_projeto VARCHAR(100) NOT NULL,
    descricao TEXT
);

CREATE TABLE atribuicoes (
    id_atribuicao INT AUTO_INCREMENT PRIMARY KEY,
    id_projeto INT NOT NULL,
    id_funcionario INT NOT NULL,
    FOREIGN KEY (id_projeto) REFERENCES projetos(id_projeto),
    FOREIGN KEY (id_funcionario) REFERENCES funcionarios(id_funcionario)
);

CREATE TABLE alunos (
    id_aluno INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    turma VARCHAR(50) NOT NULL
);

CREATE TABLE cursos (
    id_curso INT AUTO_INCREMENT PRIMARY KEY,
    nome_curso VARCHAR(100) NOT NULL,
    instrutor VARCHAR(100) NOT NULL
);

CREATE TABLE fornecedores (
    id_fornecedor INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    contato VARCHAR(100) NOT NULL
);

CREATE TABLE compras (
    id_compra INT AUTO_INCREMENT PRIMARY KEY,
    id_fornecedor INT NOT NULL,
    produto_comprado VARCHAR(100) NOT NULL,
    quantidade INT NOT NULL,
    FOREIGN KEY (id_fornecedor) REFERENCES fornecedores(id_fornecedor)
);

CREATE TABLE livros (
    id_livro INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(100) NOT NULL,
    ano_publicacao INT NOT NULL
);

CREATE TABLE autores (
    id_autor INT AUTO_INCREMENT PRIMARY KEY,
    nome_autor VARCHAR(100) NOT NULL
);

CREATE TABLE eventos (
    id_evento INT AUTO_INCREMENT PRIMARY KEY,
    nome_evento VARCHAR(100) NOT NULL,
    data DATE NOT NULL
);

CREATE TABLE participantes (
    id_participante INT AUTO_INCREMENT PRIMARY KEY,
    id_evento INT NOT NULL,
    nome_participante VARCHAR(100) NOT NULL,
    FOREIGN KEY (id_evento) REFERENCES eventos(id_evento)
);

CREATE TABLE resultados_exames (
    id_resultado INT AUTO_INCREMENT PRIMARY KEY,
    tipo_exame VARCHAR(100) NOT NULL,
    resultado TEXT NOT NULL
);

CREATE TABLE pacientes (
    id_paciente INT AUTO_INCREMENT PRIMARY KEY,
    nome_paciente VARCHAR(100) NOT NULL,
    data_nascimento DATE NOT NULL
);