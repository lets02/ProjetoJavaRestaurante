package com.restaurante.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.restaurante.Models.Funcionario;

public class FuncionarioRepository {
    private final String URL = "jdbc:postgresql://localhost:5433/postgres"; 
    private final String USER = "postgres"; 
    private final String PASSWORD = "postgres"; 

    public void save(Funcionario funcionario) {
        String sql = "INSERT INTO funcionarios (nome, cpf, cargo, login, senha) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, funcionario.getNome());
            pstmt.setString(2, funcionario.getCpf());
            pstmt.setString(3, funcionario.getCargo());
            pstmt.setString(4, funcionario.getLogin());
            pstmt.setString(5, funcionario.getSenha());
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Funcionario findByLogin(String login) {
        String sql = "SELECT * FROM funcionarios WHERE login = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, login);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                Funcionario funcionario = new Funcionario();
                funcionario.setNome(rs.getString("nome"));
                funcionario.setCpf(rs.getString("cpf"));
                funcionario.setCargo(rs.getString("cargo"));
                funcionario.setLogin(rs.getString("login"));
                funcionario.setSenha(rs.getString("senha"));
                return funcionario;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null; 
    }
}
