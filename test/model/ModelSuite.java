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
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Eduardo
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({model.AvaliacaoTest.class, model.DistribuidoraTest.class, model.JogoImagemTest.class, model.DepositoTest.class, model.GeneroTest.class, model.UtilitiesTest.class, model.JogoTest.class, model.FaixaEtariaTest.class, model.JogoDepTest.class})
public class ModelSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
