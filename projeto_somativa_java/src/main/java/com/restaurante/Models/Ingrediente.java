package com.restaurante.Models;

import lombok.Data;

@Data
public class Ingrediente {
    private Long id;
    private String nome;
    private double quantidade;
    private String unidadeMedida;
    private String dataValidade;
}
