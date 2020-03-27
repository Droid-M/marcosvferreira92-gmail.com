package Comparacao;

import Dijkstra.Dijkstra;
import FloydWarshall.FloydWarsall;
import Semente.GrafoAleatorio;
import Vertice.Vertice;
import grafo.Grafo;
import java.util.LinkedList;

/**
 *
 * @author Marcos
 */
public class Comparador {

    private static Dijkstra d = new Dijkstra();
    private static FloydWarsall f = new FloydWarsall();
    private static final int numeroTestes = 10;
    public static void main(String[] args) {

        long[] tempoDijkstra = new long[numeroTestes];
        long[] tempoFloyd = new long[numeroTestes];
        for (int i = 0; i < numeroTestes; i++) {
            GrafoAleatorio gerador = new GrafoAleatorio(500);
            Grafo grafo = gerador.geraGrafo();

            LinkedList<Vertice> lista = grafo.converteListaVerticess();
            Vertice origem = lista.get(i);
            grafo.preparaParaDijkstra(origem.getNome(), lista);
            int[][] matriz = grafo.converteMatrizInteiros();

            tempoDijkstra[i] = testeDijkstra(origem, lista);
            tempoFloyd[i] = testeFloyW(matriz);
        }

        long mediaDijk = calculaMedia(tempoDijkstra);
        long mediaFloyd = calculaMedia(tempoFloyd);

        if (mediaDijk < mediaFloyd) {
            System.out.println("O dijkstra foi mais rápido no quesito média: " + mediaDijk);
        }
        else {
            System.out.println("O FloydWarsall foi mais rápido no quesito média: " + mediaFloyd);
        }

        long varianciaDijk = calculaVariancia(mediaDijk, tempoDijkstra);
        long varianciaFloyd = calculaVariancia(mediaFloyd, tempoFloyd);

        if (mediaDijk < mediaFloyd) {
            System.out.println("O dijkstra foi mais rápido no quesito variância: " + varianciaDijk);
        }
        else {
            System.out.println("O FloydWarsall foi mais rápido no quesito variância: " + varianciaFloyd);
        }

        long desvioDijk = calculaDesvioPadrao(varianciaDijk);
        long desvioFloyd = calculaDesvioPadrao(varianciaFloyd);

        if (mediaDijk < mediaFloyd) {
            System.out.println("O dijkstra foi mais rápido no quesito desvio: " + desvioDijk);
        }
        else {
            System.out.println("O FloydWarsall foi mais rápido no quesito desvio: " + desvioFloyd);
        }
    }

    private static long testeDijkstra(Vertice origem, LinkedList<Vertice> lista) {
        long inicio = System.currentTimeMillis();
        d.obtemMenoresCaminhos(origem, lista);
        long fim = System.currentTimeMillis();
        return fim - inicio;
    }

    private static long testeFloyW(int[][] matriz) {
        long inicio = System.currentTimeMillis();
        f.MenorCaminho(matriz);
        long fim = System.currentTimeMillis();
        return fim - inicio;
    }

    private static long calculaMedia(long[] valores) {
        long media = 0;
        for (int i = 0; i < numeroTestes; i++) {
            media += valores[i];
        }
        return media / numeroTestes;
    }

    private static long calculaVariancia(long media, long[] valores) {
        long variancia = 0;
        for (int i = 0; i < numeroTestes; i++) {
            variancia += (Math.pow(valores[i] - media, 2));
        }
        return variancia;
    }

    private static long calculaDesvioPadrao(long variancia) {
        return (long) (Math.sqrt(variancia) / numeroTestes);
    }
}
