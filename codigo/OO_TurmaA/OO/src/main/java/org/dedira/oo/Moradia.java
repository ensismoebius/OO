package org.dedira.oo;

public class Moradia {

    public String cor;
    public int qtdeDePisos;
    protected int anoDeConstrucao;
    private String cnpjDoCapitalistaSafado;

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

    public void abrirPorta() {
        System.out.println("Nheeeeeeee.....");
    }

    public void exibeInformacoes() {
        System.out.println("Ano:" + anoDeConstrucao + " Cor:" + cor + " Pisos:" + qtdeDePisos + " Cnpj: " + this.cnpjDoCapitalistaSafado);
    }

    public String getCnpjDoCapitalistaSafado() {
        return cnpjDoCapitalistaSafado;
    }

    public boolean setCnpjDoCapitalistaSafado(String cnpjDoCapitalistaSafado) {

        if (cnpjDoCapitalistaSafado.length() == 14) {
            this.cnpjDoCapitalistaSafado = cnpjDoCapitalistaSafado;
            return true;

        }
        return false;
    }
}
