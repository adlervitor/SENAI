package com.exercicios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegistroEventosParticipantes {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/senaidb";
        String usuario = "root";
        String senha = "1234";

        Connection conn = null;
        PreparedStatement stmtEvento = null;
        PreparedStatement stmtParticipante = null;

        try {
            conn = DriverManager.getConnection(url, usuario, senha);
            conn.setAutoCommit(false);

            // Inserir dados na tabela eventos
            String sqlInserirEvento = "INSERT INTO eventos (id_evento, nome_evento, data) VALUES (?, ?, ?)";
            stmtEvento = conn.prepareStatement(sqlInserirEvento);
            stmtEvento.setInt(1, 1);
            stmtEvento.setString(2, "Conferência de Tecnologia");
            stmtEvento.setString(3, "2023-12-15");
            stmtEvento.executeUpdate();

            stmtEvento.setInt(1, 2);
            stmtEvento.setString(2, "Workshop de Marketing Digital");
            stmtEvento.setString(3, "2023-11-20");
            stmtEvento.executeUpdate();

            // Inserir dados na tabela participantes
            String sqlInserirParticipante = "INSERT INTO participantes (id_participante, id_evento, nome_participante) VALUES (?, ?, ?)";
            stmtParticipante = conn.prepareStatement(sqlInserirParticipante);
            stmtParticipante.setInt(1, 1);
            stmtParticipante.setInt(2, 1);
            stmtParticipante.setString(3, "Gabriel");
            stmtParticipante.executeUpdate();

            stmtParticipante.setInt(1, 2);
            stmtParticipante.setInt(2, 2);
            stmtParticipante.setString(3, "Sofia");
            stmtParticipante.executeUpdate();

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
                if (stmtEvento != null) {
                    stmtEvento.close();
                }
                if (stmtParticipante != null) {
                    stmtParticipante.close();
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