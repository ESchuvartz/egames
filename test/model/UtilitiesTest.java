/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.awt.Image;
import java.io.File;
import java.sql.Date;
import javax.swing.JDialog;
import javax.swing.JFrame;
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
public class UtilitiesTest {
    
    public UtilitiesTest() {
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
     * Test of copiaImagem method, of class Utilities.
     */
    @Test
    public void testCopiaImagem() {
        System.out.println("copiaImagem");
        String sImagem = "";
        String sDiretorio = "";
        Utilities instance = new Utilities();
        String expResult = "";
        String result = instance.copiaImagem(sImagem, sDiretorio);
        assertEquals(expResult, result);
    }

    /**
     * Test of converteData method, of class Utilities.
     */
    @Test
    public void testConverteData() {
        System.out.println("converteData");
        String sData = "";
        Utilities instance = new Utilities();
        Date expResult = null;
        Date result = instance.converteData(sData);
        assertEquals(expResult, result);
    }

    /**
     * Test of ajustaData method, of class Utilities.
     */
    @Test
    public void testAjustaData() {
        System.out.println("ajustaData");
        Date dData = null;
        Utilities instance = new Utilities();
        String expResult = "";
        String result = instance.ajustaData(dData);
        assertEquals(expResult, result);
    }

    /**
     * Test of criaPasta method, of class Utilities.
     */
    @Test
    public void testCriaPasta() {
        System.out.println("criaPasta");
        String CaminhoNome = "";
        Utilities instance = new Utilities();
        File expResult = null;
        File result = instance.criaPasta(CaminhoNome);
        assertEquals(expResult, result);
    }

    /**
     * Test of centralizarFrame method, of class Utilities.
     */
    @Test
    public void testCentralizarFrame() {
        System.out.println("centralizarFrame");
        JFrame obj = null;
        Utilities instance = new Utilities();
        instance.centralizarFrame(obj);
    }

    /**
     * Test of centralizarDialog method, of class Utilities.
     */
    @Test
    public void testCentralizarDialog() {
        System.out.println("centralizarDialog");
        JDialog obj = null;
        Utilities instance = new Utilities();
        instance.centralizarDialog(obj);
    }

    /**
     * Test of adicionarIcone method, of class Utilities.
     */
    @Test
    public void testAdicionarIcone() {
        System.out.println("adicionarIcone");
        String sIcone = "";
        Utilities instance = new Utilities();
        Image expResult = null;
        Image result = instance.adicionarIcone(sIcone);
        assertEquals(expResult, result);
    }

    /**
     * Test of ajustaDecimais method, of class Utilities.
     */
    @Test
    public void testAjustaDecimais() {
        System.out.println("ajustaDecimais");
        Double valor = null;
        Utilities instance = new Utilities();
        String expResult = "";
        String result = instance.ajustaDecimais(valor);
        assertEquals(expResult, result);
    }
    
}
