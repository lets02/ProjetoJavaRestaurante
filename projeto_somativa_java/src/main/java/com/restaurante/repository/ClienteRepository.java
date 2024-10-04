package com.restaurante.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.restaurante.Models.Cliente;

public class ClienteRepository {
    private String url = "jdbc:postgresql://localhost:5433/postgres"; // Alterar para o seu banco
    private String usuario = "postgres"; // Alterar para seu usuário
    private String senha = "postgres"; // Alterar para sua senha

    public boolean salvar(Cliente cliente) {
        String sql = "INSERT INTO clientes (nome, cpf, email, telefone, login, senha) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url, usuario, senha);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, cliente.getNome());
            pstmt.setString(2, cliente.getCpf());
            pstmt.setString(3, cliente.getEmail());
            pstmt.setString(4, cliente.getTelefone());
            pstmt.setString(5, cliente.getLogin());
            pstmt.setString(6, cliente.getSenha());
            
            pstmt.executeUpdate(); // Executa a inserção
            return true; // Retorna verdadeiro se a inserção foi bem-sucedida
        } catch (SQLException e) {
            e.printStackTrace(); // Exibe erro, se houver
            return false; // Retorna falso se houve um erro
        }
    }

    public Cliente buscarPorLogin(String login) {
        String sql = "SELECT * FROM clientes WHERE login = ?";
        Cliente cliente = null;

        try (Connection conn = DriverManager.getConnection(url, usuario, senha);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, login);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                cliente = new Cliente();
                cliente.setId(rs.getLong("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setEmail(rs.getString("email"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setLogin(rs.getString("login"));
                cliente.setSenha(rs.getString("senha")); // A senha é recuperada aqui
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Exibe erro, se houver
        }
        return cliente; // Retorna o cliente ou null se não encontrado
    }
}
