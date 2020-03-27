package ListaEncadeada;

public class ListaEncadeada<T> {

    private int tamanho = 0;
    private No<T> raiz;

    public T adiciona(T dado, String identificador) {
        No<T> novoNo = new No(dado, identificador);
        if (raiz == null) {
            raiz = novoNo;
            tamanho++;
        }
        else {
            No<T> noAux = raiz;
            if (noAux.getIdentificador().equals(identificador)) {
                return noAux.getDado();
            }
            while (noAux.getProximo() != null) {
                noAux = noAux.getProximo();
                if (noAux.getIdentificador().equals(identificador)) {
                    return noAux.getDado();
                }
            }
            noAux.setProximo(novoNo);
            tamanho++;
        }
        return novoNo.getDado();
    }

    public T remove(String identificador) {
        No<T> noAux = raiz;
        if (noAux != null) {
            if (noAux.getIdentificador().equals(identificador)) {
                raiz = noAux.getProximo();
                noAux.setProximo(null);
                tamanho--;
                return noAux.getDado();
            }
            while (noAux.getProximo() != null) {
                No<T> noProximo = noAux.getProximo();
                if (noProximo.getIdentificador().equals(identificador)) {
                    noAux.setProximo(noProximo.getProximo());
                    noProximo.setProximo(null);
                    tamanho--;
                    return noProximo.getDado();
                }
                noAux = noAux.getProximo();
            }
        }
        return null;
    }

    public boolean estaVazio() {
        return raiz == null;
    }

    public No<T> getRaiz() {
        return raiz;
    }

    public T busca(String identificador) {
        No<T> noAux = raiz;
        while (noAux != null) {
            if (noAux.getIdentificador().equals(identificador)) {
                return noAux.getDado();
            }
            noAux = noAux.getProximo();
        }
        return null;
    }

    public int getTamanho() {
        return tamanho;
    }
}
