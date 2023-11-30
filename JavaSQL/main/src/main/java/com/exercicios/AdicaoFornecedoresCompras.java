package com.exercicios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdicaoFornecedoresCompras {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/senaidb";
        String usuario = "root";
        String senha = "1234";

        String nomeFornecedor = "Fornecedor XYZ";
        String contatoFornecedor = "Contato do Fornecedor XYZ";
        String produtoComprado = "Produto A";
        int quantidade = 10;

        String sqlInserirFornecedor = "INSERT INTO fornecedores (nome, contato) VALUES (?, ?)";
        String sqlInserirCompra = "INSERT INTO compras (id_fornecedor, produto_comprado, quantidade) VALUES (?, ?, ?)";

        Connection conn = null;
        PreparedStatement stmtFornecedor = null;
        PreparedStatement stmtCompra = null;

        try {
            conn = DriverManager.getConnection(url, usuario, senha);
            conn.setAutoCommit(false);

            stmtFornecedor = conn.prepareStatement(sqlInserirFornecedor, PreparedStatement.RETURN_GENERATED_KEYS);
            stmtFornecedor.setString(1, nomeFornecedor);
            stmtFornecedor.setString(2, contatoFornecedor);
            stmtFornecedor.executeUpdate();

            int idFornecedor = 0;
            ResultSet rsFornecedor = stmtFornecedor.getGeneratedKeys();
            if (rsFornecedor.next()) {
                idFornecedor = rsFornecedor.getInt(1);
            } else {
                throw new SQLException("Falha ao obter o ID do fornecedor.");
            }

            stmtCompra = conn.prepareStatement(sqlInserirCompra);
            stmtCompra.setInt(1, idFornecedor);
            stmtCompra.setString(2, produtoComprado);
            stmtCompra.setInt(3, quantidade);
            stmtCompra.executeUpdate();

            conn.commit();
            System.out.println("Fornecedor e compra registrados com sucesso!");
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
                if (stmtFornecedor != null) {
                    stmtFornecedor.close();
                }
                if (stmtCompra != null) {
                    stmtCompra.close();
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
