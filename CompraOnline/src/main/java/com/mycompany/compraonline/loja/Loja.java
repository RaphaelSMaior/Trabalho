/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.compraonline.loja;

/**
 *
 * @author Raphael Sotto-Maior 201365385AI
 */

import java.util.ArrayList;
import java.util.List;

public class Loja {
    private String nome;
    private List<Item> itens;

    // Construtor
    public Loja(String nome) {
        this.nome = nome;
        this.itens = new ArrayList<>();
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void adicionarItem(Item item) {
        this.itens.add(item);
    }

    // Método toString
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Loja: ").append(nome).append("\n");
        for (Item item : itens) {
            sb.append(item.toString()).append("\n");
        }
        return sb.toString();
    }
}