/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author prog02
 */
public class JogoDepTest {
    
    public JogoDepTest() {
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
     * Test of getId method, of class JogoDep.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        JogoDep instance = new JogoDep();
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of setId method, of class JogoDep.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 0;
        JogoDep instance = new JogoDep();
        instance.setId(id);
    }

    /**
     * Test of getQuantidade method, of class JogoDep.
     */
    @Test
    public void testGetQuantidade() {
        System.out.println("getQuantidade");
        JogoDep instance = new JogoDep();
        int expResult = 0;
        int result = instance.getQuantidade();
        assertEquals(expResult, result);
    }

    /**
     * Test of setQuantidade method, of class JogoDep.
     */
    @Test
    public void testSetQuantidade() {
        System.out.println("setQuantidade");
        int quantidade = 0;
        JogoDep instance = new JogoDep();
        instance.setQuantidade(quantidade);
    }

    /**
     * Test of getIdJogo method, of class JogoDep.
     */
    @Test
    public void testGetIdJogo() {
        System.out.println("getIdJogo");
        JogoDep instance = new JogoDep();
        int expResult = 0;
        int result = instance.getIdJogo();
        assertEquals(expResult, result);
    }

    /**
     * Test of setIdJogo method, of class JogoDep.
     */
    @Test
    public void testSetIdJogo() {
        System.out.println("setIdJogo");
        int idJogo = 0;
        JogoDep instance = new JogoDep();
        instance.setIdJogo(idJogo);
    }

    /**
     * Test of getIdDeposito method, of class JogoDep.
     */
    @Test
    public void testGetIdDeposito() {
        System.out.println("getIdDeposito");
        JogoDep instance = new JogoDep();
        int expResult = 0;
        int result = instance.getIdDeposito();
        assertEquals(expResult, result);
    }

    /**
     * Test of setIdDeposito method, of class JogoDep.
     */
    @Test
    public void testSetIdDeposito() {
        System.out.println("setIdDeposito");
        int idDeposito = 0;
        JogoDep instance = new JogoDep();
        instance.setIdDeposito(idDeposito);
    }
    
}
