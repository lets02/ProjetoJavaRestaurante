package com.restaurante.repository;

import com.restaurante.Models.Administrador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AdministradorRepository {
    private final String URL = "jdbc:postgresql://localhost:5433/postgres"; // Altere para seu banco de dados
    private final String USER = "postgres"; // Altere para seu usuário
    private final String PASSWORD = "postgres"; // Altere para sua senha

    public void save(Administrador administrador) {
        String sql = "INSERT INTO administradores (nome, senha) VALUES (?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, administrador.getNome());
            pstmt.setString(2, administrador.getSenha());
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Administrador findByNome(String nome) {
        String sql = "SELECT * FROM administradores WHERE nome = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nome);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                Administrador admin = new Administrador();
                admin.setNome(rs.getString("nome"));
                admin.setSenha(rs.getString("senha"));
                return admin; // Retorna o administrador se o nome for encontrado
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null; // Retorna null se não encontrar
    }
}
