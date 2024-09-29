/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

/**
 *
 * @author Raphael Sotto-Maior 201365385AI
 */
package com.mycompany.compraonline;

import com.mycompany.compraonline.cupom.ListaCupons;
import java.io.IOException;


public class CompraOnline {
    

    public static void main(String[] args) throws IOException {
        
        Carrinho carrinho = new Carrinho("carrinho.txt");
        ListaCupons lista = new ListaCupons("listacupons.txt");



        Moedas moedas = new Moedas("listamoedas.txt");
        Display display = new Display(moedas,carrinho,lista);
    }
}
