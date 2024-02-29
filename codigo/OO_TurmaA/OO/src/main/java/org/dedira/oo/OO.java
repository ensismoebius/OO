package org.dedira.oo;

public class OO {

    public static void main(String[] args) {

        Moradia minhaCasa = new Moradia();
        minhaCasa.setAnoDeConstrucao(2024);
        minhaCasa.cor = "Rosa";
        minhaCasa.qtdeDePisos = 1;
        minhaCasa.abrirPorta();
        minhaCasa.exibeInformacoes();

        Casa casaAmarela = new Casa();
        casaAmarela.setAnoDeConstrucao(2017);
        casaAmarela.cor = "Amarela";
        casaAmarela.qtdeDePisos = 2;
        casaAmarela.abrirPorta();
        casaAmarela.exibeInformacoes();
        
        Apartamento meuAp = new Apartamento();
        meuAp.setAnoDeConstrucao(2017);
        meuAp.cor = "Branco";
        meuAp.qtdeDePisos = 1;
        meuAp.abrirPorta();
        meuAp.subirDeElevador();
        meuAp.exibeInformacoes();
    }
}
