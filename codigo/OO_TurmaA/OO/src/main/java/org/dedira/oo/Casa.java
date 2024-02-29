package org.dedira.oo;

public class Casa extends Moradia {

    public Casa() {
        this.setCnpjDoCapitalistaSafado("00000000000000");
    }

    @Override
    public void abrirPorta() {
        System.out.println("Abre a porta mariquinha");
    }

}
