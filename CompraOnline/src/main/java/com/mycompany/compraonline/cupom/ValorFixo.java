/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Raphael Sotto-Maior
 */
package com.mycompany.compraonline.cupom;

import com.mycompany.compraonline.loja.Item;
import java.util.List;
import javax.swing.JOptionPane;

public class ValorFixo extends CalculaCupom {

    @Override
    public double calcularCupom(double total, double desconto, double limite) {

        if (total > limite) {
            return total - desconto;
        } else {
            JOptionPane.showMessageDialog(null, "Valor insuficiente para aplicar o desconto. Limite mínimo: R$" + limite,
                    "Erro", JOptionPane.ERROR_MESSAGE);
            Cupom.botaoFantasma.setSelected(true);
            return total;
        }

    }

    @Override
    public String toString(double valor, double limite) {
        return valor + " em compras minimas de " + limite;
    }

}
