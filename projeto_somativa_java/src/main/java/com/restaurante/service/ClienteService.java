package com.restaurante.service;

import com.restaurante.Models.Cliente;
import com.restaurante.repository.ClienteRepository;

public class ClienteService {
    private ClienteRepository clienteRepository;

    public ClienteService() {
        this.clienteRepository = new ClienteRepository();
    }

    public Cliente autenticarCliente(String login, String senha) {
        // Busca o cliente pelo login
        Cliente cliente = clienteRepository.buscarPorLogin(login);

        // Verifica se a senha está correta
        if (cliente != null && cliente.getSenha().equals(senha)) {
            return cliente; // Retorna o cliente se a autenticação for bem-sucedida
        }
        return null; // Retorna null se a autenticação falhar
    }

    public boolean cadastrarCliente(Cliente cliente) {
        return clienteRepository.salvar(cliente);
    }
}
