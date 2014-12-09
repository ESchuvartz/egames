package model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class FaixaEtariaTest {
    
    public FaixaEtariaTest() {
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
     * Test of getDescricao method, of class FaixaEtaria.
     */
    @Test
    public void testGetDescricao() {
        System.out.println("getDescricao");
        FaixaEtaria instance = new FaixaEtaria();
        String expResult = "";
        String result = instance.getDescricao();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDescricao method, of class FaixaEtaria.
     */
    @Test
    public void testSetDescricao() {
        System.out.println("setDescricao");
        String descricao = "";
        FaixaEtaria instance = new FaixaEtaria();
        instance.setDescricao(descricao);
    }

    /**
     * Test of getId method, of class FaixaEtaria.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        FaixaEtaria instance = new FaixaEtaria();
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of setId method, of class FaixaEtaria.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 0;
        FaixaEtaria instance = new FaixaEtaria();
        instance.setId(id);
    }
}
