/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.compraonline.cupom;

import com.mycompany.compraonline.loja.Item;
import java.util.List;

/**
 *
 * @author Raphael Sotto-Maior
 */
public class Porcentagem extends CalculaCupom {

    public double aplicarDesconto(List<Item> itens, double total ,double porcentagem) {
        return total*(1 - porcentagem); // `valor` é a porcentagem
    }

    @Override
    public String toString(double valor, double limite) {

        return valor * 100 + "% limitado a " + limite;
    }

}
