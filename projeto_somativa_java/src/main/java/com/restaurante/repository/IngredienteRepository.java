package com.restaurante.repository;

import com.restaurante.Database;
import com.restaurante.Models.Ingrediente;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class IngredienteRepository {

    // Método para salvar um novo ingrediente
    public void save(Ingrediente ingrediente) {
        String sql = "INSERT INTO ingredientes (nome, quantidade, unidade_medida, data_validade) VALUES (?, ?, ?, ?)";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, ingrediente.getNome());
            stmt.setDouble(2, ingrediente.getQuantidade());
            stmt.setString(3, ingrediente.getUnidadeMedida());
            
            // Converte a String da data para java.sql.Date
            Date dataValidade = Date.valueOf(LocalDate.parse(ingrediente.getDataValidade(), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
            stmt.setDate(4, dataValidade);
            stmt.executeUpdate();
        } catch (SQLException | DateTimeParseException e) {
            throw new RuntimeException("Erro ao salvar ingrediente", e);
        }
    }

    // Método para editar um ingrediente existente
    public void update(Ingrediente ingrediente) {
        String sql = "UPDATE ingredientes SET nome = ?, quantidade = ?, unidade_medida = ?, data_validade = ? WHERE id = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, ingrediente.getNome());
            stmt.setDouble(2, ingrediente.getQuantidade());
            stmt.setString(3, ingrediente.getUnidadeMedida());
            
            // Converte a String da data para java.sql.Date
            Date dataValidade = Date.valueOf(LocalDate.parse(ingrediente.getDataValidade(), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
            stmt.setDate(4, dataValidade);
            stmt.setLong(5, ingrediente.getId());
            stmt.executeUpdate();
        } catch (SQLException | DateTimeParseException e) {
            throw new RuntimeException("Erro ao atualizar ingrediente", e);
        }
    }

    // Método para excluir um ingrediente
    public void delete(Long id) {
        String sql = "DELETE FROM ingredientes WHERE id = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir ingrediente", e);
        }
    }

    // Método para buscar um ingrediente por ID
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

    // Método para listar todos os ingredientes
    public List<Ingrediente> listarIngredientes() {
        List<Ingrediente> ingredientes = new ArrayList<>();
        String sql = "SELECT * FROM ingredientes";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Ingrediente ingrediente = new Ingrediente();
                ingrediente.setId(rs.getLong("id"));
                ingrediente.setNome(rs.getString("nome"));
                ingrediente.setQuantidade(rs.getDouble("quantidade"));
                ingrediente.setUnidadeMedida(rs.getString("unidade_medida"));
                ingrediente.setDataValidade(rs.getString("data_validade"));
                ingredientes.add(ingrediente);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar ingredientes", e);
        }
        return ingredientes;
    }
}
