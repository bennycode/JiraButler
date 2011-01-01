package de.angelcode.jirabutler.webserver;

import de.angelcode.jirabutler.hook.JiraServiceHook;
import de.angelcode.jirabutler.util.SystemVariables;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;

/**
 *
 * @author Benny Neugebauer (Matr.-Nr. 20072076)
 */
public class ServerFunctionality
{

  private static String serverResponse = null;

  /**
   * Verwaltet die Client-Anfragen (PUT, GET, HTTP-GET).
   * @param clientInput Eingabe vom Client
   */
  public static void handleRequest(String clientInput)
  {
    if (clientInput != null)
    {
      // Handle HTTP-GET
      if (clientInput.startsWith("GET"))
      {
        // HTTP/1.1 GET-request
        if (clientInput.contains("HTTP/1.1"))
        {
          doHttpRequest(clientInput);
        }
      }
      else
      {
        // Handle HTTP-POST
        if (clientInput.startsWith("POST"))
        {
          // Recognize github's payload
          if (clientInput.contains("payload="))
          {
            try
            {
              JiraServiceHook hook = new JiraServiceHook(clientInput);
            }
            catch (UnsupportedEncodingException ex)
            {
              //
            }
            catch(ParseException ex)
            {
              //
            }
          }
        }
      }
    }
  }

  /**
   * Initiates HTTP-GET/1.1-Response.
   * @param clientInput Input from the client
   */
  private static void doHttpRequest(String clientInput)
  {
    int temp;
    String fileName;
    // Removing GET and trailing "/" from the request
    String lineCache = clientInput.substring(5, clientInput.length());
    // Look if it is a valid HTTP/1.1 request
    if (lineCache.contains("HTTP/1.1"))
    {
      temp = lineCache.indexOf("HTTP/1.1");
      fileName = lineCache.substring(0, temp);
      doHttpResponse(fileName);
    }
    else
    {
      serverResponse = "Invalid request from client.";
    }
  }

  /**
   * Returns the server-repsonse.
   * @return Server-Response
   */
  public static String getServerResponse()
  {
    return serverResponse;
  }

  /**
   * Reads the content of a file.
   * @param fileName Path to the file
   * @return file-content
   */
  private static String getFileContent(String fileName)
  {
    StringBuilder sb = new StringBuilder();

    try
    {
      BufferedReader reader = new BufferedReader(new FileReader(fileName));
      char[] readerContent = new char[1];
      while (reader.read(readerContent) != -1)
      {
        sb.append(readerContent[0]);
      }
      reader.close();
    }
    catch (Exception ex1)
    {
      serverResponse = "Error while reading the file.";
      serverResponse += ex1.getLocalizedMessage();
      return serverResponse;
    }

    return sb.toString();
  }

  /**
   * Generates the HTTP-GET/1.1-Response.
   * @param fileName File that is requested by the client
   */
  private static void doHttpResponse(String fileName)
  {
    File requestedFile = new File(fileName);
    boolean isFile = requestedFile.exists();
    if (isFile)
    {
      serverResponse = "HTTP/1.1 200 OK" + "\r\n"
              + "Server: MyServer/0.0.1 (Windows)" + "\r\n"
              + "Content-Length: "
              + requestedFile.length() + "\r\n"
              + "Content-Language: de" + "\r\n"
              + "Content-Type: text/html" + "\r\n"
              + "Connection: close" + "\r\n"
              + "\r\n"
              + getFileContent(fileName);
    }
    else
    {
      File html404 = new File(SystemVariables.getJarExecutionDirectory()
              + "404.html");
      serverResponse = "HTTP/1.1 404 Not Found" + "\r\n"
              + "Server: MyServer/0.0.1 (Windows)" + "\r\n"
              + "Content-Type: text/html" + "\r\n"
              + "Content-Length: "
              + html404.length() + "\r\n"
              + "Content-Language: de" + "\r\n"
              + "Connection: close" + "\r\n"
              + "\r\n"
              + getFileContent(html404.getAbsolutePath());
    }
  }
}
