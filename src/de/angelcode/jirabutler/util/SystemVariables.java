package de.angelcode.jirabutler.util;

/**
 * This class can deliver some system-relevant information like the execution path of the application's JAR file.
 * @author bennyn
 */
public class SystemVariables
{

  /**
   * Returns the path where the currently running JAR-file is located.
   * Example value: C:\MyProject\build\jar\
   * @return Path of the JAR-file
   */
  public static String getJarExecutionDirectory()
  {
    String jarFile = null;
    String jarDirectory = null;
    int cutFileSeperator = 0;
    int cutSemicolon = -1;

    jarFile = System.getProperty("java.class.path");
    // Cut seperators
    cutFileSeperator = jarFile.lastIndexOf(System.getProperty("file.separator"));
    jarDirectory = jarFile.substring(0, cutFileSeperator);
    // Cut semicolons
    cutSemicolon = jarDirectory.lastIndexOf(';');
    jarDirectory = jarDirectory.substring(cutSemicolon+1, jarDirectory.length());

    return jarDirectory+System.getProperty("file.separator");
  }
}
