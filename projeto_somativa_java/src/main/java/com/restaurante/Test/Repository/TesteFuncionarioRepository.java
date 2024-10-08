package com.restaurante.Test.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.restaurante.Models.Funcionario;


public interface TesteFuncionarioRepository {
    void save(Funcionario funcionario);

    Funcionario findByLogin(String login);
}
