package com.exercicios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CadastroLivrosAutores {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/senaidb";
        String usuario = "root";
        String senha = "1234";

        Connection conn = null;
        PreparedStatement stmtLivro = null;
        PreparedStatement stmtAutor = null;
        PreparedStatement stmtAssociarLivroAutor = null;

        try {
            conn = DriverManager.getConnection(url, usuario, senha);
            conn.setAutoCommit(false);

            // Inserir dados na tabela livros
            String sqlInserirLivro = "INSERT INTO livros (id_livro, titulo, ano_publicacao) VALUES (?, ?, ?)";
            stmtLivro = conn.prepareStatement(sqlInserirLivro);
            stmtLivro.setInt(1, 1);
            stmtLivro.setString(2, "Aprendendo Python");
            stmtLivro.setInt(3, 2020);
            stmtLivro.executeUpdate();

            stmtLivro.setInt(1, 2);
            stmtLivro.setString(2, "Introdução à Inteligência Artificial");
            stmtLivro.setInt(3, 2019);
            stmtLivro.executeUpdate();

            // Inserir dados na tabela autores
            String sqlInserirAutor = "INSERT INTO autores (id_autor, nome_autor) VALUES (?, ?)";
            stmtAutor = conn.prepareStatement(sqlInserirAutor);
            stmtAutor.setInt(1, 1);
            stmtAutor.setString(2, "Carlos Silva");
            stmtAutor.executeUpdate();

            stmtAutor.setInt(1, 2);
            stmtAutor.setString(2, "Ana Souza");
            stmtAutor.executeUpdate();

            // Associar livros e autores na tabela livros_autores
            String sqlAssociarLivroAutor = "INSERT INTO livros_autores (id_livro, id_autor) VALUES (?, ?)";
            stmtAssociarLivroAutor = conn.prepareStatement(sqlAssociarLivroAutor);
            stmtAssociarLivroAutor.setInt(1, 1);
            stmtAssociarLivroAutor.setInt(2, 1);
            stmtAssociarLivroAutor.executeUpdate();

            stmtAssociarLivroAutor.setInt(1, 2);
            stmtAssociarLivroAutor.setInt(2, 2);
            stmtAssociarLivroAutor.executeUpdate();

            conn.commit();
            System.out.println("Dados inseridos com sucesso!");
        } catch (SQLException e) {
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                if (stmtLivro != null) {
                    stmtLivro.close();
                }
                if (stmtAutor != null) {
                    stmtAutor.close();
                }
                if (stmtAssociarLivroAutor != null) {
                    stmtAssociarLivroAutor.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}