package com.restaurante.view;

import javax.swing.*;
import java.awt.*;

import com.restaurante.Models.Prato;
import com.restaurante.service.PratoService;

public class FuncionarioView extends JFrame {
    private PratoService pratoService;

    public FuncionarioView() {
        setTitle("Painel do Funcionário");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        pratoService = new PratoService(); // Instanciando o serviço de pratos

        JButton visualizarPedidos = new JButton("Visualizar Pedidos");
        JButton concluirPedido = new JButton("Concluir Pedido");
        JButton estoqueButton = new JButton("Estoque"); // Botão de Estoque
        JButton logoutButton = new JButton("Logout");

        add(visualizarPedidos);
        add(concluirPedido);
        add(estoqueButton); // Adiciona o botão de Estoque ao layout
        add(logoutButton);

        // Ação para visualizar pedidos (exemplo simples)
        visualizarPedidos.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Nenhum pedido pendente no momento.", "Pedidos", JOptionPane.INFORMATION_MESSAGE);
        });

        // Ação para concluir pedido
        concluirPedido.addActionListener(e -> {
            String pedidoIdStr = JOptionPane.showInputDialog(this, "Digite o ID do pedido para concluir:");
            if (pedidoIdStr != null && !pedidoIdStr.isEmpty()) {
                int pedidoId = Integer.parseInt(pedidoIdStr);
                JOptionPane.showMessageDialog(this, "Pedido ID " + pedidoId + " concluído com sucesso!", "Concluir Pedido", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        // Ação para estoque
        estoqueButton.addActionListener(e -> {
            // Lógica para gerenciar o estoque
            JOptionPane.showMessageDialog(this, "Abrindo tela de gerenciamento de estoque...", "Estoque", JOptionPane.INFORMATION_MESSAGE);
            // Aqui você pode abrir uma nova tela para gerenciar o estoque
            // new EstoqueView().setVisible(true);
        });

        // Ação de logout
        logoutButton.addActionListener(e -> {
            new MainMenuView().setVisible(true);
            dispose(); // Fecha a tela do funcionário
        });
    }
}
