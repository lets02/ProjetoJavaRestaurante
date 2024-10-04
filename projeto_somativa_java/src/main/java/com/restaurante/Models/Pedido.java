package com.restaurante.Models;

import lombok.Data;

@Data
public class Pedido {
    private Long id;
    private Cliente cliente;
    private Prato prato;
    private int quantidade;
    private double total;

    public void calcularTotal() {
        this.total = prato.getPreco() * this.quantidade;
    }
}
