/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.otimizadordecompraonline.cupom;

/**
 *
 * @author Raphael Sotto-Maior
 */
public abstract class Cupom {

    protected double valor;
    protected double limite;
    protected String categoria;
    protected String tipo;
    
    protected CalculaCupom calculacupom;

    public Cupom(double valor, double limite, String categoria, CalculaCupom calculacupom) {
        this.valor = valor;
        this.limite = limite;
        this.categoria = categoria;
        this.calculacupom = calculacupom;
    }

    @Override
    public String toString() {
        return "Geral " + "valor: " + valor + ", limite: " + limite + ", categoria=" + categoria + '}';
    }


}

