package de.angelcode.jirabutler.util;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author danielp
 */
public class SystemVariablesTest
{

  /**
   * Test of getJarExecutionDirectory method, of class SystemVariables.
   */
  @Test
  public void testGetJarExecutionDirectory()
  {
    String result = SystemVariables.getJarExecutionDirectory();
    assertNotNull("Test if the directory, from which the JAR file is executed, can be found.", result);
  }
}
