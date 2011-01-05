package de.angelcode.jirabutler.util;

import de.angelcode.jirabutler.webserver.Server;
import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Class for standard file operations.
 * @author bennyn
 */
public class FileOperations
{

  /**
   * Returns the content of a file.
   * @param filePath Absolute path to the file
   * @return file-content
   */
  public static String getFileContent(String filePath)
  {
    StringBuilder sb = new StringBuilder();
    
    try
    {
      BufferedReader reader = new BufferedReader(new FileReader(filePath));
      char[] readerContent = new char[1];
      while (reader.read(readerContent) != -1)
      {
        sb.append(readerContent[0]);
      }
      reader.close();
    }
    catch (Exception ex)
    {
      return null;
    }

    return sb.toString();
  }
}
