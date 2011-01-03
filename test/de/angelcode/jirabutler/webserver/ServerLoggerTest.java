/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package de.angelcode.jirabutler.webserver;

import org.apache.log4j.Logger;
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
public class ServerLoggerTest {

    public ServerLoggerTest() {
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
   * Test of getServerLogger method, of class ServerLogger.
   */
  @Test
  public void testGetServerLogger() throws Exception
  {
    System.out.println("getServerLogger");
    String logFilePath = "";
    Logger expResult = null;
    Logger result = ServerLogger.getServerLogger(logFilePath);
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

}