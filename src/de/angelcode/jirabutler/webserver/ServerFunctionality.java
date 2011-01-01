package de.angelcode.jirabutler.webserver;

import de.angelcode.jirabutler.util.SystemVariables;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

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
      if (clientInput.startsWith("PUT"))
      {
        doPut(clientInput);
      }
      else
      {
        if (clientInput.startsWith("GET"))
        {
          if (clientInput.contains("HTTP/1.1"))
          {
            doHttpRequest(clientInput);
          }
          else
          {
            doGet(clientInput);
          }
        }
        /* TODO: GITHUB */
        else
        {
          if (clientInput.startsWith("POST"))
          {
            System.out.println("GITHUB!");
          }
          else
          {
            System.out.println("Ungültige Client-Anfrage.");
          }
        }
      }
    }
    else
    {
      System.out.println("Ungültige Client-Anfrage.");
    }
  }

  /**
   * Baut die PUT-Response zusammen.
   * @param clientInput Eingabe vom Client
   */
  private static void doPut(String clientInput)
  {
    String fileName = null;
    String fileContent = null;
    int temp = 0;
    // PUT von der Benutzereingabe entfernen:
    String lineCache = clientInput.substring(4, clientInput.length());
    // PUT-Kommando vom PUT-Inhalt trennen:
    // 1. Zeile = Kommando
    // Alle weiteren Zeilen = Inhalt
    System.out.println(lineCache);
    if (lineCache.contains("\n"))
    {
      temp = lineCache.indexOf("\n");
      // Dateinamen und Inhalt in Variablen ablegen:
      fileName = lineCache.substring(0, temp);
      fileContent = lineCache.substring(temp + 1, lineCache.length());

      // Datei auf Server speichern:
      try
      {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        writer.write(fileContent);
        writer.close();
        serverResponse = "Die Datei wurde erfolgreich auf dem Server gespeichert.";
      }
      catch (IOException ex1)
      {
        serverResponse = "Datei konnte nicht geschrieben werden.";
        serverResponse += ex1.getLocalizedMessage();
      }
      catch (Exception ex2)
      {
        serverResponse = "Unbekannter Fehler.";
        serverResponse += ex2.getLocalizedMessage();
      }
    }
    else
    {
      System.out.println("HIER KRACHT ES!!!!!!");
      serverResponse = "Ungültige Client-Anfrage.";
    }
  }

  /**
   * Baut die GET-Response zusammen.
   * @param clientInput Eingabe vom Client
   */
  private static void doGet(String clientInput)
  {
    int temp;
    String fileName;
    String fileContent = null;
    // GET von der Benutzereingabe entfernen:
    String lineCache = clientInput.substring(4, clientInput.length());
    // GET-Kommando vom PUT-Inhalt trennen:
    if (lineCache.contains("\n"))
    {
      temp = lineCache.indexOf("\n");
      fileName = lineCache.substring(0, temp);
      fileContent = getFileContent(fileName);
      if (fileContent != null)
      {
        serverResponse = fileContent;
      }
      else
      {
        serverResponse = "Die angeforderte Datei kann nicht übertragen werden.";
      }
    }
  }

  /**
   * Leitet die HTTP-GET/1.1-Response ein.
   * @param clientInput Eingabe vom Client
   */
  private static void doHttpRequest(String clientInput)
  {
    int temp;
    String fileName;
    // GET und führenden "/" von der Benutzereingabe entfernen:
    String lineCache = clientInput.substring(5, clientInput.length());
    // Schauen, ob korrekter HTTP/1.1-Request:
    if (lineCache.contains("HTTP/1.1"))
    {
      temp = lineCache.indexOf("HTTP/1.1");
      fileName = lineCache.substring(0, temp);
      doHttpResponse(fileName);
    }
    else
    {
      serverResponse = "Ungültige Client-Anfrage.";
    }
  }

  /**
   * Gibt die Server-Response aus.
   * @return Server-Response
   */
  public static String getServerResponse()
  {
    return serverResponse;
  }

  /**
   * Liest den Inhalt aus einer Datei.
   * @param fileName Pfad zur Datei
   * @return Dateiinhalt
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
      serverResponse = "Fehler beim Lesen der angeforderten Datei.";
      serverResponse += ex1.getLocalizedMessage();
      return serverResponse;
    }

    return sb.toString();
  }

  /**
   * Baut die HTTP-GET/1.1-Response zusammen.
   * @param fileName Datei, die über HTTP-GET abgerufen werden soll
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
              + System.getProperty("file.separator")
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
