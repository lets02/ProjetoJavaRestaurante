package com.restaurante.Models;

import lombok.Data;

@Data
public class Prato {
    private Long id;
    private String nome;
    private String descricao; // Adicionando o campo descrição
    private double preco; // Adicionando o campo preço
}
