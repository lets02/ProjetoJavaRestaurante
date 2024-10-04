package com.restaurante.repository;

import com.restaurante.Database;
import com.restaurante.Models.Ingrediente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class IngredienteRepository {

    public void save(Ingrediente ingrediente) {
        String sql = "INSERT INTO ingredientes (nome, quantidade, unidade_medida, data_validade) VALUES (?, ?, ?, ?)";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, ingrediente.getNome());
            stmt.setDouble(2, ingrediente.getQuantidade());
            stmt.setString(3, ingrediente.getUnidadeMedida());
            stmt.setString(4, ingrediente.getDataValidade());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar ingrediente", e);
        }
    }

    public Ingrediente findById(Long id) {
        String sql = "SELECT * FROM ingredientes WHERE id = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Ingrediente ingrediente = new Ingrediente();
                ingrediente.setId(rs.getLong("id"));
                ingrediente.setNome(rs.getString("nome"));
                ingrediente.setQuantidade(rs.getDouble("quantidade"));
                ingrediente.setUnidadeMedida(rs.getString("unidade_medida"));
                ingrediente.setDataValidade(rs.getString("data_validade"));
                return ingrediente;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar ingrediente", e);
        }
        return null;
    }
}
