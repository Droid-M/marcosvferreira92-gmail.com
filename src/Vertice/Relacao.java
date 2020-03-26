package Vertice;

public class Relacao {

    private int peso;
    private String pai;
    private boolean visitado;

    public Relacao(String verticePai, int pesoLigacao) {
        this.pai = verticePai;
        this.peso = pesoLigacao;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public String getPai() {
        return pai;
    }

    public void setPai(String pai) {
        this.pai = pai;
    }

    public void setVisitado(boolean percorrido) {
        this.visitado = percorrido;
    }

    public boolean getVisitado() {
        return this.visitado;
    }
}
