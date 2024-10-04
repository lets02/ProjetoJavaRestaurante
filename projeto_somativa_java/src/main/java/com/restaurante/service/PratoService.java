package com.restaurante.service;

import com.restaurante.Models.Prato;
import com.restaurante.repository.PratoRepository;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class PratoService {
    private final PratoRepository pratoRepository = new PratoRepository();

    public void cadastrarPrato(Prato prato) {
        pratoRepository.save(prato);
    }

    public List<Prato> visualizarCardapio() {
        return pratoRepository.findAll(); // Método para encontrar todos os pratos
    }

    public void editarPrato(Long id, Prato prato) {
        pratoRepository.update(id, prato); // Método para atualizar o prato
    }

    public void excluirPrato(Long id) {
        pratoRepository.delete(id); // Método para excluir o prato
    }

    public Optional<Prato> buscarPratoPorId(Long id) { // Método para buscar prato por ID
        return pratoRepository.findById(id);
    }

    public PratoService(PratoRepository pratoRepository2) {
        //TODO Auto-generated constructor stub
    }
}
