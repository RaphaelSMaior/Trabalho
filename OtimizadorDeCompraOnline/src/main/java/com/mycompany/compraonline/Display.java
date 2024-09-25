package com.mycompany.otimizadordecompraonline;

import com.mycompany.otimizadordecompraonline.cupom.Cupom;
import com.mycompany.otimizadordecompraonline.cupom.ListaCupons;
import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import com.mycompany.otimizadordecompraonline.loja.Loja;
import com.mycompany.otimizadordecompraonline.loja.Item;

public class Display extends JFrame {

    // Mapas para armazenar as seleções de itens e cupons
    private Map<Item, JCheckBox> selecaoItens;
    private Map<Cupom, JRadioButton> selecaoCupons;
    private JLabel totalLabel;
    private ButtonGroup grupoCupons; // Para garantir que apenas um cupom seja selecionado

    // Construtor
    public Display(Moedas moedas, Carrinho carrinho, ListaCupons listaCupons) {
        configureJanela(moedas);
        adicionarItensAoPainel(carrinho);
        adicionarCuponsAoPainel(listaCupons);
        adicionarBotaoConfirmar();
        setVisible(true);
    }

    // Método responsável pela configuração inicial da janela
    private void configureJanela(Moedas moedas) {
        setTitle("Otimizador de Compras");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(new BorderLayout());

        // Exibe a quantidade de moedas válidas
        JLabel labelQuantidade = new JLabel("Quantidade de moedas válidas: " + moedas);
        labelQuantidade.setHorizontalAlignment(SwingConstants.CENTER);
        add(labelQuantidade, BorderLayout.NORTH);

        selecaoItens = new HashMap<>();
        selecaoCupons = new HashMap<>();
        grupoCupons = new ButtonGroup(); // Inicializa o grupo de cupons

        // Adiciona o total dos itens selecionados no canto superior direito
        totalLabel = new JLabel();
        totalLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        add(totalLabel, BorderLayout.EAST);

        atualizarTotalItens();
    }

    // Método para adicionar os itens do carrinho no painel central
    private void adicionarItensAoPainel(Carrinho carrinho) {
        JPanel painelItens = new JPanel();
        painelItens.setLayout(new BoxLayout(painelItens, BoxLayout.Y_AXIS));

        for (Loja loja : carrinho.getLojas().values()) {
            adicionarItensDaLoja(painelItens, loja);
        }

        JScrollPane scrollPaneItens = new JScrollPane(painelItens);
        add(scrollPaneItens, BorderLayout.CENTER);
    }

    // Adiciona os itens de uma loja específica no painel
    private void adicionarItensDaLoja(JPanel painel, Loja loja) {
        JLabel labelLoja = new JLabel("Loja: " + loja.getNome());
        painel.add(labelLoja);

        for (Item item : loja.getItens()) {
            JPanel itemPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            JCheckBox checkBox = new JCheckBox(item.toString());
            selecaoItens.put(item, checkBox);
            checkBox.addActionListener(e -> atualizarTotalItens()); // Atualiza o total ao alterar a seleção

            itemPanel.add(checkBox);
            painel.add(itemPanel);
        }
    }

    // Método para adicionar os cupons no painel inferior
    private void adicionarCuponsAoPainel(ListaCupons listaCupons) {
        JPanel painelCupons = new JPanel();
        painelCupons.setLayout(new BoxLayout(painelCupons, BoxLayout.Y_AXIS));

        JLabel labelCupons = new JLabel("Seleção de Cupons:");
        painelCupons.add(labelCupons);

        for (Cupom cupom : listaCupons.getCupons()) {
            adicionarCupomNoPainel(painelCupons, cupom);
        }

        JScrollPane scrollPaneCupons = new JScrollPane(painelCupons);
        scrollPaneCupons.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); // Sempre mostra a barra de rolagem
        scrollPaneCupons.setPreferredSize(new Dimension(400, 200));
        add(scrollPaneCupons, BorderLayout.SOUTH);
    }

    // Adiciona um cupom no painel de cupons (com seleção exclusiva)
    private void adicionarCupomNoPainel(JPanel painel, Cupom cupom) {
        JPanel cupomPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JRadioButton radioButtonCupom = new JRadioButton(cupom.toString());
        selecaoCupons.put(cupom, radioButtonCupom);
        grupoCupons.add(radioButtonCupom); // Adiciona o radio button ao grupo para garantir seleção única

        cupomPanel.add(radioButtonCupom);
        painel.add(cupomPanel);
    }

    // Método para adicionar o botão de confirmação
    private void adicionarBotaoConfirmar() {
        JButton botaoConfirmar = new JButton("Confirmar Seleção");
        botaoConfirmar.addActionListener(e -> confirmarSelecao());
        add(botaoConfirmar, BorderLayout.WEST);
    }

    // Método que exibe os itens e cupons selecionados
    private void confirmarSelecao() {
        StringBuilder itensSelecionados = obterItensSelecionados();
        StringBuilder cuponsSelecionados = obterCuponsSelecionados();

        JOptionPane.showMessageDialog(this, itensSelecionados.toString() + cuponsSelecionados.toString(),
                "Seleção", JOptionPane.INFORMATION_MESSAGE);
    }

    // Obtém os itens selecionados
    private StringBuilder obterItensSelecionados() {
        StringBuilder itensSelecionados = new StringBuilder("Itens Selecionados:\n");
        for (Map.Entry<Item, JCheckBox> entry : selecaoItens.entrySet()) {
            if (entry.getValue().isSelected()) {
                itensSelecionados.append(entry.getKey().toString()).append("\n");
            }
        }
        return itensSelecionados;
    }

    // Obtém o cupom selecionado (apenas um cupom pode ser selecionado)
    private StringBuilder obterCuponsSelecionados() {
        StringBuilder cuponsSelecionados = new StringBuilder("Cupom Selecionado:\n");
        for (Map.Entry<Cupom, JRadioButton> entry : selecaoCupons.entrySet()) {
            if (entry.getValue().isSelected()) {
                cuponsSelecionados.append(entry.getKey().toString()).append("\n");
                break; // Apenas um cupom pode ser selecionado
            }
        }
        return cuponsSelecionados;
    }

    // Método para atualizar o total dos itens selecionados em tempo real
    private void atualizarTotalItens() {
        double total = 0;
        for (Map.Entry<Item, JCheckBox> entry : selecaoItens.entrySet()) {
            if (entry.getValue().isSelected()) {
                total += entry.getKey().getPreco(); // Supondo que o método getPreco exista em Item
            }
        }
        totalLabel.setText("Total: R$" + String.format("%.2f", total));
    }
}
