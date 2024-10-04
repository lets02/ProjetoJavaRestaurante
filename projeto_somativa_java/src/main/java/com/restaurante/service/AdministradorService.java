package com.restaurante.service;

import com.restaurante.Models.Administrador;
import com.restaurante.repository.AdministradorRepository;

public class AdministradorService {
    private final AdministradorRepository adminRepository = new AdministradorRepository();

    public void cadastrarAdministrador(Administrador administrador) {
        // Lógica para cadastrar administrador
        adminRepository.save(administrador); // Supondo que você tenha um método save no repositório
    }

    public Administrador autenticarAdministrador(String nome, String senha) {
        Administrador admin = adminRepository.findByNome(nome); // Método para buscar administrador pelo nome
        if (admin != null && admin.getSenha().equals(senha)) {
            return admin; // Login bem-sucedido
        }
        return null; // Login falhou
    }
}
