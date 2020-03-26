package Semente;

import Vertice.Vertice;
import grafo.Grafo;
import java.util.Random;

public class GrafoAleatorio {

    public Grafo geraGrafo() {
        Random random = new Random();
        Grafo grafo = new Grafo();
        for (int i = 0; i < 500; i++) {
            Vertice v1 = new Vertice(random.nextInt(9999999) + "");
            while (!grafo.adicionaVertice(v1)) {
                v1 = new Vertice(random.nextInt(9999999) + "");
            }

            Vertice v2 = new Vertice(random.nextInt(9999999) + "");
            while (!grafo.adicionaVertice(v2)) {
                v2 = new Vertice(random.nextInt(9999999) + "");
            }

            grafo.insereLigacao(v1, v2, random.nextInt(1000));
        }
        return grafo;
    }
}
