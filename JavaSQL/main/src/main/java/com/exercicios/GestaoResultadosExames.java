package com.exercicios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GestaoResultadosExames {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/senaidb";
        String usuario = "root";
        String senha = "1234";

        Connection conn = null;
        PreparedStatement stmtResultadoExame = null;
        PreparedStatement stmtPaciente = null;

        try {
            conn = DriverManager.getConnection(url, usuario, senha);
            conn.setAutoCommit(false);

            // Inserir dados na tabela resultados_exames
            String sqlInserirResultadoExame = "INSERT INTO resultados_exames (id_resultado, tipo_exame, resultado) VALUES (?, ?, ?)";
            stmtResultadoExame = conn.prepareStatement(sqlInserirResultadoExame);
            stmtResultadoExame.setInt(1, 1);
            stmtResultadoExame.setString(2, "Exame de Sangue");
            stmtResultadoExame.setString(3, "Normal");
            stmtResultadoExame.executeUpdate();

            stmtResultadoExame.setInt(1, 2);
            stmtResultadoExame.setString(2, "Raio-X");
            stmtResultadoExame.setString(3, "Fratura identificada");
            stmtResultadoExame.executeUpdate();

            // Inserir dados na tabela pacientes
            String sqlInserirPaciente = "INSERT INTO pacientes (id_paciente, nome_paciente, data_nascimento) VALUES (?, ?, ?)";
            stmtPaciente = conn.prepareStatement(sqlInserirPaciente);
            stmtPaciente.setInt(1, 1);
            stmtPaciente.setString(2, "Mariana");
            stmtPaciente.setString(3, "1995-06-10");
            stmtPaciente.executeUpdate();

            stmtPaciente.setInt(1, 2);
            stmtPaciente.setString(2, "Rafael");
            stmtPaciente.setString(3, "1987-09-25");
            stmtPaciente.executeUpdate();

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
                if (stmtResultadoExame != null) {
                    stmtResultadoExame.close();
                }
                if (stmtPaciente != null) {
                    stmtPaciente.close();
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