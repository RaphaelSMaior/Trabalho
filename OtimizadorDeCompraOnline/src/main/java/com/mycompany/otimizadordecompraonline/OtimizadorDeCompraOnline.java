/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.otimizadordecompraonline;

/**
 *
 * @author Raphael Sotto-Maior
 */
public class OtimizadorDeCompraOnline {

    public static void main(String[] args) {
        Moedas moedas = new Moedas();
        moedas.lerMoedasDeArquivo("../listamoedas.txt");
        System.out.println("Moedas lidas do arquivo:");
        moedas.listarMoedas();
    }
}
