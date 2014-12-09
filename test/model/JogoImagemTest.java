package model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class JogoImagemTest {
    
    public JogoImagemTest() {
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
     * Test of getSequencia method, of class JogoImagem.
     */
    @Test
    public void testGetSequencia() {
        System.out.println("getSequencia");
        JogoImagem instance = new JogoImagem();
        int expResult = 0;
        int result = instance.getSequencia();
        assertEquals(expResult, result);
    }

    /**
     * Test of setSequencia method, of class JogoImagem.
     */
    @Test
    public void testSetSequencia() {
        System.out.println("setSequencia");
        int sequencia = 0;
        JogoImagem instance = new JogoImagem();
        instance.setSequencia(sequencia);
    }

    /**
     * Test of getIdJogo method, of class JogoImagem.
     */
    @Test
    public void testGetIdJogo() {
        System.out.println("getIdJogo");
        JogoImagem instance = new JogoImagem();
        int expResult = 0;
        int result = instance.getIdJogo();
        assertEquals(expResult, result);
    }

    /**
     * Test of setIdJogo method, of class JogoImagem.
     */
    @Test
    public void testSetIdJogo() {
        System.out.println("setIdJogo");
        int idJogo = 0;
        JogoImagem instance = new JogoImagem();
        instance.setIdJogo(idJogo);
    }

    /**
     * Test of getImagem method, of class JogoImagem.
     */
    @Test
    public void testGetImagem() {
        System.out.println("getImagem");
        JogoImagem instance = new JogoImagem();
        String expResult = "";
        String result = instance.getImagem();
        assertEquals(expResult, result);
    }

    /**
     * Test of setImagem method, of class JogoImagem.
     */
    @Test
    public void testSetImagem() {
        System.out.println("setImagem");
        String imagem = "";
        JogoImagem instance = new JogoImagem();
        instance.setImagem(imagem);
    }
}
