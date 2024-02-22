/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package org.dedira.oo;

/**
 *
 * @author ensismoebius
 */
public class OO {

    public static void main(String[] args) {
        
        Casa minhaCasa = new Casa();
        minhaCasa.setAnoDeConstrucao(2024);
        minhaCasa.cor = "Rosa";
        minhaCasa.qtdeDePisos = 1;
        
        minhaCasa.exibeInformacoes();
    }
}
