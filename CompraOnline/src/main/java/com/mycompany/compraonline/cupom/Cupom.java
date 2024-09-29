package com.mycompany.compraonline.cupom;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Raphael Sotto-Maior 201365385AI
 */

import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;

public abstract class Cupom {

    protected double valor;
    protected double limite;
    protected String categoria;
    protected String tipo;
    protected JRadioButton botaoCupom;
    private static ButtonGroup grupodebotoes = new ButtonGroup();
    protected static JRadioButton botaoFantasma = new JRadioButton();

    static {
        grupodebotoes.add(botaoFantasma);
    }

    protected CalculaCupom calculacupom;

    public Cupom(double valor, double limite, String categoria, CalculaCupom calculacupom) {
        this.valor = valor;
        this.limite = limite;
        this.categoria = categoria;
        this.calculacupom = calculacupom;
        this.botaoCupom = new JRadioButton(this.toString());

        grupodebotoes.add(this.botaoCupom);

    }

    public JRadioButton getBotaoCupom() {
        return botaoCupom;
    }

    public abstract double aplicarCupom(double valor);

    @Override
    public String toString() {
        return "Geral " + "valor: " + valor + ", limite: " + limite + ", categoria=" + categoria + '}';
    }

}
