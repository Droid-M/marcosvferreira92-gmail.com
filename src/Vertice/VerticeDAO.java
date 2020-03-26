package Vertice;

import ListaEncadeada.ListaEncadeada;
import ListaEncadeada.No;

/**
 *
 * @author Marcos Vinícius Ferreira dos Santos
 */
public class VerticeDAO extends ListaEncadeada<Vertice> {

    /**
     * Adiciona um novo vértice à estrutura
     *
     * @param novoVertice Vertice que será adicionado
     * @return Retorna o objeto adicionado ou uma outra versão dele caso já
     * exista no sistema
     */
    public Vertice adicionaVertice(Vertice novoVertice) {
        Vertice verticeAdicionado = super.adiciona(novoVertice, novoVertice.getNome());
        return verticeAdicionado;
    }

    /**
     * Remove um vértice da estrutura
     *
     * @param nomeVertice Nome do vértice que será removido
     * @return Retorna true para o vértice excluido ou retorna false caso nada
     * tenha sido removido
     */
    public boolean removeVertice(String nomeVertice) {
        return super.remove(nomeVertice) != null;
    }

    /**
     * Altera o valor da distância da origem de todos os nós para -1
     */
    public void reinicializaNos() {
        if (!super.estaVazio()) {
            No<Vertice> noAux = super.getPrimeiraColuna();
            while (noAux != null) {
                noAux.getDado().setDistanciaOrigem(-1);
                noAux.getDado().setAntecessor(null);
                noAux = noAux.getProximo();
            }
        }
    }

    /**
     * Encontra o adjacente mínimo entre todos os adjacentes de uma matriz
     *
     * @return Retorna o adjacente encontrado ou retorna null
     */
    public Vertice extraiMinimo() {
        if (!super.estaVazio()) {
            No<Vertice> minimo, noAux;
            minimo = noAux = super.getPrimeiraColuna();
            int menorDistancia = minimo.getDado().getDistanciaOrigem();
            while (noAux != null) {
                int distanciaNoAtual = noAux.getDado().getDistanciaOrigem();
                if (distanciaNoAtual < menorDistancia && distanciaNoAtual != -1 || menorDistancia == -1) {
                    menorDistancia = distanciaNoAtual;
                    minimo = noAux;
                }
                noAux = noAux.getProximo();
            }
            return super.remove(minimo.getIdentificador());
        }
        return null;
    }

    /**
     * Realiza uma cópia da lista de vértices
     * @return Retorna a cópia
     */
    public VerticeDAO clonagem() {
        No<Vertice> noAux = super.getPrimeiraColuna();
        VerticeDAO clone = new VerticeDAO();
        while (noAux != null) {
            //Vertice copia = noAux.getDado().clonagem(); <=== Preciso fazer umas alterações aqui
            Vertice copia = noAux.getDado(); //Enquanto não faço as alterações, isso vai servir
            clone.adicionaVertice(copia);
            noAux = noAux.getProximo();
        }
        return clone;
    }

}
