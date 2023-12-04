CREATE DATABASE senaidb;
USE senaidb;

CREATE TABLE pessoas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100),
    idade INT,
    outros_dados TEXT
);

CREATE TABLE enderecos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    rua VARCHAR(255),
    cidade VARCHAR(100),
    id_pessoa INT,
    FOREIGN KEY (id_pessoa) REFERENCES pessoas(id)
);

CREATE TABLE telefones (
    id INT AUTO_INCREMENT PRIMARY KEY,
    numero VARCHAR(20),
    tipo VARCHAR(50),
    id_pessoa INT,
    FOREIGN KEY (id_pessoa) REFERENCES pessoas(id)
);

CREATE TABLE pedidos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    descricao VARCHAR(255),
    valor DECIMAL(10, 2),
    id_pessoa INT,
    FOREIGN KEY (id_pessoa) REFERENCES pessoas(id)
);
