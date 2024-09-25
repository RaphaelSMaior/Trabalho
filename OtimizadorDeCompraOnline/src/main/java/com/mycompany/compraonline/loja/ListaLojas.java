/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.compraonline.loja;

/**
 *
 * @author Raphael Sotto-Maior
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ListaLojas {
    private Map<String, Loja> lojas;

    public ListaLojas() {
        lojas = new HashMap<>();
    }

    public void lerItens(String arquivo) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(arquivo));
        String linha;
        while ((linha = reader.readLine()) != null) {
            String[] dados = linha.split(";");
            String nomeItem = dados[0].trim();
            double preco = Double.parseDouble(dados[1].trim());
            String nomeLoja = dados[2].trim();
            String categoria = dados[3].trim();

            Item item = new Item(nomeItem, categoria, preco);

            if (!lojas.containsKey(nomeLoja)) {
                lojas.put(nomeLoja, new Loja(nomeLoja));
            }
            lojas.get(nomeLoja).adicionarItem(item);
        }
        reader.close();
    }

    public Map<String, Loja> getLojas() {
        return lojas;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Loja loja : lojas.values()) {
            sb.append(loja.toString()).append("\n");
        }
        return sb.toString();
    }
}