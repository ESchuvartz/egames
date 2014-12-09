package model;

import java.sql.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
public class AvaliacaoTest {
    
    public AvaliacaoTest() {
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
     * Test of getAvaliador method, of class Avaliacao.
     */
    @Test
    public void testGetAvaliador() {
        System.out.println("getAvaliador");
        Avaliacao instance = new Avaliacao();
        String expResult = "";
        String result = instance.getAvaliador();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAvaliador method, of class Avaliacao.
     */
    @Test
    public void testSetAvaliador() {
        System.out.println("setAvaliador");
        String avaliador = "";
        Avaliacao instance = new Avaliacao();
        instance.setAvaliador(avaliador);
    }

    /**
     * Test of getData method, of class Avaliacao.
     */
    @Test
    public void testGetData() {
        System.out.println("getData");
        Avaliacao instance = new Avaliacao();
        Date expResult = null;
        Date result = instance.getData();
        assertEquals(expResult, result);
    }

    /**
     * Test of setData method, of class Avaliacao.
     */
    @Test
    public void testSetData() {
        System.out.println("setData");
        Date data = null;
        Avaliacao instance = new Avaliacao();
        instance.setData(data);
    }

    /**
     * Test of getId method, of class Avaliacao.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Avaliacao instance = new Avaliacao();
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of setId method, of class Avaliacao.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 0;
        Avaliacao instance = new Avaliacao();
        instance.setId(id);
    }

    /**
     * Test of getIdJogo method, of class Avaliacao.
     */
    @Test
    public void testGetIdJogo() {
        System.out.println("getIdJogo");
        Avaliacao instance = new Avaliacao();
        int expResult = 0;
        int result = instance.getIdJogo();
        assertEquals(expResult, result);
    }

    /**
     * Test of setIdJogo method, of class Avaliacao.
     */
    @Test
    public void testSetIdJogo() {
        System.out.println("setIdJogo");
        int idJogo = 0;
        Avaliacao instance = new Avaliacao();
        instance.setIdJogo(idJogo);
    }

    /**
     * Test of getNota method, of class Avaliacao.
     */
    @Test
    public void testGetNota() {
        System.out.println("getNota");
        Avaliacao instance = new Avaliacao();
        int expResult = 0;
        int result = instance.getNota();
        assertEquals(expResult, result);
    }

    /**
     * Test of setNota method, of class Avaliacao.
     */
    @Test
    public void testSetNota() {
        System.out.println("setNota");
        int nota = 0;
        Avaliacao instance = new Avaliacao();
        instance.setNota(nota);
    }

    /**
     * Test of getObservacao method, of class Avaliacao.
     */
    @Test
    public void testGetObservacao() {
        System.out.println("getObservacao");
        Avaliacao instance = new Avaliacao();
        String expResult = "";
        String result = instance.getObservacao();
        assertEquals(expResult, result);
    }

    /**
     * Test of setObservacao method, of class Avaliacao.
     */
    @Test
    public void testSetObservacao() {
        System.out.println("setObservacao");
        String observacao = "";
        Avaliacao instance = new Avaliacao();
        instance.setObservacao(observacao);
    }

    /**
     * Test of validaCampos method, of class Avaliacao.
     */
    @Test
    public void testValidaCampos() {
        System.out.println("validaCampos");
        Avaliacao instance = new Avaliacao();
        boolean expResult = false;
        boolean result = instance.validaCampos();
        assertEquals(expResult, result);
    }
    
}
