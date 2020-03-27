package Vertice;

import Aresta.Aresta;
import java.util.LinkedList;

/**
 *
 * @author Adryel e Marcos
 */
public class Vertice {

    private String nome;
    private LinkedList<Aresta> arestas;
    private int distanciaOrigem;
    private Vertice antecessor;

    /**
     * Método Construtor
     *
     * @param nome Nome para o novo vertice
     */
    public Vertice(String nome) {
        this.nome = nome;
        this.arestas = new LinkedList();
    }

    /**
     * Método para adicionar uma nova aresta a dois vertices
     *
     * @param destino Verticie de destino o qual será o fim da aresta
     * @param peso Peso da aresta
     * @return
     */
    public boolean adicionaAresta(Vertice destino, int peso) {
        return (destino == null) ? false : arestas.add(new Aresta(peso, destino));
    }

    /**
     * Método que retorna a lista de aresta do vertice
     *
     * @return Retorna a lista de aresta do vertice
     */
    public LinkedList<Aresta> getArestas() {
        return this.arestas;
    }

    /**
     * Método que retorna o peso de uma aresta com base em um vertice adjacente
     *
     * @param nome Nome do vertice de peso de ligação buscado
     * @return Retorna o peso da aresta
     */
    public int getPesoLigacaoCom(String nome) {
        for (int i = 0; i < arestas.size(); i++) {
            Aresta arestaAtual = arestas.get(i);
            Vertice verticeAtual = arestaAtual.getFim();
            if (verticeAtual.getNome().equals(nome)) {
                return arestaAtual.getPeso();
            }
        }
        return Integer.MAX_VALUE;
    }

    public int getPesoLigacaoCom(Vertice adjacente) {
        return getPesoLigacaoCom(adjacente.getNome());
    }

    /**
     * Método retorna o nome do vertice
     *
     * @return Retorna o nome do vertice
     */
    public String getNome() {
        return nome;
    }

    /**
     * Método que altera a distância de origem do vertice
     *
     * @param novaDistanciaOrigem Nova distância de origem para ser adiconada
     */
    public void setDistanciaOrigem(int novaDistanciaOrigem) {
        this.distanciaOrigem = novaDistanciaOrigem;
    }

    /**
     * Método que retorna a distancia da origem do vertice
     *
     * @return Retorna a distância de origem do vertice
     */
    public int getDistanciaOrigem() {
        return this.distanciaOrigem;
    }

    /**
     * Método que altera o vertice antecessor de um vertice
     *
     * @param novoAntecessor Novo vertice antecessor
     */
    public void setVerticeAntecessor(Vertice novoAntecessor) {
        this.antecessor = novoAntecessor;
    }

    /**
     * Método que retorna vertice antecessor de um vertice
     *
     * @return Retorna o vertice antecessor do vertice
     */
    public Vertice getVerticeAntecessor() {
        return this.antecessor;
    }

    /**
     * Método que remove aresta entre dois vertices
     *
     * @param emRemocao Vertice o qual será removido a ligação
     * @return Retorna true ou false indicando se a operação foi bem sucedida ou
     * não
     */
    public boolean removeLigacaoCom(Vertice emRemocao) {
        for (int i = 0; i < arestas.size(); i++) {
            Aresta arestaAtual = arestas.get(i);
            Vertice verticeAtual = arestaAtual.getFim();
            if (verticeAtual.equals(emRemocao)) {
                return arestas.remove(arestaAtual);
            }
        }
        return false; // retorna false caso não haja ligação
    }
}
