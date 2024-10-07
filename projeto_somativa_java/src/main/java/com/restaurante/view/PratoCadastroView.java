package com.restaurante.view;

import javax.swing.*;
import java.awt.*;

import com.restaurante.Models.Prato;
import com.restaurante.service.PratoService;

public class PratoCadastroView extends JFrame {
    private JTextField nomeField;
    private JTextArea descricaoArea;
    private JTextField precoField;
    private PratoService pratoService;
    private Prato pratoEditando;

    public PratoCadastroView(JFrame parent) {
        setTitle("Cadastro de Prato");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(parent);
        setLayout(new GridLayout(5, 2));

        pratoService = new PratoService();

        // Criação dos campos de entrada
        JLabel nomeLabel = new JLabel("Nome:");
        nomeField = new JTextField();
        
        JLabel descricaoLabel = new JLabel("Descrição:");
        descricaoArea = new JTextArea();
        
        JLabel precoLabel = new JLabel("Preço:");
        precoField = new JTextField();

        JButton salvarButton = new JButton("Salvar");
        JButton cancelarButton = new JButton("Cancelar");

        // Adiciona os componentes ao JFrame
        add(nomeLabel);
        add(nomeField);
        add(descricaoLabel);
        add(new JScrollPane(descricaoArea)); // Rolagem para a área de descrição
        add(precoLabel);
        add(precoField);
        add(salvarButton);
        add(cancelarButton);

        // Ação para salvar o prato
        salvarButton.addActionListener(e -> salvarPrato());

        // Ação para cancelar a operação
        cancelarButton.addActionListener(e -> dispose());
    }

    public void preencherDados(Prato prato) {
        this.pratoEditando = prato;
        nomeField.setText(prato.getNome());
        descricaoArea.setText(prato.getDescricao());
        precoField.setText(String.valueOf(prato.getPreco()));
    }

    private void salvarPrato() {
        if (pratoEditando == null) {
            // Cadastro de novo prato
            Prato novoPrato = new Prato();
            novoPrato.setNome(nomeField.getText());
            novoPrato.setDescricao(descricaoArea.getText());
            novoPrato.setPreco(Double.parseDouble(precoField.getText()));
            pratoService.cadastrarPrato(novoPrato);
            JOptionPane.showMessageDialog(this, "Prato cadastrado com sucesso!");
        } else {
            // Edição de prato existente
            pratoEditando.setNome(nomeField.getText());
            pratoEditando.setDescricao(descricaoArea.getText());
            pratoEditando.setPreco(Double.parseDouble(precoField.getText()));
            pratoService.editarPrato(pratoEditando.getId(), pratoEditando);
            JOptionPane.showMessageDialog(this, "Prato editado com sucesso!");
        }
        dispose(); // Fecha a tela após salvar
    }
}