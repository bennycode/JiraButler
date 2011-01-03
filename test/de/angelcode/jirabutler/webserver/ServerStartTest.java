/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package de.angelcode.jirabutler.webserver;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author BoatoonAdmin
 */
public class ServerStartTest {

    public ServerStartTest() {
    }

  @BeforeClass
  public static void setUpClass() throws Exception
  {
  }

  @AfterClass
  public static void tearDownClass() throws Exception
  {
  }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

  /**
   * Test of main method, of class ServerStart.
   */
  @Test
  public void testMain()
  {
    System.out.println("main");
    String[] argv = null;
    ServerStart.main(argv);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

}