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
public class ConnectionHandlerTest {

    public ConnectionHandlerTest() {
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
   * Test of startThread method, of class ConnectionHandler.
   */
  @Test
  public void testStartThread()
  {
    System.out.println("startThread");
    ConnectionHandler instance = null;
    instance.startThread();
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of run method, of class ConnectionHandler.
   */
  @Test
  public void testRun()
  {
    System.out.println("run");
    ConnectionHandler instance = null;
    instance.run();
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

}