package com.restaurante;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final String URL = "jdbc:postgresql://localhost:5433/postgres"; // Altere para o seu banco de dados
    private static final String USER = "postgres"; // Altere para o seu usuário
    private static final String PASSWORD = "postgres"; // Altere para a sua senha

    public static Connection getConnection() {
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexão bem-sucedida ao banco de dados!");
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao conectar ao banco de dados: " + e.getMessage(), e);
        }
    }
}
