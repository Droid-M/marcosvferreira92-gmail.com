package Dijkstra;

import Vertice.Vertice;
import java.util.HashMap;

public final class Dijkstra2 {
/*
    HashMap<String, Vertice> selecionados = new HashMap();
    HashMap<String, Vertice> distanciaS = new HashMap();

    public HashMap<String, Vertice> menorCaminho(Vertice origem, HashMap<String, HashMap<Vertice, Integer>> g) {
        if (origem == null || g == null) {
            return null;
        }
        reinicializaNos(origem, g);
        Vertice minimo = extraiMinimo(origem, g);
        while (minimo != null) {
            distanciaS.put(minimo.getNome(), minimo);
            HashMap<Vertice, Integer> colunas = g.get(minimo.getNome());
            for (Vertice atual : colunas.keySet()) {
                if (colunas.get(atual) != Integer.MAX_VALUE) {
                    int distancia = somatorio(minimo.getDistanciaOrigem(), distancia(minimo, atual, g));
                    if (atual.getDistanciaOrigem() > distancia && !selecionados.containsValue(atual)) {
                        if (minimo.getNome().equals("v3")) {
                            System.out.println("Distancia:"+distancia);
                            System.out.println(distancia(minimo, atual, g));
                        }
                        atual.setAntecessor(minimo);
                        atual.setDistanciaOrigem(distancia);
                    }
                }
            }
            minimo = extraiMinimo(origem, g);
        }
        for (String key : distanciaS.keySet()) {
            System.out.println(key);
        }
        return distanciaS;
    }

    private void reinicializaNos(Vertice origem, HashMap<String, HashMap<Vertice, Integer>> g) {
        for (String key : g.keySet()) {
            HashMap<Vertice, Integer> colunas = g.get(key);
            for (Vertice atual : colunas.keySet()) {
                if (atual.equals(origem)) {
                    atual.setDistanciaOrigem(0);
                    atual.setAntecessor(null);
                }
                else {
                    if (key.equals(origem.getNome())) {
                        int distanciaOrigem = colunas.get(atual);
                        atual.setDistanciaOrigem(distanciaOrigem);
                        atual.setAntecessor(origem);
                    }
                    else {
                        atual.setDistanciaOrigem(Integer.MAX_VALUE);
                        atual.setAntecessor(null);
                    }
                }
            }
        }
    }

    private Vertice extraiMinimo(Vertice antigoMinimo, HashMap<String, HashMap<Vertice, Integer>> g) {
        if (antigoMinimo == null) {
            return null;
        }
        HashMap<Vertice, Integer> colunas = g.get(antigoMinimo.getNome());
        Vertice minimo = null;
        int menorPeso = Integer.MAX_VALUE;
        for (Vertice atual : colunas.keySet()) {
            if (atual.getDistanciaOrigem() < menorPeso && !selecionados.containsValue(atual)) {
                minimo = atual;
                menorPeso = atual.getDistanciaOrigem();
            }
        }
        if (minimo != null) {
            selecionados.put(minimo.getNome(), minimo);
            return minimo;
        }
        else {
            return extraiMinimo(antigoMinimo.getAntecessor(), g);
        }
    }

    private int distancia(Vertice vertice1, Vertice vertice2, HashMap<String, HashMap<Vertice, Integer>> g) {
        HashMap<Vertice, Integer> get = g.get(vertice1.getNome());
        if (!get.containsKey(vertice2)) {
            return Integer.MAX_VALUE;
        }
        return get.get(vertice2);
    }

    private int somatorio(int valor1, int valor2) {
        if (valor1 == Integer.MAX_VALUE || valor2 == Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        return valor1 + valor2;
    }*/
}
