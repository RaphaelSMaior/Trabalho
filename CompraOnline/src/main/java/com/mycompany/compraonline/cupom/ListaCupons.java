/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Raphael Sotto-Maior 201365385AI
 */
package com.mycompany.compraonline.cupom;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ListaCupons {

    private ArrayList<Cupom> cupons;

    public ListaCupons(String caminhoArquivo) throws IOException {
        cupons = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            String categoria;
            String valorString;
            String tipo;
            double limite;
            double valor;
            CalculaCupom calculacupom;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(" ");

                // Categoria, valor, tipo, limite
                categoria = dados[0];
                valorString = dados[1];
                tipo = dados[2];
                limite = Double.parseDouble(dados[3]);

                if (valorString.endsWith("%")) {
                    valor = Double.parseDouble(valorString.replace("%", "")) / 100;
                    calculacupom = new Porcentagem();
                } else {
                    valor = Double.parseDouble(valorString);
                    calculacupom = new ValorFixo();
                }

                if (tipo.equalsIgnoreCase("cashback")) {
                    cupons.add(new Cashback(valor, limite, categoria, calculacupom));
                } else if (tipo.equalsIgnoreCase("off")) {
                    cupons.add(new Desconto(valor, limite, categoria, calculacupom));
                }
            }
        }
    }


    public ArrayList<Cupom> getCupons() {
        return cupons;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Lista de Cupons:\n");
        for (Cupom cupom : cupons) {
            sb.append(cupom).append("\n");
        }
        return sb.toString();
    }
}
