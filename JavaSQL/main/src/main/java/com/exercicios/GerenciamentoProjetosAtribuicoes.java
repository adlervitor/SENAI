package com.exercicios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GerenciamentoProjetosAtribuicoes {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/senaidb";
        String usuario = "root";
        String senha = "1234";

        String nomeProjeto = "Projeto A";
        String descricaoProjeto = "Descrição do Projeto A";
        int idFuncionario = 1;

        String sqlInserirProjeto = "INSERT INTO projetos (nome_projeto, descricao) VALUES (?, ?)";
        String sqlAssociarFuncionarioProjeto = "INSERT INTO atribuicoes (id_projeto, id_funcionario) VALUES (?, ?)";

        Connection conn = null;
        PreparedStatement stmtProjeto = null;
        PreparedStatement stmtAssociarFuncionarioProjeto = null;

        try {
            conn = DriverManager.getConnection(url, usuario, senha);
            conn.setAutoCommit(false);

            stmtProjeto = conn.prepareStatement(sqlInserirProjeto, PreparedStatement.RETURN_GENERATED_KEYS);
            stmtProjeto.setString(1, nomeProjeto);
            stmtProjeto.setString(2, descricaoProjeto);
            stmtProjeto.executeUpdate();

            int idProjeto = 0;
            ResultSet rsProjeto = stmtProjeto.getGeneratedKeys();
            if (rsProjeto.next()) {
                idProjeto = rsProjeto.getInt(1);
            } else {
                throw new SQLException("Falha ao obter o ID do projeto.");
            }

            stmtAssociarFuncionarioProjeto = conn.prepareStatement(sqlAssociarFuncionarioProjeto);
            stmtAssociarFuncionarioProjeto.setInt(1, idProjeto);
            stmtAssociarFuncionarioProjeto.setInt(2, idFuncionario);
            stmtAssociarFuncionarioProjeto.executeUpdate();

            conn.commit();
            System.out.println("Projeto e associação de funcionário registrados com sucesso!");
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
