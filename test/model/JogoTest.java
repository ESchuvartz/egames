package model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class JogoTest {
    
    public JogoTest() {
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
     * Test of getClassificacao method, of class Jogo.
     */
    @Test
    public void testGetClassificacao() {
        System.out.println("getClassificacao");
        Jogo instance = new Jogo();
        double expResult = 0.0;
        double result = instance.getClassificacao();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setClassificacao method, of class Jogo.
     */
    @Test
    public void testSetClassificacao() {
        System.out.println("setClassificacao");
        double classificacao = 0.0;
        Jogo instance = new Jogo();
        instance.setClassificacao(classificacao);
    }

    /**
     * Test of getNome method, of class Jogo.
     */
    @Test
    public void testGetNome() {
        System.out.println("getNome");
        Jogo instance = new Jogo();
        String expResult = null;
        String result = instance.getNome();
        assertEquals(expResult, result);
    }

    /**
     * Test of setNome method, of class Jogo.
     */
    @Test
    public void testSetNome() {
        System.out.println("setNome");
        String nome = "";
        Jogo instance = new Jogo();
        instance.setNome(nome);
    }

    /**
     * Test of getId method, of class Jogo.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Jogo instance = new Jogo();
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of setId method, of class Jogo.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 0;
        Jogo instance = new Jogo();
        instance.setId(id);
    }

    /**
     * Test of getReview method, of class Jogo.
     */
    @Test
    public void testGetReview() {
        System.out.println("getReview");
        Jogo instance = new Jogo();
        String expResult = null;
        String result = instance.getReview();
        assertEquals(expResult, result);
    }

    /**
     * Test of setReview method, of class Jogo.
     */
    @Test
    public void testSetReview() {
        System.out.println("setReview");
        String review = "";
        Jogo instance = new Jogo();
        instance.setReview(review);
    }

    /**
     * Test of getValor method, of class Jogo.
     */
    @Test
    public void testGetValor() {
        System.out.println("getValor");
        Jogo instance = new Jogo();
        double expResult = 0.0;
        double result = instance.getValor();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setValor method, of class Jogo.
     */
    @Test
    public void testSetValor() {
        System.out.println("setValor");
        double valor = 0.0;
        Jogo instance = new Jogo();
        instance.setValor(valor);
    }

    /**
     * Test of getIdDistribuidora method, of class Jogo.
     */
    @Test
    public void testGetIdDistribuidora() {
        System.out.println("getIdDistribuidora");
        Jogo instance = new Jogo();
        int expResult = 0;
        int result = instance.getIdDistribuidora();
        assertEquals(expResult, result);
    }

    /**
     * Test of setIdDistribuidora method, of class Jogo.
     */
    @Test
    public void testSetIdDistribuidora() {
        System.out.println("setIdDistribuidora");
        int idDistribuidora = 0;
        Jogo instance = new Jogo();
        instance.setIdDistribuidora(idDistribuidora);
    }

    /**
     * Test of getIdGenero method, of class Jogo.
     */
    @Test
    public void testGetIdGenero() {
        System.out.println("getIdGenero");
        Jogo instance = new Jogo();
        int expResult = 0;
        int result = instance.getIdGenero();
        assertEquals(expResult, result);
    }

    /**
     * Test of setIdGenero method, of class Jogo.
     */
    @Test
    public void testSetIdGenero() {
        System.out.println("setIdGenero");
        int idGenero = 0;
        Jogo instance = new Jogo();
        instance.setIdGenero(idGenero);
    }

    /**
     * Test of getIdFaixaEtaria method, of class Jogo.
     */
    @Test
    public void testGetIdFaixaEtaria() {
        System.out.println("getIdFaixaEtaria");
        Jogo instance = new Jogo();
        int expResult = 0;
        int result = instance.getIdFaixaEtaria();
        assertEquals(expResult, result);
    }

    /**
     * Test of setIdFaixaEtaria method, of class Jogo.
     */
    @Test
    public void testSetIdFaixaEtaria() {
        System.out.println("setIdFaixaEtaria");
        int idFaixaEtaria = 0;
        Jogo instance = new Jogo();
        instance.setIdFaixaEtaria(idFaixaEtaria);
    }

    /**
     * Test of getIdDeposito method, of class Jogo.
     */
    @Test
    public void testGetIdDeposito() {
        System.out.println("getIdDeposito");
        Jogo instance = new Jogo();
        int expResult = 0;
        int result = instance.getIdDeposito();
        assertEquals(expResult, result);
    }

    /**
     * Test of setIdDeposito method, of class Jogo.
     */
    @Test
    public void testSetIdDeposito() {
        System.out.println("setIdDeposito");
        int idDeposito = 0;
        Jogo instance = new Jogo();
        instance.setIdDeposito(idDeposito);
    }
}
