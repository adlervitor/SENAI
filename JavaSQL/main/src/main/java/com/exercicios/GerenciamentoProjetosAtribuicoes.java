package com.exercicios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GerenciamentoProjetosAtribuicoes {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/senaidb";
        String usuario = "root";
        String senha = "1234";

        Connection conn = null;
        PreparedStatement stmtProjeto = null;
        PreparedStatement stmtAssociarFuncionarioProjeto = null;

        try {
            conn = DriverManager.getConnection(url, usuario, senha);
            conn.setAutoCommit(false);

            // Inserir dados na tabela projetos
            String sqlInserirProjeto = "INSERT INTO projetos (id_projeto, nome_projeto, descricao) VALUES (?, ?, ?)";
            stmtProjeto = conn.prepareStatement(sqlInserirProjeto);
            stmtProjeto.setInt(1, 1);
            stmtProjeto.setString(2, "Sistema de Controle");
            stmtProjeto.setString(3, "Desenvolvimento de um sistema interno");
            stmtProjeto.executeUpdate();

            stmtProjeto.setInt(1, 2);
            stmtProjeto.setString(2, "Portal Corporativo");
            stmtProjeto.setString(3, "Desenvolvimento de um portal para clientes");
            stmtProjeto.executeUpdate();

            // Inserir dados na tabela atribuicoes
            String sqlAssociarFuncionarioProjeto = "INSERT INTO atribuicoes (id_projeto, id_funcionario) VALUES (?, ?)";
            stmtAssociarFuncionarioProjeto = conn.prepareStatement(sqlAssociarFuncionarioProjeto);
            stmtAssociarFuncionarioProjeto.setInt(1, 1);
            stmtAssociarFuncionarioProjeto.setInt(2, 1);
            stmtAssociarFuncionarioProjeto.executeUpdate();

            stmtAssociarFuncionarioProjeto.setInt(1, 2);
            stmtAssociarFuncionarioProjeto.setInt(2, 2);
            stmtAssociarFuncionarioProjeto.executeUpdate();

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
                if (stmtProjeto != null) {
                    stmtProjeto.close();
                }
                if (stmtAssociarFuncionarioProjeto != null) {
                    stmtAssociarFuncionarioProjeto.close();
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
