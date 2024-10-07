package com.restaurante.repository;

import com.restaurante.Models.Pedido;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PedidoRepository {
    private final String URL = "jdbc:postgresql://localhost:5433/postgres";
    private final String USER = "postgres";
    private final String PASSWORD = "postgres";

    public void save(Pedido pedido) {
        String sql = "INSERT INTO pedidos (cliente_id, prato_id, quantidade, total) VALUES (?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, pedido.getCliente().getId()); // Certifique-se de que o pedido tenha um cliente
            pstmt.setLong(2, pedido.getPrato().getId());
            pstmt.setInt(3, pedido.getQuantidade());
            pstmt.setDouble(4, pedido.getTotal());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Pedido> findAll() {
        List<Pedido> pedidos = new ArrayList<>();
        String sql = "SELECT * FROM pedidos";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Pedido pedido = new Pedido();
                pedido.setId(rs.getLong("id"));
                // Aqui você pode buscar o cliente e o prato do pedido, se necessário
                pedido.setQuantidade(rs.getInt("quantidade"));
                pedido.setTotal(rs.getDouble("total"));
                pedidos.add(pedido);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pedidos;
    }
}