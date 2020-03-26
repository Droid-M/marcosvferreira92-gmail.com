package FloydWarshall;

import Vertice.Vertice;
import grafo.Grafo;
import java.util.Random;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class FloydWarsallTest {

    public FloydWarsallTest() {
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
     * Test of MenorCaminho method, of class FloydWarsall.
     */
    @Test
    public void testMenorCaminho() {
        System.out.println("MenorCaminho");
        int[][] graph = criaMatriz();
        FloydWarsall instance = new FloydWarsall();
        int[][] result = instance.MenorCaminho(graph);
    }

    private int[][] criaMatriz() {
        Random random = new Random();
        Grafo grafo = new Grafo();
        for (int i = 0; i < 5; i++) {
            Vertice v1 = new Vertice(random.nextInt(9999999) + "");
            while (!grafo.adicionaVertice(v1)) {
                v1 = new Vertice(random.nextInt(9999999) + "");
            }

            Vertice v2 = new Vertice(random.nextInt(9999999) + "");
            while (!grafo.adicionaVertice(v2)) {
                v2 = new Vertice(random.nextInt(9999999) + "");
            }

            boolean insereLigacao = grafo.insereLigacao(v1, v2, random.nextInt(1000));
            assertTrue(insereLigacao);
        }
        assertEquals(10, grafo.getTamDiagonal());
        return grafo.converteMatrizInteiros();
    }

}
