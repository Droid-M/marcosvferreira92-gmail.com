package Vertice;

import ListaEncadeada.ListaEncadeada;
import ListaEncadeada.No;

public class Adjacentes extends ListaEncadeada<Vertice> {

    private int qtdVertices = 0;
    ListaEncadeada<Integer> pesosLigacoes = new ListaEncadeada();

    public boolean adicionaAdjacente(Vertice novoVertice, String nomeVertice, int pesoLigacao) {
        Vertice verticeAdicionado = super.adiciona(novoVertice, nomeVertice);
        pesosLigacoes.adiciona(pesoLigacao, nomeVertice);
        boolean novaAdicao = novoVertice.equals(verticeAdicionado);
        qtdVertices = novaAdicao ? qtdVertices + 1 : qtdVertices;
        return novaAdicao;
    }

    public boolean removeAdjacente(String nomeVertice) {
        pesosLigacoes.remove(nomeVertice);
        boolean novaRemocao = super.remove(nomeVertice) != null;
        qtdVertices = novaRemocao ? qtdVertices - 1 : qtdVertices;
        return novaRemocao;
    }

    public Vertice[] getTodosAdjacentes() {
        Vertice[] verticesTotais = new Vertice[qtdVertices];
        int i = 0;
        No<Vertice> noAux = super.getPrimeiraColuna();
        while (noAux != null) {
            verticesTotais[i] = noAux.getDado();
            i++;
            noAux = noAux.getProximo();
        }
        return verticesTotais;
    }

    public int getQuantidadeVertices() {
        return qtdVertices;
    }

    public int getPesoLigacaoCom(Vertice v) {
        String nomeVertice = v.getNome();
        Integer peso = pesosLigacoes.busca(nomeVertice);
        if (peso != null) {
            return peso;
        }
        return -1;
    }

    Adjacentes clonagem() {
        No<Vertice> noAux = super.getPrimeiraColuna();
        No<Integer> noAux2 = pesosLigacoes.getPrimeiraColuna();
        Adjacentes clone = new Adjacentes();
        while (noAux != null && noAux2 != null) {
            clone.adicionaAdjacente(noAux.getDado(), noAux.getIdentificador(), noAux2.getDado());
            noAux = noAux.getProximo();
            noAux2 = noAux2.getProximo();
        }
        return clone;
    }

}
