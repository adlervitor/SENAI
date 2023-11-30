package com.exercicios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GestaoResultadosExames {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/senaidb";
        String usuario = "root";
        String senha = "1234";

        String tipoExame = "Exame de Sangue";
        String resultadoExame = "Normal";
        String nomePaciente = "Paciente A";
        String dataNascimento = "1990-01-01";

        String sqlInserirResultadoExame = "INSERT INTO resultados_exames (tipo_exame, resultado) VALUES (?, ?)";
        String sqlInserirPaciente = "INSERT INTO pacientes (nome_paciente, data_nascimento) VALUES (?, ?)";

        Connection conn = null;
        PreparedStatement stmtResultadoExame = null;
        PreparedStatement stmtPaciente = null;

        try {
            conn = DriverManager.getConnection(url, usuario, senha);
            conn.setAutoCommit(false);

            stmtResultadoExame = conn.prepareStatement(sqlInserirResultadoExame, PreparedStatement.RETURN_GENERATED_KEYS);
            stmtResultadoExame.setString(1, tipoExame);
            stmtResultadoExame.setString(2, resultadoExame);
            stmtResultadoExame.executeUpdate();

            int idResultadoExame = 0;
            ResultSet rsResultadoExame = stmtResultadoExame.getGeneratedKeys();
            if (rsResultadoExame.next()) {
                idResultadoExame = rsResultadoExame.getInt(1);
            } else {
                throw new SQLException("Falha ao obter o ID do resultado do exame.");
            }

            stmtPaciente = conn.prepareStatement(sqlInserirPaciente, PreparedStatement.RETURN_GENERATED_KEYS);
            stmtPaciente.setString(1, nomePaciente);
            stmtPaciente.setString(2, dataNascimento);
            stmtPaciente.executeUpdate();

            int idPaciente = 0;
            ResultSet rsPaciente = stmtPaciente.getGeneratedKeys();
            if (rsPaciente.next()) {
                idPaciente = rsPaciente.getInt(1);
            } else {
                throw new SQLException("Falha ao obter o ID do paciente.");
            }

            conn.commit();
            System.out.println("Resultado de exame e paciente registrados com sucesso!");
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
