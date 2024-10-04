package com.restaurante.Models;

import lombok.Data;

@Data
public class Funcionario {
    private Long id;
    private String nome;
    private String cpf;
    private String cargo;
    private String login;
    private String senha;
}
