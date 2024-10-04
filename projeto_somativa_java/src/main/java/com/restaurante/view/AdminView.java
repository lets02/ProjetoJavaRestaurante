package com.restaurante.view;

import javax.swing.*;
import java.awt.*;

public class AdminView extends JFrame {
    public AdminView() {
        setTitle("Painel do Administrador");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        JButton cadastrarFuncionario = new JButton("Cadastrar Funcionário");
        JButton cadastrarPrato = new JButton("Cadastrar Prato");
        JButton visualizarCardapio = new JButton("Visualizar Cardápio");
        JButton logoutButton = new JButton("Logout");

        add(cadastrarFuncionario);
        add(cadastrarPrato);
        add(visualizarCardapio);
        add(logoutButton);

        // Implementação das ações para cada botão
        cadastrarFuncionario.addActionListener(e -> {
            FuncionarioCadastroView cadastroView = new FuncionarioCadastroView(this);
            cadastroView.setVisible(true); // Abre a tela de cadastro
        });

        cadastrarPrato.addActionListener(e -> {
            PratoCadastroView cadastroView = new PratoCadastroView(this);
            cadastroView.setVisible(true); // Abre a tela de cadastro de prato
        });

        visualizarCardapio.addActionListener(e -> {
            CardapioView cardapioView = new CardapioView(this);
            cardapioView.setVisible(true); // Abre a tela de visualização do cardápio
        });
        
        logoutButton.addActionListener(e -> {
            new MainMenuView().setVisible(true);
            dispose(); // Fecha a tela do administrador
        });
    }
}
