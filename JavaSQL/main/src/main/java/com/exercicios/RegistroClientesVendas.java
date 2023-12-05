package com.exercicios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegistroClientesVendas {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/senaidb";
        String usuario = "root";
        String senha = "1234";

        Connection conn = null;
        PreparedStatement stmtCliente = null;
        PreparedStatement stmtVenda = null;

        try {
            conn = DriverManager.getConnection(url, usuario, senha);
            conn.setAutoCommit(false);

            // Inserir dados na tabela clientes
            String sqlInserirCliente = "INSERT INTO clientes (id_cliente, nome, email) VALUES (?, ?, ?)";
            stmtCliente = conn.prepareStatement(sqlInserirCliente);
            stmtCliente.setInt(1, 1);
            stmtCliente.setString(2, "Ana");
            stmtCliente.setString(3, "ana@example.com");
            stmtCliente.executeUpdate();

            stmtCliente.setInt(1, 2);
            stmtCliente.setString(2, "Pedro");
            stmtCliente.setString(3, "pedro@example.com");
            stmtCliente.executeUpdate();

            // Inserir dados na tabela vendas
            String sqlInserirVenda = "INSERT INTO vendas (id_venda, id_cliente, produto_vendido, valor) VALUES (?, ?, ?, ?)";
            stmtVenda = conn.prepareStatement(sqlInserirVenda);
            stmtVenda.setInt(1, 1);
            stmtVenda.setInt(2, 1);
            stmtVenda.setString(3, "Celular");
            stmtVenda.setDouble(4, 1200.00);
            stmtVenda.executeUpdate();

            stmtVenda.setInt(1, 2);
            stmtVenda.setInt(2, 2);
            stmtVenda.setString(3, "Fones");
            stmtVenda.setDouble(4, 150.00);
            stmtVenda.executeUpdate();

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
                if (stmtCliente != null) {
                    stmtCliente.close();
                }
                if (stmtVenda != null) {
                    stmtVenda.close();
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