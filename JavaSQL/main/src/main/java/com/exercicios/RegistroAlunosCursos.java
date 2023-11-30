package com.exercicios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegistroAlunosCursos {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/senaidb";
        String usuario = "root";
        String senha = "1234";

        String nomeAluno = "Aluno A";
        String turmaAluno = "Turma X";
        String nomeCurso = "Curso Y";
        String instrutorCurso = "Instrutor Z";

        String sqlInserirAluno = "INSERT INTO alunos (nome, turma) VALUES (?, ?)";
        String sqlInserirCurso = "INSERT INTO cursos (nome_curso, instrutor) VALUES (?, ?)";
        String sqlAssociarAlunoCurso = "INSERT INTO alunos_cursos (id_aluno, id_curso) VALUES (?, ?)";

        Connection conn = null;
        PreparedStatement stmtAluno = null;
        PreparedStatement stmtCurso = null;
        PreparedStatement stmtAssociarAlunoCurso = null;

        try {
            conn = DriverManager.getConnection(url, usuario, senha);
            conn.setAutoCommit(false);

            stmtAluno = conn.prepareStatement(sqlInserirAluno, PreparedStatement.RETURN_GENERATED_KEYS);
            stmtAluno.setString(1, nomeAluno);
            stmtAluno.setString(2, turmaAluno);
            stmtAluno.executeUpdate();

            int idAluno = 0;
            ResultSet rsAluno = stmtAluno.getGeneratedKeys();
            if (rsAluno.next()) {
                idAluno = rsAluno.getInt(1);
            } else {
                throw new SQLException("Falha ao obter o ID do aluno.");
            }

            stmtCurso = conn.prepareStatement(sqlInserirCurso, PreparedStatement.RETURN_GENERATED_KEYS);
            stmtCurso.setString(1, nomeCurso);
            stmtCurso.setString(2, instrutorCurso);
            stmtCurso.executeUpdate();

            int idCurso = 0;
            ResultSet rsCurso = stmtCurso.getGeneratedKeys();
            if (rsCurso.next()) {
                idCurso = rsCurso.getInt(1);
            } else {
                throw new SQLException("Falha ao obter o ID do curso.");
            }

            stmtAssociarAlunoCurso = conn.prepareStatement(sqlAssociarAlunoCurso);
            stmtAssociarAlunoCurso.setInt(1, idAluno);
            stmtAssociarAlunoCurso.setInt(2, idCurso);
            stmtAssociarAlunoCurso.executeUpdate();

            conn.commit();
            System.out.println("Aluno, curso e associação registrados com sucesso!");
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
                if (stmtAssociarAlunoCurso != null) {
                    stmtAssociarAlunoCurso.close();
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

