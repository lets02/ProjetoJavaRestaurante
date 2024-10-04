package com.restaurante.view;

import javax.swing.*;
import java.awt.*;
import com.restaurante.service.PratoService;
import com.restaurante.service.PedidoService;
import com.restaurante.repository.PedidoRepository; // Importando PedidoRepository
import com.restaurante.repository.PratoRepository; // Importando PratoRepository

public class ClienteView extends JFrame {
    private PratoService pratoService;
    private PedidoService pedidoService; // Adicionando PedidoService
    private PratoRepository pratoRepository; // Adicionando PratoRepository
    private PedidoRepository pedidoRepository; // Adicionando PedidoRepository

    public ClienteView() {
        setTitle("Painel do Cliente");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        pratoRepository = new PratoRepository(); // Instanciando o repositório de pratos
        pedidoRepository = new PedidoRepository(); // Instanciando o repositório de pedidos
        pratoService = new PratoService(pratoRepository); // Instanciando o serviço de pratos
        pedidoService = new PedidoService(pedidoRepository, pratoRepository); // Instanciando o serviço de pedidos com o repositório

        JButton visualizarCardapio = new JButton("Visualizar Cardápio");
        JButton fazerPedido = new JButton("Fazer Pedido");
        JButton logoutButton = new JButton("Logout");

        add(visualizarCardapio);
        add(fazerPedido);
        add(logoutButton);

        // Ação para visualizar o cardápio
        visualizarCardapio.addActionListener(e -> {
            CardapioClienteView cardapioClienteView = new CardapioClienteView(this);
            cardapioClienteView.setVisible(true);
        });

        // Ação para fazer pedido
        fazerPedido.addActionListener(e -> {
            PedidoView pedidoView = new PedidoView(this, pratoService, pedidoRepository); // Passando os serviços
            pedidoView.setVisible(true);
        });

        // Ação de logout
        logoutButton.addActionListener(e -> {
            new MainMenuView().setVisible(true);
            dispose(); // Fecha a tela do cliente
        });
    }
}
