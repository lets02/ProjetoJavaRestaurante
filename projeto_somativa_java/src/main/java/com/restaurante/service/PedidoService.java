package com.restaurante.service;

import com.restaurante.Models.Pedido;
import com.restaurante.Models.Prato;
import com.restaurante.Models.Cliente; // Certifique-se de que a classe Cliente está importada
import com.restaurante.repository.PedidoRepository;
import com.restaurante.repository.PratoRepository;
import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final PratoRepository pratoRepository;

    // Método para criar um novo pedido
    public String fazerPedido(Long clienteId, Long pratoId, int quantidade) {
        // Criar objeto Cliente
        Cliente cliente = new Cliente();
        cliente.setId(clienteId); // Defina o ID do cliente corretamente

        // Buscar o prato no cardápio pelo ID
        Optional<Prato> pratoOptional = pratoRepository.findById(pratoId);

        // Verificar se o prato existe
        if (pratoOptional.isPresent()) {
            Prato prato = pratoOptional.get();

            // Criar um novo pedido
            Pedido pedido = new Pedido();
            pedido.setCliente(cliente); // Setando o cliente no pedido
            pedido.setPrato(prato);
            pedido.setQuantidade(quantidade);
            pedido.setTotal(prato.getPreco() * quantidade);

            // Salvar o pedido no banco de dados
            pedidoRepository.save(pedido);

            return "Pedido do prato " + prato.getNome() + " realizado com sucesso!";
        } else {
            return "Prato com ID " + pratoId + " não encontrado no cardápio!";
        }
    }
}
