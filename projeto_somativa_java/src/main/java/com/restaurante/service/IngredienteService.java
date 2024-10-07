package com.restaurante.service;

import com.restaurante.Models.Ingrediente;
import com.restaurante.repository.IngredienteRepository;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

public class IngredienteService {
    private final IngredienteRepository repository = new IngredienteRepository();

    // Cadastrar um novo ingrediente
    public void cadastrarIngrediente(Ingrediente ingrediente) {
        // Aqui você pode garantir que a data está no formato correto antes de salvar
        verificarDataValidade(ingrediente);
        repository.save(ingrediente);
    }

    // Editar um ingrediente existente
    public void editarIngrediente(Ingrediente ingrediente) {
        verificarDataValidade(ingrediente);
        repository.update(ingrediente);
    }

    // Excluir um ingrediente pelo ID
    public void excluirIngrediente(Long id) {
        repository.delete(id);
    }

    // Buscar ingrediente por ID
    public Ingrediente buscarIngrediente(Long id) {
        return repository.findById(id);
    }

    // Listar todos os ingredientes
    public List<Ingrediente> listarIngredientes() {
        return repository.listarIngredientes();
    }

    // Verifica e converte a data validade
    private void verificarDataValidade(Ingrediente ingrediente) {
        try {
            LocalDate localDate = LocalDate.parse(ingrediente.getDataValidade(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            Date sqlDate = Date.valueOf(localDate);
            ingrediente.setDataValidade(sqlDate.toString()); // Você pode manter como String se necessário
        } catch (DateTimeParseException e) {
            throw new RuntimeException("Formato de data inválido. Use o formato yyyy-MM-dd.", e);
        }
    }
}
