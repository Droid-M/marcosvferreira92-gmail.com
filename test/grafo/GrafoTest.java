/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafo;

import Vertice.Vertice;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Marcos
 */
public class GrafoTest {
    
    public GrafoTest() {
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
        Vertice novo = null;
        Grafo instance = new Grafo();
        boolean expResult = false;
        boolean result = instance.adicionaVertice(novo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTamDiagonal method, of class Grafo.
     */
    @Test
    public void testGetTamDiagonal() {
        System.out.println("getTamDiagonal");
        Grafo instance = new Grafo();
        int expResult = 0;
        int result = instance.getTamDiagonal();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insereLigacao method, of class Grafo.
     */
    @Test
    public void testInsereLigacao() {
        System.out.println("insereLigacao");
        Vertice vertice1 = null;
        Vertice vertice2 = null;
        int pesoLigacao = 0;
        Grafo instance = new Grafo();
        boolean expResult = false;
        boolean result = instance.insereLigacao(vertice1, vertice2, pesoLigacao);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
