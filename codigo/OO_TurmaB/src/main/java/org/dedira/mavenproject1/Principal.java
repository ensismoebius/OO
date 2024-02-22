/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.dedira.mavenproject1;

/**
 *
 * @author ensismoebius
 */
public class Principal {
    public static void main(String[] args) {
        RetroEscavadeira zizinha = new RetroEscavadeira();
        zizinha.diametroDaRoda = 10;
        zizinha.placa = "45604505";
        zizinha.dirigir("Joana", "Rua da pera");
    }
    
}
