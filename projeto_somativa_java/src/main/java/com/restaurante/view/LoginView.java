package com.restaurante.view;

import com.restaurante.Models.Administrador;
import com.restaurante.Models.Cliente;
import com.restaurante.Models.Funcionario;
import com.restaurante.service.AdministradorService;
import com.restaurante.service.ClienteService;
import com.restaurante.service.FuncionarioService;
import com.restaurante.session.Session;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginView extends JFrame {
    private JTextField loginField;
    private JPasswordField senhaField;
    private String tipoUsuario;
    private AdministradorService adminService;
    private ClienteService clienteService;
    private FuncionarioService funcionarioService;

    public LoginView(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
        setTitle("Login - " + tipoUsuario);
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());

        adminService = new AdministradorService();
        clienteService = new ClienteService();
        funcionarioService = new FuncionarioService();

        // Campos do login
        JLabel loginLabel = new JLabel("Login:");
        loginField = new JTextField(20);
        JLabel senhaLabel = new JLabel("Senha:");
        senhaField = new JPasswordField(20);

        JButton loginButton = new JButton("Entrar");
        JButton voltarButton = new JButton("Voltar");

        // Adicionando componentes ao layout
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(loginLabel, gbc);
        gbc.gridx = 1;
        add(loginField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(senhaLabel, gbc);
        gbc.gridx = 1;
        add(senhaField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(loginButton, gbc);
        gbc.gridx = 1;
        add(voltarButton, gbc);

        // Ação do botão "Entrar"
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String login = loginField.getText();
                String senha = new String(senhaField.getPassword());

                if (tipoUsuario.equals("Administrador")) {
                    Administrador admin = adminService.autenticarAdministrador(login, senha);
                    if (admin != null) {
                        new AdminView().setVisible(true);
                        dispose(); // Fecha a tela de login
                    } else {
                        JOptionPane.showMessageDialog(null, "Login ou senha inválidos!", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                } else if (tipoUsuario.equals("Cliente")) {
                    Cliente cliente = clienteService.autenticarCliente(login, senha);
                    if (cliente != null) {
                        new ClienteView().setVisible(true);
                        Session.setClienteId(cliente.getId()); 
                        dispose(); // Fecha a tela de login
                    } else {
                        JOptionPane.showMessageDialog(null, "Login ou senha inválidos!", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                } else if (tipoUsuario.equals("Funcionário")) {
                    Funcionario funcionario = funcionarioService.autenticarFuncionario(login, senha);
                    if (funcionario != null) {
                        new FuncionarioView().setVisible(true);
                        dispose(); // Fecha a tela de login
                    } else {
                        JOptionPane.showMessageDialog(null, "Login ou senha inválidos!", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        // Ação do botão "Voltar"
        voltarButton.addActionListener(e -> {
            new MainMenuView().setVisible(true);
            dispose(); // Fecha a tela de login
        });
    }
}
