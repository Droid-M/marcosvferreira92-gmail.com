package ListaEncadeada;

public class No<T> {

    private T dado;
    private No<T> proximo;
    private String identificador;

    public No(T novoDado, String identificador) {
        dado = novoDado;
        this.identificador = identificador;
    }

    public T getDado() {
        return dado;
    }

    public No<T> getProximo() {
        return proximo;
    }

    public void setProximo(No<T> proximo) {
        this.proximo = proximo;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setDado(T novoDado) {
       this.dado = novoDado;
    }
}
