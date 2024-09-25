/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.compraonline;

import java.io.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Raphael Sotto-Maior
 */
public class Moedas {

    private int moedas;

    public Moedas(String path) {
        this.moedas = 0;
        lerMoedasDeArquivo(path);
    }

    public void lerMoedasDeArquivo(String caminhoDoArquivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoDoArquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                LocalDate data = LocalDate.parse(linha);
                if(LocalDate.now().isAfter(YearMonth.from(data).plusMonths(2).atEndOfMonth())){
                   
                }else{
                    
                    this.moedas++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return Integer.toString(moedas);
    }
    
    
}