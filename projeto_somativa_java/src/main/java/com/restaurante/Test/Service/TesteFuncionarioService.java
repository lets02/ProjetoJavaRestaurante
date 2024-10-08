package com.restaurante.Test.Service;

import com.restaurante.Models.Funcionario;
import com.restaurante.Test.Repository.TesteFuncionarioRepository;
import com.restaurante.repository.FuncionarioRepository;

public class TesteFuncionarioService {
    TesteFuncionarioRepository repository;

    public TesteFuncionarioService(TesteFuncionarioRepository repository) {
        this.repository = repository;
    }

    public void cadastrarFuncionario(Funcionario funcionario) {
        // Lógica para cadastrar funcionário
        repository.save(funcionario);
    }

    public Funcionario autenticarFuncionario(String login, String senha) {
        Funcionario funcionario = repository.findByLogin(login);
        if (funcionario != null && funcionario.getSenha().equals(senha)) {
            return funcionario; // Login bem-sucedido
        }
        return null; // Login falhou
    }
}
