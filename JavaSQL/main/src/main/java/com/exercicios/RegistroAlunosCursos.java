package com.exercicios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegistroAlunosCursos {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/senaidb";
        String usuario = "root";
        String senha = "1234";

        Connection conn = null;
        PreparedStatement stmtAluno = null;
        PreparedStatement stmtCurso = null;

        try {
            conn = DriverManager.getConnection(url, usuario, senha);
            conn.setAutoCommit(false);

            // Inserir dados na tabela alunos
            String sqlInserirAluno = "INSERT INTO alunos (id_aluno, nome, turma) VALUES (?, ?, ?)";
            stmtAluno = conn.prepareStatement(sqlInserirAluno);
            stmtAluno.setInt(1, 1);
            stmtAluno.setString(2, "Lucas");
            stmtAluno.setString(3, "A");
            stmtAluno.executeUpdate();

            stmtAluno.setInt(1, 2);
            stmtAluno.setString(2, "Julia");
            stmtAluno.setString(3, "B");
            stmtAluno.executeUpdate();

            // Inserir dados na tabela cursos
            String sqlInserirCurso = "INSERT INTO cursos (id_curso, nome_curso, instrutor) VALUES (?, ?, ?)";
            stmtCurso = conn.prepareStatement(sqlInserirCurso);
            stmtCurso.setInt(1, 1);
            stmtCurso.setString(2, "Matemática");
            stmtCurso.setString(3, "Professor Carlos");
            stmtCurso.executeUpdate();

            stmtCurso.setInt(1, 2);
            stmtCurso.setString(2, "Ciências");
            stmtCurso.setString(3, "Professora Ana");
            stmtCurso.executeUpdate();

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
                if (stmtAluno != null) {
                    stmtAluno.close();
                }
                if (stmtCurso != null) {
                    stmtCurso.close();
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