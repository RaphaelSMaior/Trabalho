/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.compraonline;

/**
 *
 * @author Raphael Sotto-Maior
 */

import com.mycompany.compraonline.loja.Item;
import com.mycompany.compraonline.loja.ListaLojas;
import com.mycompany.compraonline.loja.Loja;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Carrinho {

    private ListaLojas listaLojas;

    // Construtor
    public Carrinho(String arquivo) throws IOException {
        listaLojas = new ListaLojas(arquivo);
    }

    public Map<String, Loja> getLojas() {
        return listaLojas.getLojas();
    }

    // Método para ler arquivo com lista de itens e lojas
    

    // Método para exibir os itens organizados por loja

    public void exibirCarrinho() {
        System.out.println(listaLojas.toString());
    }

    @Override
    public String toString() {
        return listaLojas.toString();
    }

}
