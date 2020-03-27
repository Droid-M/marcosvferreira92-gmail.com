package grafo;

import ListaEncadeada.ListaEncadeada;
import ListaEncadeada.No;
import Vertice.Vertice;
import java.util.LinkedList;

public class Grafo {

    int numeroLinhasColunas = 0;
    ListaEncadeada<ListaEncadeada> colunas;
    LinkedList<Vertice> vertices;

    public Grafo() {
        this.colunas = new ListaEncadeada();
    }

    public boolean adicionaVertice(String nomeVertice) {
        int tamanhoMatrizAntes = colunas.getTamanho();
        adicionaColunasELinhas(nomeVertice);
        if (tamanhoMatrizAntes != colunas.getTamanho()) {
            numeroLinhasColunas++;
            return true;
        }
        return false;
    }

    public boolean removeVertice(String nomeVertice) {
        boolean remocaoEfetuada = true;
        remocaoEfetuada = colunas.remove(nomeVertice) == null ? false : remocaoEfetuada;
        No<ListaEncadeada> noAux = colunas.getRaiz();
        while (noAux != null) {
            ListaEncadeada<Integer> noAux2 = noAux.getDado();
            remocaoEfetuada = noAux2.remove(nomeVertice) == null ? false : remocaoEfetuada;
            noAux = noAux.getProximo();
        }
        if (remocaoEfetuada) {
            numeroLinhasColunas--;
        }
        return remocaoEfetuada;
    }

    private ListaEncadeada<Integer> criaLinhas(ListaEncadeada<Integer> penultimaColuna, String nomeVertice) {
        ListaEncadeada<Integer> linhasCriadas = new ListaEncadeada();
        String nomeLinha;
        if (penultimaColuna != null) {
            No<Integer> noAux = penultimaColuna.getRaiz();
            for (int i = 1; i < penultimaColuna.getTamanho(); i++) {
                nomeLinha = noAux.getIdentificador();
                linhasCriadas.adiciona(Integer.MAX_VALUE, nomeLinha);
                noAux = noAux.getProximo();
            }
            nomeLinha = noAux.getIdentificador();
        }
        else {
            nomeLinha = nomeVertice;
        }
        linhasCriadas.adiciona(0, nomeLinha);
        return linhasCriadas;
    }

    private void adicionaColunasELinhas(String nomeVertice) {
        ListaEncadeada<Integer> linhasNovas;
        No<ListaEncadeada> noAux = colunas.getRaiz();
        ListaEncadeada<Integer> penultimaColuna = null;
        int tamanhoAntes = 0;
        int tamanhoDepois = 1;
        while (noAux != null) {
            tamanhoAntes = noAux.getDado().getTamanho();
            noAux.getDado().adiciona(Integer.MAX_VALUE, nomeVertice);
            tamanhoDepois = noAux.getDado().getTamanho();
            penultimaColuna = noAux.getDado();
            noAux = noAux.getProximo();
        }
        if (tamanhoAntes == tamanhoDepois - 1) {
            linhasNovas = criaLinhas(penultimaColuna, nomeVertice);
            colunas.adiciona(linhasNovas, nomeVertice);
        }
    }

    public No<Integer> procuraPesoLigacao(String nomeColunaProcurada, String nomeLinhaProcurada) {
        No<ListaEncadeada> noAux = colunas.getRaiz();
        while (noAux != null) {
            String nomeColunaAtual = noAux.getIdentificador();
            if (nomeColunaProcurada.equals(nomeColunaAtual)) {
                No<Integer> noAux2 = noAux.getDado().getRaiz();
                while (noAux2 != null) {
                    String nomeLinhaAtual = noAux2.getIdentificador();
                    if (nomeLinhaProcurada.equals(nomeLinhaAtual)) {
                        return noAux2;
                    }
                    noAux2 = noAux2.getProximo();
                }
            }
            noAux = noAux.getProximo();
        }
        return null;
    }

    public void setPesoLigacao(String v1, String v2, int novoPeso) {
        No<Integer> resultado = procuraPesoLigacao(v1, v2);
        if (resultado != null) {
            resultado.setDado(novoPeso);
            resultado = procuraPesoLigacao(v2, v1);
            resultado.setDado(novoPeso);
        }
        else {
            adicionaVertice(v1);
            adicionaVertice(v2);
            setPesoLigacao(v1, v2, novoPeso);
        }
    }

    public int getPesoLigacao(int coluna, int linha) {
        No<Integer> resultado = vasculhaMatriz(coluna, linha);
        if (resultado == null) {
            return -2;
        }
        return resultado.getDado();
    }

    public int getPesoLigacao(String nomeColuna, String nomeLinha) {
        No<Integer> resultado = procuraPesoLigacao(nomeColuna, nomeLinha);
        if (resultado == null) {
            return -2;
        }
        return resultado.getDado();
    }

    public int getNumeroLinhasColunas() {
        return numeroLinhasColunas;
    }

    private No<Integer> vasculhaMatriz(int posicaoColuna, int posicaoLinha) {
        No<ListaEncadeada> noAux = colunas.getRaiz();
        while (noAux != null && posicaoColuna > 0) {
            noAux = noAux.getProximo();
            posicaoColuna--;
        }
        if (noAux != null) {
            No<Integer> noAux2 = noAux.getDado().getRaiz();
            while (noAux2 != null && posicaoLinha > 0) {
                noAux2 = noAux2.getProximo();
                posicaoLinha--;
            }
            if (noAux2 != null) {
                return noAux2;
            }
        }
        return null;
    }

    public boolean estaVazio() {
        return colunas.estaVazio() && numeroLinhasColunas == 0;
    }

    public ListaEncadeada<ListaEncadeada> getColunas() {
        return colunas;
    }

    public String[] getVetorNomeVertices() {
        String[] listaNomes = new String[numeroLinhasColunas];
        int indice = 0;
        No<ListaEncadeada> noAux = colunas.getRaiz();
        while (noAux != null) {
            listaNomes[indice] = noAux.getIdentificador();
            indice++;
            noAux = noAux.getProximo();
        }
        return listaNomes;
    }

    public No<ListaEncadeada> obtemColuna(String nomeVertice) {
        No<ListaEncadeada> noAux = colunas.getRaiz();
        while (noAux != null) {
            if (noAux.getIdentificador().equals(nomeVertice)) {
                return noAux;
            }
            noAux = noAux.getProximo();
        }
        return null;
    }

    public int[][] converteMatrizInteiros() {
        int[][] matriz = new int[numeroLinhasColunas][numeroLinhasColunas];
        int i, j;
        i = j = 0;
        No<ListaEncadeada> noAux = colunas.getRaiz();
        while (noAux != null) {
            No<Integer> noAux2 = noAux.getDado().getRaiz();
            while (noAux2 != null) {
                matriz[i][j] = noAux2.getDado();
                noAux2 = noAux2.getProximo();
                j++;
            }
            i++;
            j = 0;
            noAux = noAux.getProximo();
        }
        return matriz;
    }

    public LinkedList<Vertice> converteListaVerticess() {
        No<ListaEncadeada> noAux = colunas.getRaiz();
        vertices = new LinkedList();
        Vertice v;
        while (noAux != null) {
            No<Integer> noAux2 = noAux.getDado().getRaiz();
            v = new Vertice(noAux.getIdentificador());
            while (noAux2 != null) {
                if (!noAux2.getIdentificador().equals(noAux.getIdentificador())
                        && noAux2.getDado() != Integer.MAX_VALUE) {
                    Vertice adj = new Vertice(noAux2.getIdentificador());
                    v.adicionaAresta(adj, noAux2.getDado());
                }
                noAux2 = noAux2.getProximo();
            }
            vertices.add(v);
            noAux = noAux.getProximo();
        }
        return vertices;
    }

    public void preparaParaDijkstra(String nomeVertice, LinkedList<Vertice> emPreparacao) {
        for (int i = 0; i < emPreparacao.size(); i++) {
            Vertice atual = emPreparacao.get(i);
            if (atual.getNome().equals(nomeVertice)) {
                atual.setDistanciaOrigem(0);
                atual.setVerticeAntecessor(null);
            }
            else {
                int pesoLigacaoOrigem = atual.getPesoLigacaoCom(nomeVertice);
                if (pesoLigacaoOrigem != Integer.MAX_VALUE) {
                    atual.setDistanciaOrigem(pesoLigacaoOrigem);
                    atual.setVerticeAntecessor(buscaVertice(nomeVertice));
                }
                else {
                    atual.setDistanciaOrigem(Integer.MAX_VALUE);
                    atual.setVerticeAntecessor(null);
                }
            }
        }
    }

    public Vertice buscaVertice(String nomeVertice) {
        for (int i = 0; i < vertices.size(); i++) {
            Vertice atual = vertices.get(i);
            if (atual.getNome().equals(nomeVertice)) {
                return atual;
            }
        }
        return null;
    }
}
