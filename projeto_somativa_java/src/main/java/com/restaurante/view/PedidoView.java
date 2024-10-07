package com.restaurante.view;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Optional;
import com.restaurante.Models.Prato;
import com.restaurante.Models.Cliente;
import com.restaurante.Models.Pedido;
import com.restaurante.service.PratoService;
import com.restaurante.session.Session;
import com.restaurante.repository.PedidoRepository;

public class PedidoView extends JFrame {
    private PratoService pratoService;
    private PedidoRepository pedidoRepository;

    public PedidoView(JFrame parent, PratoService pratoService, PedidoRepository pedidoRepository) {
        super("Fazer Pedido");
        setSize(600, 400);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        this.pratoService = pratoService;
        this.pedidoRepository = pedidoRepository;

        // Criar painel principal
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        // Visualiza todos os pratos no cardápio
        List<Prato> cardapio = pratoService.visualizarCardapio();
        StringBuilder menu = new StringBuilder("Cardápio:\n");
        for (Prato prato : cardapio) {
            menu.append(String.format("ID: %d, Nome: %s, Preço: R$%.2f, Descrição: %s\n",
                    prato.getId(), prato.getNome(), prato.getPreco(), prato.getDescricao()));
        }

        JTextArea cardapioArea = new JTextArea(menu.toString());
        cardapioArea.setEditable(false);
        cardapioArea.setFont(new Font("Arial", Font.PLAIN, 12));
        JScrollPane scrollPane = new JScrollPane(cardapioArea);
        scrollPane.setPreferredSize(new Dimension(580, 200));
        mainPanel.add(scrollPane);

        // Campo para o ID do prato
        JTextField idField = new JTextField(10);
        mainPanel.add(new JLabel("Digite o ID do prato:"));
        mainPanel.add(idField);

        // Campo para a quantidade
        JTextField quantidadeField = new JTextField(5);
        mainPanel.add(new JLabel("Quantidade:"));
        mainPanel.add(quantidadeField);

        // Botão de enviar pedido
        JButton enviarPedidoButton = new JButton("Enviar Pedido");
        mainPanel.add(enviarPedidoButton);

        // Botão para voltar
        JButton voltarButton = new JButton("Voltar");
        mainPanel.add(voltarButton);

        // Ação do botão de enviar pedido
        enviarPedidoButton.addActionListener(e -> {
            String pratoIdStr = idField.getText();
            String quantidadeStr = quantidadeField.getText();

            if (!pratoIdStr.isEmpty() && !quantidadeStr.isEmpty()) {
                Long pratoId = Long.valueOf(pratoIdStr);
                int quantidade = Integer.parseInt(quantidadeStr);

                // Buscar prato por ID
                Optional<Prato> pratoOpt = pratoService.buscarPratoPorId(pratoId);
                if (pratoOpt.isPresent()) {
                    Prato prato = pratoOpt.get();
                    Pedido pedido = new Pedido();

                    // Pegar o ID do cliente logado da sessão
                    Long clienteId = Session.getClienteId();
                    if (clienteId != null) {
                        Cliente cliente = new Cliente();
                        cliente.setId(clienteId);
                        pedido.setCliente(cliente); // Agora setamos o cliente corretamente
                    } else {
                        JOptionPane.showMessageDialog(this,
                                "Cliente não está logado!", "Erro", JOptionPane.ERROR_MESSAGE);
                        return; // Não prosseguir se o cliente não está logado
                    }

                    pedido.setPrato(prato);
                    pedido.setQuantidade(quantidade);
                    pedido.setTotal(prato.getPreco() * quantidade);

                    // Salvar o pedido no banco de dados
                    pedidoRepository.save(pedido);

                    JOptionPane.showMessageDialog(this,
                            "Pedido do prato " + prato.getNome() + " (Quantidade: " + quantidade
                                    + ") realizado com sucesso!",
                            "Pedido", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this,
                            "Prato não encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this,
                        "Por favor, preencha todos os campos.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Ação do botão voltar
        voltarButton.addActionListener(e -> {
            // Aqui você pode adicionar a lógica para voltar à página inicial do cliente
            this.dispose(); // Fecha a janela atual
            // Você pode abrir a janela inicial do cliente aqui, se necessário
            new ClienteView().setVisible(true); // Exemplo de como abrir a ClienteView
        });

        // Adiciona o painel principal à janela
        add(mainPanel, BorderLayout.CENTER);
    }
}