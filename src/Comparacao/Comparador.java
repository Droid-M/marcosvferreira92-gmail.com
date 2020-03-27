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

    public static void main(String[] args) {

        float[] tempoDijkstra = new float[10];
        float[] tempoFloyd = new float[10];
        for (int i = 0; i < 10; i++) {
            GrafoAleatorio gerador = new GrafoAleatorio(500);
            Grafo grafo = gerador.geraGrafo();

            LinkedList<Vertice> lista = grafo.converteListaVerticess();
            Vertice origem = lista.get(i);
            grafo.preparaParaDijkstra(origem.getNome(), lista);
            int[][] matriz = grafo.converteMatrizInteiros();

            tempoDijkstra[i] = testeDijkstra(origem, lista);
            tempoFloyd[i] = testeFloyW(matriz);
        }

        float mediaDijk = calculaMedia(tempoDijkstra);
        float mediaFloyd = calculaMedia(tempoFloyd);

        if (mediaDijk < mediaFloyd) {
            System.out.println("O dijkstra foi mais rápido no quesito média: " + mediaDijk);
        }
        else {
            System.out.println("O FloydWarsall foi mais rápido no quesito média: " + mediaFloyd);
        }

        double varianciaDijk = calculaVariancia(mediaDijk, tempoDijkstra);
        double varianciaFloyd = calculaVariancia(mediaFloyd, tempoFloyd);

        if (mediaDijk < mediaFloyd) {
            System.out.println("O dijkstra foi mais rápido no quesito variância: " + varianciaDijk);
        }
        else {
            System.out.println("O FloydWarsall foi mais rápido no quesito variância: " + varianciaFloyd);
        }

        double desvioDijk = calculaDesvioPadrao(varianciaDijk);
        double desvioFloyd = calculaDesvioPadrao(varianciaFloyd);

        if (mediaDijk < mediaFloyd) {
            System.out.println("O dijkstra foi mais rápido no quesito desvio: " + desvioDijk);
        }
        else {
            System.out.println("O FloydWarsall foi mais rápido no quesito desvio: " + desvioFloyd);
        }
    }

    private static float testeDijkstra(Vertice origem, LinkedList<Vertice> lista) {
        long inicio = System.currentTimeMillis();
        d.obtemMenoresCaminhos(origem, lista);
        long fim = System.currentTimeMillis();
        return (float) fim - inicio;
    }

    private static float testeFloyW(int[][] matriz) {
        long inicio = System.currentTimeMillis();
        f.MenorCaminho(matriz);
        long fim = System.currentTimeMillis();
        return (float) fim - inicio;
    }

    private static float calculaMedia(float[] valores) {
        float media = 0;
        for (int i = 0; i < 10; i++) {
            media += valores[i];
        }
        return media / 10;
    }

    private static double calculaVariancia(float media, float[] valores) {
        double variancia = 0;
        for (int i = 0; i < 10; i++) {
            variancia += (Math.pow(valores[i] - media, 2));
        }
        return variancia;
    }

    private static double calculaDesvioPadrao(double variancia) {
        return Math.sqrt(variancia) / 10;
    }
}
