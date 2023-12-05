package com.exercicios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CadastroUsuariosPedidos {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/senaidb";
        String usuario = "root";
        String senha = "1234";

        String nomeUsuario1 = "Eduardo";
        String emailUsuario1 = "eduardo@example.com";
        String nomeUsuario2 = "Laura";
        String emailUsuario2 = "laura@example.com";
        String produto1 = "Livro de Ficção";
        String produto2 = "Fones de Ouvido";
        int quantidade1 = 3;
        int quantidade2 = 1;

        String sqlInserirUsuario = "INSERT INTO usuarios (nome, email) VALUES (?, ?)";
        String sqlInserirPedido = "INSERT INTO pedidos (id_usuario, produto, quantidade) VALUES (?, ?, ?)";

        Connection conn = null;
        PreparedStatement stmtUsuario1 = null;
        PreparedStatement stmtUsuario2 = null;
        PreparedStatement stmtPedido1 = null;
        PreparedStatement stmtPedido2 = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(url, usuario, senha);

            // Inserir primeiro usuário
            stmtUsuario1 = conn.prepareStatement(sqlInserirUsuario, PreparedStatement.RETURN_GENERATED_KEYS);
            stmtUsuario1.setString(1, nomeUsuario1);
            stmtUsuario1.setString(2, emailUsuario1);
            stmtUsuario1.executeUpdate();

            int idUsuario1 = 0;
            rs = stmtUsuario1.getGeneratedKeys();
            if (rs.next()) {
                idUsuario1 = rs.getInt(1);
            } else {
                throw new SQLException("Falha ao obter o ID do primeiro usuário.");
            }

            // Inserir pedido do primeiro usuário
            stmtPedido1 = conn.prepareStatement(sqlInserirPedido);
            stmtPedido1.setInt(1, idUsuario1);
            stmtPedido1.setString(2, produto1);
            stmtPedido1.setInt(3, quantidade1);
            stmtPedido1.executeUpdate();

            // Inserir segundo usuário
            stmtUsuario2 = conn.prepareStatement(sqlInserirUsuario, PreparedStatement.RETURN_GENERATED_KEYS);
            stmtUsuario2.setString(1, nomeUsuario2);
            stmtUsuario2.setString(2, emailUsuario2);
            stmtUsuario2.executeUpdate();

            int idUsuario2 = 0;
            rs = stmtUsuario2.getGeneratedKeys();
            if (rs.next()) {
                idUsuario2 = rs.getInt(1);
            } else {
                throw new SQLException("Falha ao obter o ID do segundo usuário.");
            }

            // Inserir pedido do segundo usuário
            stmtPedido2 = conn.prepareStatement(sqlInserirPedido);
            stmtPedido2.setInt(1, idUsuario2);
            stmtPedido2.setString(2, produto2);
            stmtPedido2.setInt(3, quantidade2);
            stmtPedido2.executeUpdate();

            System.out.println("Usuários e pedidos registrados com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmtUsuario1 != null) {
                    stmtUsuario1.close();
                }
                if (stmtUsuario2 != null) {
                    stmtUsuario2.close();
                }
                if (stmtPedido1 != null) {
                    stmtPedido1.close();
                }
                if (stmtPedido2 != null) {
                    stmtPedido2.close();
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
