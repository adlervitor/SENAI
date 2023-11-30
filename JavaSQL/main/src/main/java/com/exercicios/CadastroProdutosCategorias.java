package com.exercicios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CadastroProdutosCategorias {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/senaidb";
        String usuario = "root";
        String senha = "1234";

        String nomeProduto = "Produto A";
        double precoProduto = 25.99;
        String nomeCategoria = "Categoria X";

        String sqlInserirProduto = "INSERT INTO produtos (nome_produto, preco) VALUES (?, ?)";
        String sqlInserirCategoria = "INSERT INTO categorias (nome_categoria) VALUES (?)";
        String sqlAssociarProdutoCategoria = "INSERT INTO produtos_categorias (id_produto, id_categoria) VALUES (?, ?)";

        Connection conn = null;
        PreparedStatement stmtProduto = null;
        PreparedStatement stmtCategoria = null;
        PreparedStatement stmtAssociarProdutoCategoria = null;

        try {
            conn = DriverManager.getConnection(url, usuario, senha);
            conn.setAutoCommit(false);

            stmtProduto = conn.prepareStatement(sqlInserirProduto, PreparedStatement.RETURN_GENERATED_KEYS);
            stmtProduto.setString(1, nomeProduto);
            stmtProduto.setDouble(2, precoProduto);
            stmtProduto.executeUpdate();

            int idProduto = 0;
            ResultSet rsProduto = stmtProduto.getGeneratedKeys();
            if (rsProduto.next()) {
                idProduto = rsProduto.getInt(1);
            } else {
                throw new SQLException("Falha ao obter o ID do produto.");
            }

            stmtCategoria = conn.prepareStatement(sqlInserirCategoria, PreparedStatement.RETURN_GENERATED_KEYS);
            stmtCategoria.setString(1, nomeCategoria);
            stmtCategoria.executeUpdate();

            int idCategoria = 0;
            ResultSet rsCategoria = stmtCategoria.getGeneratedKeys();
            if (rsCategoria.next()) {
                idCategoria = rsCategoria.getInt(1);
            } else {
                throw new SQLException("Falha ao obter o ID da categoria.");
            }

            stmtAssociarProdutoCategoria = conn.prepareStatement(sqlAssociarProdutoCategoria);
            stmtAssociarProdutoCategoria.setInt(1, idProduto);
            stmtAssociarProdutoCategoria.setInt(2, idCategoria);
            stmtAssociarProdutoCategoria.executeUpdate();

            conn.commit();
            System.out.println("Produto, categoria e associação registrados com sucesso!");
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
                if (stmtProduto != null) {
                    stmtProduto.close();
                }
                if (stmtCategoria != null) {
                    stmtCategoria.close();
                }
                if (stmtAssociarProdutoCategoria != null) {
                    stmtAssociarProdutoCategoria.close();
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
