package com.restaurante.service;

import com.restaurante.Models.Funcionario;
import com.restaurante.repository.FuncionarioRepository;

public class FuncionarioService {
    private final FuncionarioRepository funcionarioRepository = new FuncionarioRepository();

    public void cadastrarFuncionario(Funcionario funcionario) {
        // Lógica para cadastrar funcionário
        funcionarioRepository.save(funcionario);
    }

    public Funcionario autenticarFuncionario(String login, String senha) {
        Funcionario funcionario = funcionarioRepository.findByLogin(login);
        if (funcionario != null && funcionario.getSenha().equals(senha)) {
            return funcionario; // Login bem-sucedido
        }
        return null; // Login falhou
    }
}
