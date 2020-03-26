package grafo;

import Vertice.Vertice;
import java.util.Collection;
import java.util.HashMap;

public class Grafo {

    private int tamDiagonal;
    HashMap<String, HashMap> matriz;

    public Grafo() {
        tamDiagonal = 0;
        matriz = new HashMap();
    }

    public boolean adicionaVertice(Vertice novo) {
        return atualizaLinhas(novo);
    }

    private HashMap<Vertice, Integer> criaColuna(Vertice novo) {
        HashMap<Vertice, Integer> novaColuna = new HashMap();
        novaColuna.put(novo, 0);
        return novaColuna;
    }

    private boolean atualizaLinhas(Vertice novo) {
        if (novo == null || !(novo instanceof Vertice) || matriz.containsKey(novo.getNome())) {
            return false;
        }
        Collection<HashMap> conjuntoLinhas = matriz.values();
        HashMap<Vertice, Integer> penultimaLinha = new HashMap();
        for (HashMap linhaAtual : conjuntoLinhas) {
            penultimaLinha = linhaAtual;
            linhaAtual.put(novo, Integer.MAX_VALUE);
        }
        matriz.put(novo.getNome(), criaLinha(penultimaLinha, novo));
        tamDiagonal++;
        return true;
    }

    private HashMap<Vertice, Integer> criaLinha(HashMap<Vertice, Integer> penultimaLinha, Vertice novo) {
        HashMap<Vertice, Integer> novaLinha = new HashMap();
        Vertice ultimo = novo;
        for (Vertice atual : penultimaLinha.keySet()) {
            ultimo = atual;
            novaLinha.put(atual, Integer.MAX_VALUE);
        }
        novaLinha.put(ultimo, 0);
        return novaLinha;
    }

    public int getTamDiagonal() {
        return tamDiagonal;
    }

    public boolean insereLigacao(Vertice vertice1, Vertice vertice2, int pesoLigacao) {
        return alteraLigacao(vertice1, vertice2, pesoLigacao) && alteraLigacao(vertice2, vertice1, pesoLigacao);
    }

    private boolean alteraLigacao(Vertice verticeLinha, Vertice verticeColuna, int pesoLigacao) {
        verificaExistencia(verticeLinha, verticeColuna);
        HashMap<Vertice, Integer> colunas = matriz.get(verticeLinha.getNome());
        if (colunas != null) {
            if (colunas.containsKey(verticeColuna)) {
                colunas.put(verticeColuna, pesoLigacao);
                return true;
            }
        }
        return false;
    }

    private void verificaExistencia(Vertice v1, Vertice v2) {
        if (!matriz.containsKey(v1.getNome())) {
            this.adicionaVertice(v1);
        }
        if (!matriz.containsKey(v2.getNome())) {
            this.adicionaVertice(v2);
        }
    }

}
