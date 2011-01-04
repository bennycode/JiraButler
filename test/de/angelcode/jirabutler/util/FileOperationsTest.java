package de.angelcode.jirabutler.util;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author bennyn
 */
public class FileOperationsTest
{

  /**
   * Tests if it is possible to get the content of a file.
   */
  @Test
  public void testGetFileContent()
  {
    String readmePath = SystemVariables.getJarExecutionDirectory() + "readme.txt";    
    String result = FileOperations.getFileContent(readmePath);

    assertNull("Test if the directory, from which the JAR file is executed, can be found.", result);
  }
}
