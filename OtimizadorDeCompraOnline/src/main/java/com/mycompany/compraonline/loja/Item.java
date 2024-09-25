/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.compraonline.loja;

/**
 *
 * @author Raphael Sotto-Maior
 */

public class Item {
    private String nome;
    private String categoria;
    private double preco;

    // Construtor
    public Item(String nome, String categoria, double preco) {
        this.nome = nome;
        this.categoria = categoria;
        this.preco = preco;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    // Método toString
    @Override
    public String toString() {
        return String.format("Item: %s, Categoria: %s, Preço: R$ %.2f", nome, categoria, preco);
    }
}
