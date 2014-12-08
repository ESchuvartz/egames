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
public class GeneroTest {
    
    public GeneroTest() {
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
     * Test of getDescricao method, of class Genero.
     */
    @Test
    public void testGetDescricao() {
        System.out.println("getDescricao");
        Genero instance = new Genero();
        String expResult = null;
        String result = instance.getDescricao();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDescricao method, of class Genero.
     */
    @Test
    public void testSetDescricao() {
        System.out.println("setDescricao");
        String descricao = "";
        Genero instance = new Genero();
        instance.setDescricao(descricao);
    }

    /**
     * Test of getId method, of class Genero.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Genero instance = new Genero();
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of setId method, of class Genero.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 0;
        Genero instance = new Genero();
        instance.setId(id);
    }
    
}
