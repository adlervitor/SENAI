package com.exercicios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AdicaoFornecedoresCompras {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/senaidb";
        String usuario = "root";
        String senha = "1234";

        Connection conn = null;
        PreparedStatement stmtFornecedor = null;
        PreparedStatement stmtCompra = null;

        try {
            conn = DriverManager.getConnection(url, usuario, senha);
            conn.setAutoCommit(false);

            // Inserir dados na tabela fornecedores
            String sqlInserirFornecedor = "INSERT INTO fornecedores (id_fornecedor, nome, contato) VALUES (?, ?, ?)";
            stmtFornecedor = conn.prepareStatement(sqlInserirFornecedor);
            stmtFornecedor.setInt(1, 1);
            stmtFornecedor.setString(2, "Empresa A");
            stmtFornecedor.setString(3, "contato@empresaA.com");
            stmtFornecedor.executeUpdate();

            stmtFornecedor.setInt(1, 2);
            stmtFornecedor.setString(2, "Empresa B");
            stmtFornecedor.setString(3, "contato@empresaB.com");
            stmtFornecedor.executeUpdate();

            // Inserir dados na tabela compras
            String sqlInserirCompra = "INSERT INTO compras (id_compra, id_fornecedor, produto_comprado, quantidade) VALUES (?, ?, ?, ?)";
            stmtCompra = conn.prepareStatement(sqlInserirCompra);
            stmtCompra.setInt(1, 1);
            stmtCompra.setInt(2, 1);
            stmtCompra.setString(3, "Peças de computador");
            stmtCompra.setInt(4, 100);
            stmtCompra.executeUpdate();

            stmtCompra.setInt(1, 2);
            stmtCompra.setInt(2, 2);
            stmtCompra.setString(3, "Material de escritório");
            stmtCompra.setInt(4, 500);
            stmtCompra.executeUpdate();

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
