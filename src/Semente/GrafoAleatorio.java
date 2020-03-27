package Semente;

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
            String nome1 = random.nextInt(9999999) + "";
            String nome2 = random.nextInt(9999999) + "";
            while (!grafo.adicionaVertice(nome1)) {
                nome1 = random.nextInt(9999999) + "";
            }

            while (!grafo.adicionaVertice(nome2)) {
                nome2 = random.nextInt(9999999) + "";
            }
            int decisao = random.nextInt(7);
            if (decisao > 2) {
                grafo.setPesoLigacao(nome1, nome2, random.nextInt(1000));
            }
        }
        return grafo;
    }
}
