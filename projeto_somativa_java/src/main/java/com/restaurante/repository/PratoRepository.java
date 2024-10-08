package com.restaurante.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.restaurante.Models.Prato;

public class PratoRepository {
    private final String URL = "jdbc:postgresql://localhost:5433/postgres";
    private final String USER = "postgres";
    private final String PASSWORD = "postgres";

    public void save(Prato prato) {
        String sql = "INSERT INTO pratos (nome, descricao, preco) VALUES (?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, prato.getNome());
            pstmt.setString(2, prato.getDescricao());
            pstmt.setDouble(3, prato.getPreco());
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Prato> findAll() {
        List<Prato> pratos = new ArrayList<>();
        String sql = "SELECT * FROM pratos";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                PreparedStatement pstmt = conn.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Prato prato = new Prato();
                prato.setId(rs.getLong("id"));
                prato.setNome(rs.getString("nome"));
                prato.setDescricao(rs.getString("descricao"));
                prato.setPreco(rs.getDouble("preco"));
                pratos.add(prato);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pratos;
    }

    public void update(Long id, Prato prato) {
        String sql = "UPDATE pratos SET nome = ?, descricao = ?, preco = ? WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, prato.getNome());
            pstmt.setString(2, prato.getDescricao());
            pstmt.setDouble(3, prato.getPreco());
            pstmt.setLong(4, id);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(Long id) {
        String sql = "DELETE FROM pratos WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, id);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Método adicionado para buscar prato por ID
    public Optional<Prato> findById(Long id) {
        String sql = "SELECT * FROM pratos WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setLong(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                Prato prato = new Prato();
                prato.setId(rs.getLong("id"));
                prato.setNome(rs.getString("nome"));
                prato.setDescricao(rs.getString("descricao"));
                prato.setPreco(rs.getDouble("preco"));
                return Optional.of(prato);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}