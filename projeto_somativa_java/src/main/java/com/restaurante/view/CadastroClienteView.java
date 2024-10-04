package com.restaurante.view;

import com.restaurante.Models.Cliente;
import com.restaurante.service.ClienteService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastroClienteView extends JFrame {
    private JTextField nomeField;
    private JTextField cpfField;
    private JTextField emailField;
    private JTextField telefoneField;
    private JTextField loginField;
    private JPasswordField senhaField;
    private ClienteService clienteService;

    public CadastroClienteView() {
        clienteService = new ClienteService(); // Instancia o serviço de cliente

        setTitle("Cadastro Cliente");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());

        // Campos para cadastro
        JLabel nomeLabel = new JLabel("Nome:");
        nomeField = new JTextField(20);
        
        JLabel cpfLabel = new JLabel("CPF:");
        cpfField = new JTextField(20);
        
        JLabel emailLabel = new JLabel("Email:");
        emailField = new JTextField(20);
        
        JLabel telefoneLabel = new JLabel("Telefone:");
        telefoneField = new JTextField(20);
        
        JLabel loginLabel = new JLabel("Login:");
        loginField = new JTextField(20);
        
        JLabel senhaLabel = new JLabel("Senha:");
        senhaField = new JPasswordField(20);

        JButton cadastrarButton = new JButton("Cadastrar");
        JButton voltarButton = new JButton("Voltar");

        // Adicionando componentes ao layout
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(nomeLabel, gbc);
        gbc.gridx = 1;
        add(nomeField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(cpfLabel, gbc);
        gbc.gridx = 1;
        add(cpfField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(emailLabel, gbc);
        gbc.gridx = 1;
        add(emailField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        add(telefoneLabel, gbc);
        gbc.gridx = 1;
        add(telefoneField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        add(loginLabel, gbc);
        gbc.gridx = 1;
        add(loginField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        add(senhaLabel, gbc);
        gbc.gridx = 1;
        add(senhaField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        add(cadastrarButton, gbc);
        gbc.gridx = 1;
        add(voltarButton, gbc);

        // Ação do botão "Cadastrar"
        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Cria um novo cliente com os dados informados
                Cliente novoCliente = new Cliente();
                novoCliente.setNome(nomeField.getText());
                novoCliente.setCpf(cpfField.getText());
                novoCliente.setEmail(emailField.getText());
                novoCliente.setTelefone(telefoneField.getText());
                novoCliente.setLogin(loginField.getText());
                novoCliente.setSenha(new String(senhaField.getPassword()));

                // Tenta cadastrar o cliente
                boolean sucesso = clienteService.cadastrarCliente(novoCliente);
                if (sucesso) {
                    JOptionPane.showMessageDialog(CadastroClienteView.this, "Cadastro realizado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                    dispose(); // Fecha a tela de cadastro
                    new MainMenuView().setVisible(true); // Retorna ao menu principal
                } else {
                    JOptionPane.showMessageDialog(CadastroClienteView.this, "Erro ao cadastrar cliente!", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Ação do botão "Voltar"
        voltarButton.addActionListener(e -> {
            new MainMenuView().setVisible(true);
            dispose(); // Fecha a tela de cadastro
        });
    }
}
