package Matriz;

import grafo.Grafo;
import Vertice.Vertice;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class GrafoMatrizesTest {

    public GrafoMatrizesTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of adicionaVertice method, of class Grafo.
     */
    @Test
    public void testAdicionaVertice() {
        System.out.println("adicionaVertice");
        Vertice novo = new Vertice("V1");
        Grafo instance = new Grafo();
        boolean result = instance.adicionaVertice(novo);
        assertTrue(result);
    }

    /**
     * Test of getTamDiagonal method, of class Grafo.
     */
    @Test
    public void testGetTamDiagonal() {
        System.out.println("getTamDiagonal");
        Grafo instance = new Grafo();
        Vertice novo = new Vertice("V1");
        instance.adicionaVertice(novo);
        instance.adicionaVertice(novo);
        int expResult = 1;
        int result = instance.getTamDiagonal();
        assertSame(expResult, result);
    }

    /**
     * Test of insereLigacao method, of class Grafo.
     */
    @Test
    public void testInsereLigacao() {
        System.out.println("insereLigacao");
        Vertice verticeLinha = new Vertice("1");
        Vertice verticeColuna = new Vertice("0");
        int pesoLigacao = 3;
        Grafo instance = new Grafo();
        boolean result = instance.insereLigacao(verticeLinha, verticeColuna, pesoLigacao);
        assertTrue(result);
        assertSame(2, instance.getTamDiagonal());
    }

}
