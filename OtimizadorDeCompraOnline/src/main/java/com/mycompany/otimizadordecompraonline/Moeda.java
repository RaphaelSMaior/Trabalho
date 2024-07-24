/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.otimizadordecompraonline;

import java.time.*;

/**
 *
 * @author Raphael Sotto-Maior
 */
public class Moeda {

    private LocalDate data;
    private LocalDate dataValidade;

    Moeda proxima;

    public Moeda(LocalDate data) {

        this.data = data;
        this.dataValidade = YearMonth.from(data).plusMonths(2).atEndOfMonth();
        this.proxima = null;

    }

    public void setProxima(Moeda proxima) {

        this.proxima = proxima;
    }

    public Moeda getProxima() {

        return proxima;
    }

    public LocalDate getData() {
        return data;
    }

    public LocalDate getDataValidade() {
        return dataValidade;
    }

}
