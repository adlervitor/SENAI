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

        String nomeCliente = "Cliente A";
        String emailCliente = "cliente@email.com";
        String produtoVendido = "Produto X";
        double valorVenda = 50.0;

        String sqlInserirCliente = "INSERT INTO clientes (nome, email) VALUES (?, ?)";
        String sqlInserirVenda = "INSERT INTO vendas (id_cliente, produto_vendido, valor) VALUES (?, ?, ?)";

        Connection conn = null;
        PreparedStatement stmtCliente = null;
        PreparedStatement stmtVenda = null;

        try {
            conn = DriverManager.getConnection(url, usuario, senha);
            conn.setAutoCommit(false);

            stmtCliente = conn.prepareStatement(sqlInserirCliente, PreparedStatement.RETURN_GENERATED_KEYS);
            stmtCliente.setString(1, nomeCliente);
            stmtCliente.setString(2, emailCliente);
            stmtCliente.executeUpdate();

            int idCliente = 0;
            ResultSet rsCliente = stmtCliente.getGeneratedKeys();
            if (rsCliente.next()) {
                idCliente = rsCliente.getInt(1);
            } else {
                throw new SQLException("Falha ao obter o ID do cliente.");
            }

            stmtVenda = conn.prepareStatement(sqlInserirVenda);
            stmtVenda.setInt(1, idCliente);
            stmtVenda.setString(2, produtoVendido);
            stmtVenda.setDouble(3, valorVenda);
            stmtVenda.executeUpdate();

            conn.commit();
            System.out.println("Cliente e venda registrados com sucesso!");
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

