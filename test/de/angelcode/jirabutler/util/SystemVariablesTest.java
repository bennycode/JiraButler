package de.angelcode.jirabutler.util;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author danielp
 */
public class SystemVariablesTest
{

  private String path;

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
  @Test(expected = IllegalArgumentException.class)
  public void testGetJarExecutionDirectoryIfTheKeyIsEmpty()
  {
    SystemVariables.setJavaClassPath("");
    SystemVariables.setFileSeperator("");
    this.path = SystemVariables.getJarExecutionDirectory();
  }

  /**
   * Test of getJarExecutionDirectory method, of class SystemVariables.
   */
  @Test(expected = NullPointerException.class)
  public void testGetJarExecutionDirectoryIfTheKeyIsNull()
  {
    SystemVariables.setJavaClassPath(null);
    SystemVariables.setFileSeperator(null);
    this.path = SystemVariables.getJarExecutionDirectory();
  }
}
