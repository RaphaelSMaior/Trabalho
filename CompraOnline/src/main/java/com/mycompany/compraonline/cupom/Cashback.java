/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Raphael Sotto-Maior 201365385AI
 */
package com.mycompany.compraonline.cupom;

public class Cashback extends Cupom {

    public Cashback(double valor, double limite, String categoria, CalculaCupom calculacupom) {
        super(valor, limite, categoria, calculacupom);
    }

    @Override
    public String toString() {
        return "Cupom de cashback no valor de " + this.calculacupom.toString(this.valor, this.limite);
    }

    @Override
    public double aplicarCupom(double valor) {
        return valor;
    }




    
}
