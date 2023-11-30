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

        String nomeUsuario = "Exemplo";
        String emailUsuario = "exemplo@email.com";
        String produto = "Produto X";
        int quantidade = 5;

        String sqlInserirUsuario = "INSERT INTO usuarios (nome, email) VALUES (?, ?)";
        String sqlInserirPedido = "INSERT INTO pedidos (id_usuario, produto, quantidade) VALUES (?, ?, ?)";

        Connection conn = null;
        PreparedStatement stmtUsuario = null;
        PreparedStatement stmtPedido = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(url, usuario, senha);
            
            stmtUsuario = conn.prepareStatement(sqlInserirUsuario, PreparedStatement.RETURN_GENERATED_KEYS);
            stmtUsuario.setString(1, nomeUsuario);
            stmtUsuario.setString(2, emailUsuario);
            stmtUsuario.executeUpdate();

            int idUsuario = 0;
            rs = stmtUsuario.getGeneratedKeys();
            if (rs.next()) {
                idUsuario = rs.getInt(1);
            } else {
                throw new SQLException("Falha ao obter o ID do usuário.");
            }

            stmtPedido = conn.prepareStatement(sqlInserirPedido);
            stmtPedido.setInt(1, idUsuario);
            stmtPedido.setString(2, produto);
            stmtPedido.setInt(3, quantidade);
            stmtPedido.executeUpdate();

            System.out.println("Usuário e pedido registrados com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmtUsuario != null) {
                    stmtUsuario.close();
                }
                if (stmtPedido != null) {
                    stmtPedido.close();
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