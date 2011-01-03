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
public class ServerFunctionalityTest
{

  public ServerFunctionalityTest()
  {
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
  public void setUp()
  {
  }

  @After
  public void tearDown()
  {
  }

  /**
   * Test of handleRequest method, of class ServerFunctionality.
   */
  @Test
  public void testHandleRequest() throws Exception
  {
    System.out.println("handleRequest");
    String clientInput = "";
    ServerFunctionality.handleRequest(clientInput);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of getServerResponse method, of class ServerFunctionality.
   */
  @Test
  public void testGetServerResponse()
  {
    System.out.println("getServerResponse");
    String expResult = "";
    String result = ServerFunctionality.getServerResponse();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }
}
