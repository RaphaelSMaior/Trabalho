/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Raphael Sotto-Maior 201365385AI
 */
package com.mycompany.compraonline.cupom;

import javax.swing.JOptionPane;

public class Desconto extends Cupom {

    public Desconto(double valor, double limite, String categoria, CalculaCupom calculacupom) {
        super(valor, limite, categoria, calculacupom);
    }

    @Override
    public String toString() {
        return "Cupom de desconto no valor de " + calculacupom.toString(valor, limite);
    }

    @Override
    public double aplicarCupom(double valor) {

        return this.calculacupom.calcularCupom(valor, this.valor, this.limite);
        
    }
}

