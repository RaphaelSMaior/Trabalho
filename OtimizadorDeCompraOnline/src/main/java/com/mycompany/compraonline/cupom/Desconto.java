/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.compraonline.cupom;

/**
 *
 * @author Raphael Sotto-Maior
 */
public class Desconto extends Cupom {

    public Desconto(double valor, double limite, String categoria, CalculaCupom calculacupom) {
        super(valor, limite, categoria, calculacupom);
    }

    @Override
    public String toString() {
        return "Cupom de desconto no valor de " + calculacupom.toString(valor,limite);
    }

    


    
}
