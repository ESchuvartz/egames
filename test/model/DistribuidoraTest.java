package model;

import java.sql.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class DistribuidoraTest {
    
    public DistribuidoraTest() {
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
     * Test of getFundacao method, of class Distribuidora.
     */
    @Test
    public void testGetFundacao() {
        System.out.println("getFundacao");
        Distribuidora instance = new Distribuidora();
        Date expResult = null;
        Date result = instance.getFundacao();
        assertEquals(expResult, result);
    }

    /**
     * Test of setFundacao method, of class Distribuidora.
     */
    @Test
    public void testSetFundacao() {
        System.out.println("setFundacao");
        Date fundacao = null;
        Distribuidora instance = new Distribuidora();
        instance.setFundacao(fundacao);
    }

    /**
     * Test of getId method, of class Distribuidora.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Distribuidora instance = new Distribuidora();
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of setId method, of class Distribuidora.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 0;
        Distribuidora instance = new Distribuidora();
        instance.setId(id);
    }

    /**
     * Test of getImagem method, of class Distribuidora.
     */
    @Test
    public void testGetImagem() {
        System.out.println("getImagem");
        Distribuidora instance = new Distribuidora();
        String expResult = null;
        String result = instance.getImagem();
        assertEquals(expResult, result);
    }

    /**
     * Test of setImagem method, of class Distribuidora.
     */
    @Test
    public void testSetImagem() {
        System.out.println("setImagem");
        String imagem = "";
        Distribuidora instance = new Distribuidora();
        instance.setImagem(imagem);
    }

    /**
     * Test of getNome method, of class Distribuidora.
     */
    @Test
    public void testGetNome() {
        System.out.println("getNome");
        Distribuidora instance = new Distribuidora();
        String expResult = null;
        String result = instance.getNome();
        assertEquals(expResult, result);
    }

    /**
     * Test of setNome method, of class Distribuidora.
     */
    @Test
    public void testSetNome() {
        System.out.println("setNome");
        String nome = "";
        Distribuidora instance = new Distribuidora();
        instance.setNome(nome);
    }
}
