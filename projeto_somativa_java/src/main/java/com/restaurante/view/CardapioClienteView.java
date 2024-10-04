package com.restaurante.view;

import javax.swing.*;
import java.awt.*;
import java.util.List;

import com.restaurante.Models.Prato;
import com.restaurante.service.PratoService;

public class CardapioClienteView extends JFrame {
    private PratoService pratoService;

    public CardapioClienteView(JFrame parent) {
        setTitle("Cardápio do Cliente");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(parent);
        setLayout(new BorderLayout());

        pratoService = new PratoService();
        DefaultListModel<Prato> listModel = new DefaultListModel<>();
        JList<Prato> pratoList = new JList<>(listModel);
        pratoList.setCellRenderer(new PratoCellRenderer());

        // Carregar os pratos no modelo de lista
        atualizarLista(listModel);

        // ScrollPane para a lista de pratos
        JScrollPane scrollPane = new JScrollPane(pratoList);
        scrollPane.setPreferredSize(new Dimension(550, 300));
        add(scrollPane, BorderLayout.CENTER);

        JButton voltarButton = new JButton("Voltar");
        voltarButton.addActionListener(e -> dispose()); // Fecha a tela do cardápio

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(voltarButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void atualizarLista(DefaultListModel<Prato> listModel) {
        listModel.clear();
        List<Prato> pratos = pratoService.visualizarCardapio();
        for (Prato prato : pratos) {
            listModel.addElement(prato);
        }
    }

    // Classe interna para renderizar os pratos
    private class PratoCellRenderer extends DefaultListCellRenderer {
        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            Prato prato = (Prato) value;

            // Customize the display text
            String texto = String.format("<html><strong>%s</strong><br><span style='font-size:small;'>%s</span><br><span>Preço: R$ %.2f</span></html>", prato.getNome(), prato.getDescricao(), prato.getPreco());
            setText(texto);
            setFont(new Font("Arial", Font.PLAIN, 14));
            setBackground(isSelected ? new Color(200, 200, 255) : Color.WHITE);
            setOpaque(true);
            setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

            return this;
        }
    }
}
