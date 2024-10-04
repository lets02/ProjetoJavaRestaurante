package com.restaurante.view;

import javax.swing.*;
import java.awt.*;

public class MainMenuView extends JFrame {
    public MainMenuView() {
        setTitle("Menu Principal");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());

        // Título do menu
        JLabel titleLabel = new JLabel("Sistema de Restaurante Oriental");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16)); // Definindo a fonte do título
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER); // Centraliza o título

        // Botões do menu
        JButton loginAdminButton = new JButton("Login Administrador");
        JButton loginFuncionarioButton = new JButton("Login Funcionário");
        JButton loginClienteButton = new JButton("Login Cliente");
        JButton cadastroClienteButton = new JButton("Cadastro Cliente");
        JButton sairButton = new JButton("Sair");

        // Adicionando os componentes ao layout
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2; // O título ocupa duas colunas
        add(titleLabel, gbc); // Adiciona o título ao layout

        gbc.gridwidth = 1; // Reseta o gridwidth para os botões

        // Centralizando os botões
        gbc.fill = GridBagConstraints.HORIZONTAL; // Permite que os botões ocupem toda a largura disponível
        gbc.gridx = 0; // Coluna para o botão
        gbc.gridy = 1; // Aumenta a linha para o botão
        add(loginAdminButton, gbc);
        
        gbc.gridy = 2;
        add(loginFuncionarioButton, gbc);
        
        gbc.gridy = 3;
        add(loginClienteButton, gbc);
        
        gbc.gridy = 4;
        add(cadastroClienteButton, gbc);
        
        gbc.gridy = 5; // Aumenta a linha para o botão sair
        add(sairButton, gbc);

        // Ações dos botões
        loginAdminButton.addActionListener(e -> {
            new LoginView("Administrador").setVisible(true);
            dispose(); // Fecha a tela inicial
        });

        loginFuncionarioButton.addActionListener(e -> {
            new LoginView("Funcionário").setVisible(true);
            dispose(); // Fecha a tela inicial
        });

        loginClienteButton.addActionListener(e -> {
            new LoginView("Cliente").setVisible(true);
            dispose(); // Fecha a tela inicial
        });

        cadastroClienteButton.addActionListener(e -> {
            new CadastroClienteView().setVisible(true);
            dispose(); // Fecha a tela inicial
        });

        sairButton.addActionListener(e -> System.exit(0));
    }
}
