package com.exercicios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CadastroLivrosAutores {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/senaidb";
        String usuario = "root";
        String senha = "1234";

        String tituloLivro = "Livro A";
        int anoPublicacao = 2023;
        String nomeAutor = "Autor X";

        String sqlInserirLivro = "INSERT INTO livros (titulo, ano_publicacao) VALUES (?, ?)";
        String sqlInserirAutor = "INSERT INTO autores (nome_autor) VALUES (?)";
        String sqlAssociarLivroAutor = "INSERT INTO livros_autores (id_livro, id_autor) VALUES (?, ?)";

        Connection conn = null;
        PreparedStatement stmtLivro = null;
        PreparedStatement stmtAutor = null;
        PreparedStatement stmtAssociarLivroAutor = null;

        try {
            conn = DriverManager.getConnection(url, usuario, senha);
            conn.setAutoCommit(false);

            stmtLivro = conn.prepareStatement(sqlInserirLivro, PreparedStatement.RETURN_GENERATED_KEYS);
            stmtLivro.setString(1, tituloLivro);
            stmtLivro.setInt(2, anoPublicacao);
            stmtLivro.executeUpdate();

            int idLivro = 0;
            ResultSet rsLivro = stmtLivro.getGeneratedKeys();
            if (rsLivro.next()) {
                idLivro = rsLivro.getInt(1);
            } else {
                throw new SQLException("Falha ao obter o ID do livro.");
            }

            stmtAutor = conn.prepareStatement(sqlInserirAutor, PreparedStatement.RETURN_GENERATED_KEYS);
            stmtAutor.setString(1, nomeAutor);
            stmtAutor.executeUpdate();

            int idAutor = 0;
            ResultSet rsAutor = stmtAutor.getGeneratedKeys();
            if (rsAutor.next()) {
                idAutor = rsAutor.getInt(1);
            } else {
                throw new SQLException("Falha ao obter o ID do autor.");
            }

            stmtAssociarLivroAutor = conn.prepareStatement(sqlAssociarLivroAutor);
            stmtAssociarLivroAutor.setInt(1, idLivro);
            stmtAssociarLivroAutor.setInt(2, idAutor);
            stmtAssociarLivroAutor.executeUpdate();

            conn.commit();
            System.out.println("Livro, autor e associação registrados com sucesso!");
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

