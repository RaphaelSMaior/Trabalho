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

    @Override
    public double calcularCupom(double total, double valor, double limite) {
        return total - Math.min(total * valor, limite);
    }

    @Override
    public String toString(double valor, double limite) {

        return valor * 100 + "% limitado a " + limite;
    }

}
