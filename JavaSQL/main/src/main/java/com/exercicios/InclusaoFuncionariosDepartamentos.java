package com.exercicios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InclusaoFuncionariosDepartamentos {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/senaidb";
        String usuario = "root";
        String senha = "1234";

        Connection conn = null;
        PreparedStatement stmtFuncionario = null;
        PreparedStatement stmtDepartamento = null;
        PreparedStatement stmtAssociarFuncionarioDepartamento = null;

        try {
            conn = DriverManager.getConnection(url, usuario, senha);
            conn.setAutoCommit(false);

            // Inserir dados na tabela funcionarios
            String sqlInserirFuncionario = "INSERT INTO funcionarios (id_funcionario, nome, cargo) VALUES (?, ?, ?)";
            stmtFuncionario = conn.prepareStatement(sqlInserirFuncionario);
            stmtFuncionario.setInt(1, 1);
            stmtFuncionario.setString(2, "Luiz");
            stmtFuncionario.setString(3, "Analista");
            stmtFuncionario.executeUpdate();

            stmtFuncionario.setInt(1, 2);
            stmtFuncionario.setString(2, "Carla");
            stmtFuncionario.setString(3, "Gerente");
            stmtFuncionario.executeUpdate();

            // Inserir dados na tabela departamentos
            String sqlInserirDepartamento = "INSERT INTO departamentos (id_departamento, nome_departamento) VALUES (?, ?)";
            stmtDepartamento = conn.prepareStatement(sqlInserirDepartamento);
            stmtDepartamento.setInt(1, 1);
            stmtDepartamento.setString(2, "TI");
            stmtDepartamento.executeUpdate();

            stmtDepartamento.setInt(1, 2);
            stmtDepartamento.setString(2, "Recursos Humanos");
            stmtDepartamento.executeUpdate();

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
                if (stmtFuncionario != null) {
                    stmtFuncionario.close();
                }
                if (stmtDepartamento != null) {
                    stmtDepartamento.close();
                }
                if (stmtAssociarFuncionarioDepartamento != null) {
                    stmtAssociarFuncionarioDepartamento.close();
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