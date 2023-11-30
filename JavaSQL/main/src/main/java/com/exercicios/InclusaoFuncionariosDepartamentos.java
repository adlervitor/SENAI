package com.exercicios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InclusaoFuncionariosDepartamentos {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/senaidb";
        String usuario = "root";
        String senha = "1234";

        String nomeFuncionario = "Funcionário A";
        String cargoFuncionario = "Cargo X";
        String nomeDepartamento = "Departamento Y";

        String sqlInserirFuncionario = "INSERT INTO funcionarios (nome, cargo) VALUES (?, ?)";
        String sqlInserirDepartamento = "INSERT INTO departamentos (nome_departamento) VALUES (?)";
        String sqlAssociarFuncionarioDepartamento = "UPDATE funcionarios SET id_departamento = ? WHERE id_funcionario = ?";

        Connection conn = null;
        PreparedStatement stmtFuncionario = null;
        PreparedStatement stmtDepartamento = null;
        PreparedStatement stmtAssociarFuncionarioDepartamento = null;

        try {
            conn = DriverManager.getConnection(url, usuario, senha);
            conn.setAutoCommit(false);

            stmtFuncionario = conn.prepareStatement(sqlInserirFuncionario, PreparedStatement.RETURN_GENERATED_KEYS);
            stmtFuncionario.setString(1, nomeFuncionario);
            stmtFuncionario.setString(2, cargoFuncionario);
            stmtFuncionario.executeUpdate();

            int idFuncionario = 0;
            ResultSet rsFuncionario = stmtFuncionario.getGeneratedKeys();
            if (rsFuncionario.next()) {
                idFuncionario = rsFuncionario.getInt(1);
            } else {
                throw new SQLException("Falha ao obter o ID do funcionário.");
            }

            stmtDepartamento = conn.prepareStatement(sqlInserirDepartamento, PreparedStatement.RETURN_GENERATED_KEYS);
            stmtDepartamento.setString(1, nomeDepartamento);
            stmtDepartamento.executeUpdate();

            int idDepartamento = 0;
            ResultSet rsDepartamento = stmtDepartamento.getGeneratedKeys();
            if (rsDepartamento.next()) {
                idDepartamento = rsDepartamento.getInt(1);
            } else {
                throw new SQLException("Falha ao obter o ID do departamento.");
            }

            stmtAssociarFuncionarioDepartamento = conn.prepareStatement(sqlAssociarFuncionarioDepartamento);
            stmtAssociarFuncionarioDepartamento.setInt(1, idDepartamento);
            stmtAssociarFuncionarioDepartamento.setInt(2, idFuncionario);
            stmtAssociarFuncionarioDepartamento.executeUpdate();

            conn.commit();
            System.out.println("Funcionário, departamento e associação registrados com sucesso!");
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

