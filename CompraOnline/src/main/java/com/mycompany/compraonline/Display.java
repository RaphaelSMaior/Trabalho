/**
 *
 * @author Raphael Sotto-Maior
 */
package com.mycompany.compraonline;

import com.mycompany.compraonline.cupom.Cupom;
import com.mycompany.compraonline.cupom.ListaCupons;
import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import com.mycompany.compraonline.loja.Loja;
import com.mycompany.compraonline.loja.Item;

public class Display extends JFrame {

    private Map<Item, JCheckBox> selecaoItens; // Mapeamento de itens e seus respectivos checkboxes
    private JLabel totalLabel; // Label para exibir o total
    private ListaCupons listaCupons;
    private Moedas moedas;

    // Construtor
    public Display(Moedas moedas, Carrinho carrinho, ListaCupons listaCupons) {

        this.listaCupons = listaCupons;
        this.moedas = moedas;
        configureJanela();

        adicionarItensAoPainel(carrinho);

        adicionarCuponsAoPainel();
        setVisible(true);
    }

    // Método responsável pela configuração inicial da janela
    private void configureJanela() {
        setTitle("Compras Online");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(new BorderLayout());

        JCheckBox checkboxMoedas = this.moedas.getBotao();
        checkboxMoedas.addActionListener(e -> atualizarTotalItens()); // Atualiza o total quando o checkbox de moedas é marcado
        add(checkboxMoedas, BorderLayout.NORTH);

        selecaoItens = new HashMap<>(); // Inicializa o mapeamento de itens e checkboxes

        // Adiciona o total dos itens selecionados no canto superior direito
        totalLabel = new JLabel();
        totalLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        add(totalLabel, BorderLayout.EAST);

        JButton botaoConfirmar = new JButton("Confirmar Seleção");
        botaoConfirmar.addActionListener(e -> confirmarSelecao());
        add(botaoConfirmar, BorderLayout.WEST);

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
            selecaoItens.put(item, checkBox); // Mapeia o item ao checkbox correspondente
            checkBox.addActionListener(e -> atualizarTotalItens()); // Atualiza o total ao alterar a seleção

            itemPanel.add(checkBox);
            painel.add(itemPanel);
        }
    }

    // Método para adicionar os cupons no painel inferior
    private void adicionarCuponsAoPainel() {
        JPanel painelCupons = new JPanel();
        painelCupons.setLayout(new BoxLayout(painelCupons, BoxLayout.Y_AXIS));

        JLabel labelCupons = new JLabel("Seleção de Cupons:");
        painelCupons.add(labelCupons);

        for (Cupom cupom : listaCupons.getCupons()) {
            painelCupons.add(cupom.getBotaoCupom()); // Obtém o botão diretamente do cupom
            cupom.getBotaoCupom().addActionListener(e -> atualizarTotalItens());
        }

        JScrollPane scrollPaneCupons = new JScrollPane(painelCupons);
        scrollPaneCupons.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPaneCupons.setPreferredSize(new Dimension(400, 200));
        add(scrollPaneCupons, BorderLayout.SOUTH);
    }


    // Método que exibe os itens e cupons selecionados
    private void confirmarSelecao() {
        StringBuilder itensSelecionados = selecionaItens();
        StringBuilder cuponsSelecionados = selecionaCupom();
        String moedasSelecionadas = "Usar Moedas: " + (moedas.getBotao().isSelected() ? moedas.getMoedas() : 0);

        JOptionPane.showMessageDialog(this, itensSelecionados.toString() + cuponsSelecionados.toString() + "\n" + moedasSelecionadas,
                "Seleção", JOptionPane.INFORMATION_MESSAGE);
    }

    // Obtém os itens selecionados
    private StringBuilder selecionaItens() {
        StringBuilder itensSelecionados = new StringBuilder("Itens Selecionados:\n");
        for (Map.Entry<Item, JCheckBox> entry : selecaoItens.entrySet()) {
            if (entry.getValue().isSelected()) {
                itensSelecionados.append(entry.getKey().toString()).append("\n");
            }
        }
        return itensSelecionados;
    }

    // Obtém o cupom selecionado (apenas um cupom pode ser selecionado)
    private StringBuilder selecionaCupom() {
        StringBuilder cuponsSelecionados = new StringBuilder("Cupom Selecionado:\n");
        for (Cupom cupom : this.listaCupons.getCupons()) {
            if (cupom.getBotaoCupom().isSelected()) {
                cuponsSelecionados.append(cupom.toString()).append("\n");
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

        if (moedas.getBotao().isSelected()) {
            total = moedas.usarMoedas(total);
        }
        // Aplica o cupom selecionado ao total
        for (Cupom cupom : listaCupons.getCupons()) {
            if (cupom.getBotaoCupom().isSelected()) {
                total = cupom.aplicarCupom(total);
            }
        }
        totalLabel.setText("Total: R$" + String.format("%.2f", total));
    }
}
