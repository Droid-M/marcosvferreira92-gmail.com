package Dijkstra;

import Vertice.Vertice;
import grafo.Grafo;
import java.util.HashMap;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class DijkstraTest {

    public DijkstraTest() {
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
     * Test of menorCaminho method, of class Dijkstra.
     */
    @Test
    public void testMenorCaminho() {
        System.out.println("menorCaminho");
        Grafo g = new Grafo();
        Vertice origem = new Vertice("origem");
        Vertice v2 = new Vertice("v2");
        Vertice v3 = new Vertice("v3");
        Dijkstra instance = new Dijkstra();
        HashMap<String, Vertice> expResult = null;
        g.insereLigacao(origem, v2, 12);
        g.insereLigacao(origem, v3, 2);
        g.insereLigacao(v2, v3, 14);
        HashMap<String, Vertice> result = instance.menorCaminho(v2, g.getLinhas());
        assertNotEquals(expResult, result);
        System.out.println(v3.getAntecessor().getNome());
    }

}
