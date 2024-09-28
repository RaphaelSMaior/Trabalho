/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.compraonline;

import java.io.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import javax.swing.JCheckBox;

/**
 *
 * @author Raphael Sotto-Maior
 */
public class Moedas {

    private int moedas;
    private JCheckBox botao;

    public int getMoedas() {
        return moedas;
    }

    public JCheckBox getBotao() {
        return botao;
    }

    public Moedas(String path) {
        this.moedas = 0;
        lerMoedasDeArquivo(path);
        this.botao = new JCheckBox("Usar Moedas (" + this.moedas+ ")");
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
    
    public double usarMoedas(double valor){
        
        double m = (double)this.moedas/100;
        if (m<=0.25*valor){
            return valor - m;
        }else{
            return valor*0.75;
        }
        
    }

    @Override
    public String toString() {
        return Integer.toString(moedas);
    }
    
    
}