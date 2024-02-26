/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.dedira.mavenproject1;

/**
 *
 * @author ensismoebius
 */
public class RetroEscavadeira {

    public int diametroDaRoda;
    public String placa;
    private String banco;
    private String motor;
    
    // Criar um método e uma propriedade nessa classe

    private void cavar(String terreno) {
        System.out.println("Cavei " + terreno);
    }

    public void dirigir(String motorista, String terreno) {

        if (!motorista.isEmpty()) {
            cavar(terreno);
        }
    }

}
