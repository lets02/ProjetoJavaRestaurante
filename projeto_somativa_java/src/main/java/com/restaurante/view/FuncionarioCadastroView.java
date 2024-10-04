package com.restaurante.view;
import com.restaurante.Models.Funcionario;
import com.restaurante.service.FuncionarioService;

import javax.swing.*;
import java.awt.*;

public class FuncionarioCadastroView extends JDialog {
    private JTextField nomeField;
    private JTextField cpfField;
    private JTextField cargoField;
    private JTextField loginField;
    private JPasswordField senhaField;

    public FuncionarioCadastroView(Frame owner) {
        super(owner, "Cadastro de Funcionário", true);
        setSize(400, 300);
        setLayout(new GridLayout(6, 2));
        setLocationRelativeTo(owner);

        // Campos de entrada
        add(new JLabel("Nome:"));
        nomeField = new JTextField();
        add(nomeField);

        add(new JLabel("CPF:"));
        cpfField = new JTextField();
        add(cpfField);

        add(new JLabel("Cargo:"));
        cargoField = new JTextField();
        add(cargoField);

        add(new JLabel("Login:"));
        loginField = new JTextField();
        add(loginField);

        add(new JLabel("Senha:"));
        senhaField = new JPasswordField();
        add(senhaField);

        JButton cadastrarButton = new JButton("Cadastrar");
        JButton cancelarButton = new JButton("Cancelar");

        add(cadastrarButton);
        add(cancelarButton);

        // Ação do botão "Cadastrar"
        cadastrarButton.addActionListener(e -> {
            Funcionario funcionario = new Funcionario();
            funcionario.setNome(nomeField.getText());
            funcionario.setCpf(cpfField.getText());
            funcionario.setCargo(cargoField.getText());
            funcionario.setLogin(loginField.getText());
            funcionario.setSenha(new String(senhaField.getPassword()));

            FuncionarioService funcionarioService = new FuncionarioService();
            funcionarioService.cadastrarFuncionario(funcionario); // Cadastra o funcionário

            JOptionPane.showMessageDialog(this, "Funcionário cadastrado com sucesso!");
            dispose(); // Fecha o diálogo
        });

        // Ação do botão "Cancelar"
        cancelarButton.addActionListener(e -> dispose());
    }
}
