/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.otimizadordecompraonline.cupom;

/**
 *
 * @author Raphael Sotto-Maior
 */
public class Cashback extends Cupom {

    public Cashback(double valor, double limite, String categoria, CalculaCupom calculacupom) {
        super(valor, limite, categoria, calculacupom);
    }



    @Override
    public String toString() {
        return "Cupom de cashback no valor de " + this.calculacupom.toString(this.valor, this.limite);
    }




    
}
