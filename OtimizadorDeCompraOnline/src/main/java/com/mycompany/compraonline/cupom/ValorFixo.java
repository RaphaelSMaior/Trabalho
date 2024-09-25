/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.otimizadordecompraonline.cupom;

import com.mycompany.otimizadordecompraonline.loja.Item;
import java.util.List;

/**
 *
 * @author Raphael Sotto-Maior
 */
public class ValorFixo extends CalculaCupom {

    public double aplicarDesconto(List<Item> itens, double total, double desconto) {
        return total - Math.min(desconto, total); // Aplica o valor fixo de desconto
    }

    @Override
    public String toString(double valor, double limite) {
        return valor + " em compras minimas de " + limite;
    }

}
