package com.restaurante.view;

import javax.swing.*;
import java.awt.*;
import java.util.List;

import com.restaurante.Models.Prato;
import com.restaurante.service.PratoService;

public class CardapioView extends JFrame {
    private PratoService pratoService;

    public CardapioView(JFrame parent) {
        setTitle("Cardápio");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(parent);
        setLayout(new BorderLayout()); // Usando BorderLayout para melhor organização

        pratoService = new PratoService();
        DefaultListModel<Prato> listModel = new DefaultListModel<>();
        JList<Prato> pratoList = new JList<>(listModel);
        pratoList.setCellRenderer(new PratoCellRenderer()); // Customização da lista

        // Carregar os pratos no modelo de lista
        atualizarLista(listModel);

        // ScrollPane para a lista de pratos
        JScrollPane scrollPane = new JScrollPane(pratoList);
        scrollPane.setPreferredSize(new Dimension(550, 300));
        add(scrollPane, BorderLayout.CENTER);

        JButton editarButton = new JButton("Editar");
        JButton excluirButton = new JButton("Excluir");
        JButton voltarButton = new JButton("Voltar"); // Novo botão para voltar

        // Ação para editar prato
        editarButton.addActionListener(e -> {
            Prato pratoSelecionado = pratoList.getSelectedValue();
            if (pratoSelecionado != null) {
                PratoCadastroView cadastroView = new PratoCadastroView(this);
                cadastroView.preencherDados(pratoSelecionado);
                cadastroView.setVisible(true); // Abre a tela de edição do prato
            } else {
                JOptionPane.showMessageDialog(this, "Selecione um prato para editar.");
            }
        });

        // Ação para excluir prato
        excluirButton.addActionListener(e -> {
            Prato pratoSelecionado = pratoList.getSelectedValue();
            if (pratoSelecionado != null) {
                pratoService.excluirPrato(pratoSelecionado.getId());
                JOptionPane.showMessageDialog(this, "Prato excluído com sucesso!");
                atualizarLista(listModel); // Atualiza a lista após exclusão
            } else {
                JOptionPane.showMessageDialog(this, "Selecione um prato para excluir.");
            }
        });

        // Ação para voltar ao menu principal
        voltarButton.addActionListener(e -> {
            dispose(); // Fecha a tela do cardápio
        });

        // Painel de botões
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(editarButton);
        buttonPanel.add(excluirButton);
        buttonPanel.add(voltarButton); // Adiciona o botão de voltar
        add(buttonPanel, BorderLayout.SOUTH); // Adiciona os botões na parte inferior
    }

    private void atualizarLista(DefaultListModel<Prato> listModel) {
        listModel.clear(); // Limpa o modelo antes de atualizar
        List<Prato> pratos = pratoService.visualizarCardapio(); // Obtém a lista de pratos
        for (Prato prato : pratos) {
            listModel.addElement(prato); // Adiciona pratos ao modelo
        }
    }

    // Classe interna para renderizar os pratos
    private class PratoCellRenderer extends DefaultListCellRenderer {
        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            Prato prato = (Prato) value;

            // Customize the display text
            String texto = "<html><strong>" + prato.getNome() + "</strong><br>" +
                           "<span style='font-size:12px;'>" + prato.getDescricao() + "</span><br>" +
                           "<span style='color:green;'>Preço: R$ " + prato.getPreco() + "</span></html>";

            setText(texto); // Atualiza o texto exibido
            setFont(new Font("Arial", Font.PLAIN, 14));
            setBackground(isSelected ? new Color(200, 200, 255) : Color.WHITE); // Cor de fundo ao selecionar
            setOpaque(true);
            setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5)); // Espaçamento interno

            return this;
        }
    }
}
