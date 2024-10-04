package com.restaurante.Models;

import lombok.Data;

@Data
public class Cliente {
    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private String login;
    private String senha;
}
