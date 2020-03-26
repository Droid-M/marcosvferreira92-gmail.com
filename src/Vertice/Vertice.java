package Vertice;

/**
 *
 * @author Marcos Vinícius Ferreira dos Santos
 */
public class Vertice {

    private String nome;
    private Vertice antecessor;
    private int distanciaOrigem; //Distância da origem

    /**
     * Construtor da classe
     *
     * @param nomeVertice Nome do vértice
     */
    public Vertice(String nomeVertice) {
        distanciaOrigem = Integer.MAX_VALUE;
        nome = nomeVertice;
        antecessor = null;
    }

    /**
     * Informa o nome do vértice atual
     *
     * @return Retorna o nome do vértice atual
     */
    public String getNome() {
        return nome;
    }

    /**
     * Fornece o vértice-antecessor do atual
     *
     * @return Retorna o vértice-antecessor do atual caso ele exista, senão
     * retorna null
     */
    public Vertice getAntecessor() {
        return antecessor;
    }

    /**
     * Altera o vértice-antecessor do atual
     *
     * @param pai Novo vértice-antecessor
     */
    public void setAntecessor(Vertice pai) {
        this.antecessor = pai;
    }

    /**
     * Informa a distância da origem do vértice-atual
     *
     * @return Retorna 0 caso o vértice seja a origem ou -1 caso ele não seja
     */
    public int getDistanciaOrigem() {
        return distanciaOrigem;
    }

    /**
     * Altera a distância da origem
     *
     * @param distanciaOrigem Novo valor de distância da origem
     */
    public void setDistanciaOrigem(int distanciaOrigem) {
        this.distanciaOrigem = distanciaOrigem;
    }

}
