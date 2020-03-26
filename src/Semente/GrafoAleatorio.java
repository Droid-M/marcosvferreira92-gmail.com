package Semente;

import Vertice.Vertice;
import grafo.Grafo;
import java.util.Random;

public class GrafoAleatorio {

    private int n;

    public GrafoAleatorio(int numeroVertices) {
        this.n = numeroVertices;
    }

    public Grafo geraGrafo() {
        Random random = new Random();
        Grafo grafo = new Grafo();
        for (int i = 0; i < n; i++) {
            Vertice v1 = new Vertice(random.nextInt(9999999) + "");
            while (!grafo.adicionaVertice(v1)) {
                v1 = new Vertice(random.nextInt(9999999) + "");
            }

            Vertice v2 = new Vertice(random.nextInt(9999999) + "");
            while (!grafo.adicionaVertice(v2)) {
                v2 = new Vertice(random.nextInt(9999999) + "");
            }
            int decisao = random.nextInt(2);
            if (decisao < 1) {
                grafo.insereLigacao(v1, v2, random.nextInt(1000));
            }
        }
        return grafo;
    }
}
