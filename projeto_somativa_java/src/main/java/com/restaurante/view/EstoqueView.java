package com.restaurante.view;

import com.restaurante.Models.Ingrediente;
import com.restaurante.service.IngredienteService;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class EstoqueView extends JFrame {
    private IngredienteService ingredienteService;
    private JList<Ingrediente> ingredientesList;

    public EstoqueView() {
        setTitle("Gerenciamento de Estoque");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        ingredienteService = new IngredienteService();
        ingredientesList = new JList<>();

        JButton cadastrarButton = new JButton("Cadastrar Ingrediente");
        cadastrarButton.addActionListener(e -> cadastrarIngrediente());

        JButton editarButton = new JButton("Editar Ingrediente");
        editarButton.addActionListener(e -> editarIngrediente());

        JButton excluirButton = new JButton("Excluir Ingrediente");
        excluirButton.addActionListener(e -> excluirIngrediente());

        JPanel panel = new JPanel();
        panel.add(cadastrarButton);
        panel.add(editarButton);
        panel.add(excluirButton);

        add(new JScrollPane(ingredientesList), BorderLayout.CENTER);
        add(panel, BorderLayout.SOUTH);

        listarIngredientes();
    }

    private void listarIngredientes() {
        List<Ingrediente> ingredientes = ingredienteService.listarIngredientes();
        ingredientesList.setListData(ingredientes.toArray(new Ingrediente[0]));
    }

    private void cadastrarIngrediente() {
        Ingrediente ingrediente = new Ingrediente();
        ingrediente.setNome(JOptionPane.showInputDialog(this, "Nome do Ingrediente:"));
        ingrediente.setQuantidade(Double.parseDouble(JOptionPane.showInputDialog(this, "Quantidade:")));
        ingrediente.setUnidadeMedida(JOptionPane.showInputDialog(this, "Unidade de Medida:"));
        ingrediente.setDataValidade(JOptionPane.showInputDialog(this, "Data de Validade:"));

        ingredienteService.cadastrarIngrediente(ingrediente);
        listarIngredientes();
    }

    private void editarIngrediente() {
        Ingrediente ingredienteSelecionado = ingredientesList.getSelectedValue();
        if (ingredienteSelecionado != null) {
            ingredienteSelecionado.setNome(JOptionPane.showInputDialog(this, "Novo Nome:", ingredienteSelecionado.getNome()));
            ingredienteSelecionado.setQuantidade(Double.parseDouble(JOptionPane.showInputDialog(this, "Nova Quantidade:", ingredienteSelecionado.getQuantidade())));
            ingredienteSelecionado.setUnidadeMedida(JOptionPane.showInputDialog(this, "Nova Unidade de Medida:", ingredienteSelecionado.getUnidadeMedida()));
            ingredienteSelecionado.setDataValidade(JOptionPane.showInputDialog(this, "Nova Data de Validade:", ingredienteSelecionado.getDataValidade()));

            ingredienteService.editarIngrediente(ingredienteSelecionado);
            listarIngredientes();
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um ingrediente para editar.");
        }
    }

    private void excluirIngrediente() {
        Ingrediente ingredienteSelecionado = ingredientesList.getSelectedValue();
        if (ingredienteSelecionado != null) {
            int confirmacao = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja excluir o ingrediente?", "Confirmação", JOptionPane.YES_NO_OPTION);
            if (confirmacao == JOptionPane.YES_OPTION) {
                ingredienteService.excluirIngrediente(ingredienteSelecionado.getId());
                listarIngredientes();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um ingrediente para excluir.");
        }
    }
}
