package de.angelcode.jirabutler.util;

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
public class SystemVariablesTest
{

  public SystemVariablesTest()
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
   * Test of getJarExecutionDirectory method, of class SystemVariables.
   */
  @Test
  public void testGetJarExecutionDirectory()
  {
    System.out.println("getJarExecutionDirectory");
    String expResult = "";
    String result = SystemVariables.getJarExecutionDirectory();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }
}
