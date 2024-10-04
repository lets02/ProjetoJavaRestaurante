package com.restaurante.service;

import com.restaurante.Models.Ingrediente;
import com.restaurante.repository.IngredienteRepository;

public class IngredienteService {
    private final IngredienteRepository repository = new IngredienteRepository();

    public void cadastrarIngrediente(Ingrediente ingrediente) {
        repository.save(ingrediente);
    }

    public Ingrediente buscarIngrediente(Long id) {
        return repository.findById(id);
    }
}
