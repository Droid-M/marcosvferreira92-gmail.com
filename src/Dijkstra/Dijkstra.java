package Dijkstra;

import Vertice.Vertice;
import Aresta.Aresta;
import java.util.LinkedList;

/**
 *
 * @author Adryel e Marcos
 */
public class Dijkstra {

    private LinkedList<Vertice> distanciaQ; //Lista de vértices antes de passar pelo Dijkstra
    private LinkedList<Vertice> distanciaS; //Lista de vértices depois de passar pelo Dijkstra
    private LinkedList<Vertice> listaVisitados;

    /**
     * Recebe um vertice de partida e o grafo, e encontra o menor caminho
     *
     * @param pontoPartida Vertice do ponto de partida
     * @param conjuntoVertices Grafo com o conjunto de todos os vertices
     *
     * @return A sequência dos vertices do menor caminho
     */
    public LinkedList<Vertice> obtemMenoresCaminhos(Vertice pontoPartida, LinkedList<Vertice> conjuntoVertices) {
        if (conjuntoVertices.isEmpty()) {
            return null; // Retorna nulo se o grafo estiver vazio
        }
        listaVisitados = new LinkedList();
        distanciaQ = conjuntoVertices;
        // A linha acima inicia a lista de custos do vertice de partida
        // em relação todos os outros

        distanciaS = new LinkedList();
        while (!distanciaQ.isEmpty()) {
            Vertice minimo = extraiMinimo(distanciaQ);
            if (minimo == null) {
                return distanciaS;
            }
            distanciaS.add(minimo);
            Object[] arestasVerticeMinimo = minimo.getArestas().toArray();   //constroiVetorArestas(minimo);
            for (int i = 0; i < arestasVerticeMinimo.length; i++) {
                Vertice adjcenteAtual = ((Aresta) arestasVerticeMinimo[i]).getFim();
                int pesoLigacao = ((Aresta) arestasVerticeMinimo[i]).getPeso();
                if (adjcenteAtual.getDistanciaOrigem() > minimo.getDistanciaOrigem() + pesoLigacao) {
                    adjcenteAtual.setDistanciaOrigem(minimo.getDistanciaOrigem() + pesoLigacao);
                    adjcenteAtual.setVerticeAntecessor(minimo);
                }
            }
        }
        return distanciaS;
    }

    /**
     * Método que busca o vertice com a menor distância
     *
     * @param distanciaQ
     * @return Retorna o vertice com a menor distância
     */
    private Vertice extraiMinimo(LinkedList<Vertice> distanciaQ) {
        if (!distanciaQ.isEmpty()) {
            LinkedList<Vertice> vertices = distanciaQ;
            Vertice minimo, verticeAtual;
            minimo = null;
            int menorDistancia = Integer.MAX_VALUE;
            for (int i = 0; i < vertices.size(); i++) {
                verticeAtual = vertices.get(i);
                int distanciaVerticeAtual = verticeAtual.getDistanciaOrigem();
                if (distanciaVerticeAtual < menorDistancia && !listaVisitados.contains(verticeAtual)) {
                    menorDistancia = distanciaVerticeAtual;
                    minimo = verticeAtual;
                }
            }
            listaVisitados.add(minimo);
            return minimo;
        }
        return null; // Retorna null caso não haja vertices
    }
}
