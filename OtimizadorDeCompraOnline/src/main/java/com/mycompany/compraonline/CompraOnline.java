/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.otimizadordecompraonline;

import com.mycompany.otimizadordecompraonline.cupom.ListaCupons;
import java.io.IOException;


/**
 *
 * @author Raphael Sotto-Maior
 */
public class OtimizadorDeCompraOnline {
    

    public static void main(String[] args) throws IOException {
        
        Carrinho carrinho = new Carrinho("../carrinho.txt");
        ListaCupons lista = new ListaCupons("../listacupons.txt");

        // Caminho para o arquivo com a lista de itens
        System.out.println(carrinho.toString());        
        System.out.println(lista.toString());


        Moedas moedas = new Moedas("../listamoedas.txt");
        Display display = new Display(moedas,carrinho,lista);
    }
}
