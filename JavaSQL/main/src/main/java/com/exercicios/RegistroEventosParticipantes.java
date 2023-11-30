package com.exercicios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegistroEventosParticipantes {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/senaidb";
        String usuario = "root";
        String senha = "1234";

        String nomeEvento = "Evento A";
        String dataEvento = "2023-12-01"; 
        String nomeParticipante1 = "Participante 1";
        String nomeParticipante2 = "Participante 2";

        String sqlInserirEvento = "INSERT INTO eventos (nome_evento, data) VALUES (?, ?)";
        String sqlInserirParticipante = "INSERT INTO participantes (id_evento, nome_participante) VALUES (?, ?)";

        Connection conn = null;
        PreparedStatement stmtEvento = null;
        PreparedStatement stmtParticipante = null;

        try {
            conn = DriverManager.getConnection(url, usuario, senha);
            conn.setAutoCommit(false);

            stmtEvento = conn.prepareStatement(sqlInserirEvento, PreparedStatement.RETURN_GENERATED_KEYS);
            stmtEvento.setString(1, nomeEvento);
            stmtEvento.setString(2, dataEvento);
            stmtEvento.executeUpdate();

            int idEvento = 0;
            ResultSet rsEvento = stmtEvento.getGeneratedKeys();
            if (rsEvento.next()) {
                idEvento = rsEvento.getInt(1);
            } else {
                throw new SQLException("Falha ao obter o ID do evento.");
            }

            stmtParticipante = conn.prepareStatement(sqlInserirParticipante);
            stmtParticipante.setInt(1, idEvento);
            stmtParticipante.setString(2, nomeParticipante1);
            stmtParticipante.executeUpdate();

            stmtParticipante.setInt(1, idEvento);
            stmtParticipante.setString(2, nomeParticipante2);
            stmtParticipante.executeUpdate();

            conn.commit();
            System.out.println("Evento e participantes registrados com sucesso!");
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

