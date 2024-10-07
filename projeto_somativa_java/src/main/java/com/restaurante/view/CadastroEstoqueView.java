package com.restaurante.view;

import javax.swing.*;
import java.awt.*;
import com.restaurante.Models.Ingrediente;
import com.restaurante.service.IngredienteService;

public class CadastroEstoqueView extends JFrame {
    private JTextField nomeField;
    private JTextField quantidadeField;
    private JTextField unidadeMedidaField;
    private JTextField dataValidadeField;
    private IngredienteService ingredienteService;

    public CadastroEstoqueView() {
        setTitle("Cadastro de Ingrediente");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 2));

        ingredienteService = new IngredienteService();

        // Campos de entrada
        add(new JLabel("Nome:"));
        nomeField = new JTextField();
        add(nomeField);

        add(new JLabel("Quantidade:"));
        quantidadeField = new JTextField();
        add(quantidadeField);

        add(new JLabel("Unidade de Medida:"));
        unidadeMedidaField = new JTextField();
        add(unidadeMedidaField);

        add(new JLabel("Data de Validade:"));
        dataValidadeField = new JTextField();
        add(dataValidadeField);

        // Botão de cadastro
        JButton cadastrarButton = new JButton("Cadastrar");
        cadastrarButton.addActionListener(e -> cadastrarIngrediente());
        add(cadastrarButton);

        // Botão de cancelamento
        JButton cancelButton = new JButton("Cancelar");
        cancelButton.addActionListener(e -> dispose());
        add(cancelButton);
    }

    private void cadastrarIngrediente() {
        String nome = nomeField.getText();
        double quantidade = Double.parseDouble(quantidadeField.getText());
        String unidadeMedida = unidadeMedidaField.getText();
        String dataValidade = dataValidadeField.getText();

        Ingrediente ingrediente = new Ingrediente();
        ingrediente.setNome(nome);
        ingrediente.setQuantidade(quantidade);
        ingrediente.setUnidadeMedida(unidadeMedida);
        ingrediente.setDataValidade(dataValidade);

        ingredienteService.cadastrarIngrediente(ingrediente);
        JOptionPane.showMessageDialog(this, "Ingrediente cadastrado com sucesso!");
        dispose(); // Fecha a tela após o cadastro
    }
}
