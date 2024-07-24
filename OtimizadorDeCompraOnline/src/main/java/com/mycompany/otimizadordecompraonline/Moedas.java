/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.otimizadordecompraonline;

import java.io.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Raphael Sotto-Maior
 */
public class Moedas {

    private Moeda primeira;

    public void addMoeda(LocalDate data) {

        Moeda nova = new Moeda(data);
        if (primeira == null) {

            primeira = nova;
        } else {

            Moeda atual = primeira;
            while (atual.getProxima() != null) {
                atual = atual.getProxima();
            }

            atual.setProxima(nova);
        }
    }

    public void listarMoedas() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/YYYY");
        Moeda atual = primeira;
        int contador = 1;
        while (atual != null) {
            System.out.println("Moeda " + contador + ": Data = " + atual.getData().format(formato) + ", Data de Validade = " + atual.getDataValidade().format(formato));
            atual = atual.getProxima();
            contador++;
        }
    }

    public void lerMoedasDeArquivo(String caminhoDoArquivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoDoArquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                LocalDate data = LocalDate.parse(linha);
                addMoeda(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}