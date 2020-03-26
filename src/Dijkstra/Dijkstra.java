package Dijkstra;

import Vertice.Vertice;
import java.util.HashMap;

public final class Dijkstra {

    HashMap<String, Vertice> selecionados = new HashMap();

    public HashMap menorCaminho(Vertice origem, HashMap<String, HashMap<Vertice, Integer>> g) {
        if (origem == null || g == null) {
            return null;
        }
        reinicializaNos(origem, g);
        extraiMinimo(origem, g);
        return null;
    }

    private void reinicializaNos(Vertice origem, HashMap<String, HashMap<Vertice, Integer>> g) {
        for (String key : g.keySet()) {
            HashMap<Vertice, Integer> get = g.get(key);
            for (Vertice atual : get.keySet()) {
                if (atual.equals(origem)) {
                    atual.setDistanciaOrigem(0);
                }
                else {
                    if (key.equals(origem.getNome())) {
                        atual.setDistanciaOrigem(get.get(atual));
                    }
                    else {
                        atual.setDistanciaOrigem(Integer.MAX_VALUE);
                    }
                }
            }
        }
    }

    private Vertice extraiMinimo(Vertice antigoMinimo, HashMap<String, HashMap<Vertice, Integer>> g) {
        HashMap<Vertice, Integer> colunas = g.get(antigoMinimo.getNome());
        Vertice minimo = null;
        int menorPeso = Integer.MAX_VALUE;
        if (colunas == null) {
            return null;
        }
        for (Vertice atual : colunas.keySet()) {
           if (atual.getDistanciaOrigem() < menorPeso && !selecionados.containsValue(atual)) {
               
           }
        }
    }

}
