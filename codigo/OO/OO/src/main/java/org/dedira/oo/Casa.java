/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.dedira.oo;

/**
 *
 * @author ensismoebius
 */
public class Casa {

    public String cor;
    public int qtdeDePisos;
    private int anoDeConstrucao;

    public void abrirPorta() {
        System.out.println("Nheeeeeeee.....");
    }

    public int getAnoDeConstrucao() {
        return this.anoDeConstrucao;
    }

    public boolean setAnoDeConstrucao(int anoDeConstrucao) {

        if (anoDeConstrucao < 0) {
            return false;
        }

        this.anoDeConstrucao = anoDeConstrucao;
        return true;
    }

    public void exibeInformacoes() {
        System.out.println("Ano:" + anoDeConstrucao + " Cor:" + cor + " Pisos:" + qtdeDePisos);
    }
}
